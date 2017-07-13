package com.vis.merna.spaintask.DataLayer.Managers;

import android.util.Log;

import com.android.volley.VolleyError;
import com.vis.merna.spaintask.ServiceLayer.RequestCallback;
import com.vis.merna.spaintask.ServiceLayer.RequestManager;
import com.vis.merna.spaintask.UI.Presenter.Interfaces.ILogin;
import com.vis.merna.spaintask.Utils.Constants;
import com.vis.merna.spaintask.Utils.SharedPref;
import com.vis.merna.spaintask.Utils.URLs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Merna on 08/07/2017.
 */

public class LoginManager implements ILogin.ILoginModel {

    private ILogin.ILoginPresenter presenter;

    public LoginManager(ILogin.ILoginPresenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void login(String msisdn, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("password", password);
        params.put("msisdn", msisdn);
        RequestManager.callWebServiceUsingGET(URLs.LOGIN_URL, params, new RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Log.i("TAG", "loginPresenter: onSuccess: response: "+ response);

                //1. Save token
                SharedPref.saveString(Constants.PREF_USER_KEY, response);
                //2.complete ui operations
                presenter.loginSucceeded();
            }

            @Override
            public void onError(VolleyError volleyError) {
                Log.i("TAG", "LoginPresenter.java: onError: "+ volleyError.toString());
                presenter.loginFailed("Login Error", "Connection Error. Please Try Again.");
            }
        });
    }
}
