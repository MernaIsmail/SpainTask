package com.vis.merna.spaintask.UI.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.vis.merna.spaintask.R;
import com.vis.merna.spaintask.UI.Presenter.Classes.LoginPresenter;
import com.vis.merna.spaintask.UI.Presenter.Interfaces.ILogin;
import com.vis.merna.spaintask.Utils.Alert;

public class LoginFragment extends Fragment implements ILogin.ILoginFragment{

    private ILogin.ILoginPresenter iLoginPresenter;
    private ILogin.ILoginActivity iLoginActivity;

    private EditText edtTxtMsisdn;
    private EditText edtTxtPassword;
    private Button btnSubmit;

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_login, container, false);
        edtTxtMsisdn = (EditText) rootView.findViewById(R.id.edtTxtMsisdn);
        edtTxtPassword = (EditText) rootView.findViewById(R.id.edtTxtPassword);
        btnSubmit = (Button) rootView.findViewById(R.id.btnSubmit);

        progressDialog= new ProgressDialog(getActivity(),
                R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                sendDataToPresenter();
            }
        });
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        iLoginActivity = (ILogin.ILoginActivity) context;
    }

    public void sendDataToPresenter() {
        String msisdn = edtTxtMsisdn.getText().toString();
        String password = edtTxtPassword.getText().toString();

        //pass these params to presenter
        iLoginPresenter.login(msisdn, password);
    }

    @Override
    public void loginSucceeded() {
        iLoginActivity.goToNextActivity();
        progressDialog.dismiss();
    }

    @Override
    public void loginFailed(String title, String msg) {
        progressDialog.dismiss();
        Alert.showErrorMsg(title, msg, getContext());
    }
}
