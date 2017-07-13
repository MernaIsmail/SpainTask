package com.vis.merna.spaintask.UI.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vis.merna.spaintask.R;
import com.vis.merna.spaintask.UI.Fragment.LoginFragment;
import com.vis.merna.spaintask.UI.Presenter.Interfaces.ILogin;

public class LoginActivity extends BaseActivity implements ILogin.ILoginActivity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_fragment);
    }

    @Override
    public void goToNextActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        //close login activity
        finish();
    }
}
