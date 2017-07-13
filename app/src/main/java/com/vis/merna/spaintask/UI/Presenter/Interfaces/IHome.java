package com.vis.merna.spaintask.UI.Presenter.Interfaces;

import com.vis.merna.spaintask.DataLayer.Models.Product;

import java.util.ArrayList;

/**
 * Created by Merna on 09/07/2017.
 */

public interface IHome {

    interface IHomeFragement{
        public void replaceFragment(ArrayList<Product> products);
    }

    interface IHomePresenter{
        public void getProducts(String token);
        public void getProductsSucceeded(ArrayList<Product> products);
        public void getProductsFailed(String title, String msg);
    }

    interface IHomeModel{
        public void getProducts(String token);
    }
}
