package com.vis.merna.spaintask.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vis.merna.spaintask.R;
import com.vis.merna.spaintask.UI.Fragment.HomeFragment;


public class
MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}
