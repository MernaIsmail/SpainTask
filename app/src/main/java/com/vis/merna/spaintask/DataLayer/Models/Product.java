package com.vis.merna.spaintask.DataLayer.Models;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Merna on 08/07/2017.
 */

public class Product implements Serializable {

    private String url;
    private String icon;
    private String label;
    private String subtitle;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
