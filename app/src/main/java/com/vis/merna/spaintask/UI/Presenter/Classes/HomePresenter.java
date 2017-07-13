package com.vis.merna.spaintask.UI.Presenter.Classes;

import com.vis.merna.spaintask.DataLayer.Managers.HomeManager;
import com.vis.merna.spaintask.DataLayer.Models.Product;
import com.vis.merna.spaintask.UI.Presenter.Interfaces.IHome;

import java.util.ArrayList;

/**
 * Created by Merna on 09/07/2017.
 */

public class HomePresenter implements IHome.IHomePresenter {

    private IHome.IHomeFragement iHomeFragement;
    private  IHome.IHomeModel iHomeModel;

    public HomePresenter(IHome.IHomeFragement iHomeFragement) {
        this.iHomeFragement = iHomeFragement;
        iHomeModel = new HomeManager(this);
    }

    @Override
    public void getProducts(String token) {
         iHomeModel.getProducts(token);
    }

    @Override
    public void getProductsSucceeded(ArrayList<Product> products) {
        iHomeFragement.replaceFragment(products);
    }

    @Override
    public void getProductsFailed(String title, String msg) {

    }
}
