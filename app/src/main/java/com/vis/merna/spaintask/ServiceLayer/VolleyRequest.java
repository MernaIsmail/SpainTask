package com.vis.merna.spaintask.ServiceLayer;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.vis.merna.spaintask.SpainApp;

/**
 * Created by Merna on 09/07/2017.
 */

public class VolleyRequest {


    private static VolleyRequest volleyRequestInstance;
    private RequestQueue requestQueue;

    private VolleyRequest(){
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleyRequest getInstance() {
        if (volleyRequestInstance == null) {
            volleyRequestInstance = new VolleyRequest();
        }
        return volleyRequestInstance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(SpainApp.getInstance());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void cancelRequestFromQueue(String tag){
        if(requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }

}
