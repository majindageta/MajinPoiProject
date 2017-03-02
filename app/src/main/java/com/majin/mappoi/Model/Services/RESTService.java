package com.majin.mappoi.Model.Services;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.majin.mappoi.Utilities.Logger;
import com.majin.mappoi.Utilities.SharedPreferencesManager;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by davidericci on 02/03/17.
 */

public class RESTService implements IService{

    private Context context_;

    private RequestQueue requestQueue_;

    public RESTService(Context context) {
        this.context_ = context;
        this.requestQueue_ = Volley.newRequestQueue(context);
    }

    public void setContext(Context context) {
        this.context_ = context;

    }


    private JSONObject buildDefaultRequestHeader(JSONObject request) throws JSONException {
        try {
            SharedPreferencesManager pref = SharedPreferencesManager.getManager(context_);
            request.put("access_token", "TOKEN");

            return request;
        } catch (Exception e) {
            Logger.getInstance(context_).error("RestServices > buildDefaultRequestHeader", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
