package com.vis.merna.spaintask.UI.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vis.merna.spaintask.DataLayer.Models.Product;
import com.vis.merna.spaintask.R;
import com.vis.merna.spaintask.SpainApp;
import com.vis.merna.spaintask.UI.Adapter.ProductAdapter;
import com.vis.merna.spaintask.Utils.Constants;

import java.util.ArrayList;
import java.util.List;


public class ProductsFragment extends Fragment {

    private List<Product> products = new ArrayList<>();
    private RecyclerView productsRecycleView;
    private ProductAdapter productAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        products = (List<Product>) getArguments().getSerializable(Constants.PRODUCT_LIST_BUNDLE);

        View rootView = inflater.inflate(R.layout.fragment_products, container, false);
        productsRecycleView = rootView.findViewById(R.id.recycler_view);
        productAdapter = new ProductAdapter(products);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SpainApp.getInstance());
        productsRecycleView.setLayoutManager(mLayoutManager);
        productsRecycleView.setItemAnimator(new DefaultItemAnimator());
        productsRecycleView.setAdapter(productAdapter);
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}
