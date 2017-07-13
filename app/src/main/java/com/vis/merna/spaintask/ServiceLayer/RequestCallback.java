package com.vis.merna.spaintask.ServiceLayer;

import com.android.volley.VolleyError;

/**
 * Created by Merna on 09/07/2017.
 */

public interface RequestCallback {
    public void onSuccess(String response);
    public void onError(VolleyError volleyError);
}
