package com.vis.merna.spaintask.UI.Presenter.Interfaces;

/**
 * Created by Merna on 08/07/2017.
 */

public interface ILogin {

    interface ILoginActivity{
        public void goToNextActivity();
    }

    interface ILoginFragment{
        public void loginSucceeded();
        public void loginFailed(String title, String msg);
    }

    interface ILoginPresenter{
        public void login(String msisdn, String password);
        public void loginFailed(String title, String msg);
        public void loginSucceeded();
    }

    interface ILoginModel{
        public void login(String msisdn, String password);
    }
}
