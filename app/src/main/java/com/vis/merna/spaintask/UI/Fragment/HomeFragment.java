package com.vis.merna.spaintask.UI.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vis.merna.spaintask.DataLayer.Models.Product;
import com.vis.merna.spaintask.DataLayer.Models.User;
import com.vis.merna.spaintask.R;
import com.vis.merna.spaintask.UI.Presenter.Classes.HomePresenter;
import com.vis.merna.spaintask.UI.Presenter.Interfaces.IHome;
import com.vis.merna.spaintask.Utils.Constants;
import com.vis.merna.spaintask.Utils.SharedPref;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IHome.IHomeFragement {

    private IHome.IHomePresenter iHomePresenter;

    private TextView txtUserName;
    private TextView txtUserType;
    private Button btnProducts;
    private User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iHomePresenter = new HomePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        txtUserName = (TextView) rootView.findViewById(R.id.txtUserName);
        txtUserType = (TextView) rootView.findViewById(R.id.txtUserType);
        btnProducts = (Button) rootView.findViewById(R.id.btnProducts);

        setDataIntoUI();

        btnProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iHomePresenter.getProducts(user.getToken());
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void setDataIntoUI() {
        String userJSON = SharedPref.retrieveString(Constants.PREF_USER_KEY);
        if (userJSON != null) {
            user = new Gson().fromJson(userJSON, User.class);
            txtUserName.setText(" " + user.getSurName().toString());
            txtUserType.setText(" " + user.getUserType().toString());
        }
    }

    @Override
    public void replaceFragment(ArrayList<Product> products) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.PRODUCT_LIST_BUNDLE, products);

        ProductsFragment productsFragment = new ProductsFragment();
        productsFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, productsFragment)
                .addToBackStack(null).commit();

    }
}
