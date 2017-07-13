package com.vis.merna.spaintask.ServiceLayer;

import android.util.Log;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by Merna on 09/07/2017.
 */

public class RequestManager {

    public static void callWebServiceUsingGET(String url, final Map<String, Object> params, final RequestCallback requestCallback) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url+"?");
        for(String key : params.keySet()){
            stringBuilder.append(key+"="+params.get(key)+"&");
        }
        String str = stringBuilder.toString();
        Log.i("TAG", "RequestMAnager: callWebServiceUsingGET: url: "+ str);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, str,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        requestCallback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestCallback.onError(error);
            }

        });

        VolleyRequest.getInstance().addToRequestQueue(stringRequest);
    }
    public static void callWebServiceUsingPOST(String url, final Map<String, Object> params, final RequestCallback requestCallback){}

}
