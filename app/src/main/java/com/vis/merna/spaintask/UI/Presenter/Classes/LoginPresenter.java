package com.vis.merna.spaintask.UI.Presenter.Classes;

import com.vis.merna.spaintask.DataLayer.Managers.LoginManager;
import com.vis.merna.spaintask.UI.Presenter.Interfaces.ILogin;

/**
 * Created by Merna on 08/07/2017.
 */

public class LoginPresenter implements ILogin.ILoginPresenter{

    private ILogin.ILoginFragment loginFragment;
    private ILogin.ILoginModel model;

    public LoginPresenter(ILogin.ILoginFragment loginFragment) {
        this.loginFragment = loginFragment;
        model = new LoginManager(this);
    }


    @Override
    public void login(String msisdn, String password) {
        model.login(msisdn,password);
    }

    @Override
    public void loginSucceeded() {
        loginFragment.loginSucceeded();
    }

    @Override
    public void loginFailed(String title, String msg) {
        loginFragment.loginFailed(title,msg);
    }

}
