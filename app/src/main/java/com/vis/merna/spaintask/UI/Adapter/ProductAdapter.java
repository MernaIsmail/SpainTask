package com.vis.merna.spaintask.UI.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vis.merna.spaintask.DataLayer.Models.Product;
import com.vis.merna.spaintask.R;
import com.vis.merna.spaintask.SpainApp;

import java.util.List;

/**
 * Created by Merna on 09/07/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.txtSubTitle.setText(product.getSubtitle().toString());
        holder.txtLabel.setText(product.getLabel().toString());
        Picasso.with(SpainApp.getInstance()).load(product.getIcon())
                .placeholder(R.drawable.placeholder).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtSubTitle,txtLabel;
        private ImageView imgProduct;

        public ViewHolder(View itemView) {
            super(itemView);

            txtSubTitle = (TextView) itemView.findViewById(R.id.txtSubtitle);
            txtLabel = (TextView) itemView.findViewById(R.id.txtLabel);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
        }
    }
}
