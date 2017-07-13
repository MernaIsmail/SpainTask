package com.vis.merna.spaintask.DataLayer.Managers;

import android.util.Log;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.vis.merna.spaintask.DataLayer.Models.Product;
import com.vis.merna.spaintask.ServiceLayer.RequestCallback;
import com.vis.merna.spaintask.ServiceLayer.RequestManager;
import com.vis.merna.spaintask.UI.Presenter.Interfaces.IHome;
import com.vis.merna.spaintask.Utils.URLs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Merna on 09/07/2017.
 */

public class HomeManager implements IHome.IHomeModel {

    private IHome.IHomePresenter iHomePresenter;

    public HomeManager(IHome.IHomePresenter iHomePresenter) {
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public void getProducts(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        RequestManager.callWebServiceUsingGET(URLs.PRODUCT_URL, params, new RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Log.i("TAG", "HomePresenter: onSuccess: response: " + response);

                JsonObject jsonObj = (JsonObject) new JsonParser().parse(response);
                JsonArray jsonArr = jsonObj.getAsJsonArray("items");
                ArrayList<Product> products = new Gson().fromJson(jsonArr, new TypeToken<List<Product>>() {
                }.getType());

                iHomePresenter.getProductsSucceeded(products);
            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });

    }
}
