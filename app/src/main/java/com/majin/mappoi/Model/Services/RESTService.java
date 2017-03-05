package com.majin.mappoi.Model.Services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.majin.mappoi.Events.LoginEvent;
import com.majin.mappoi.Model.Services.Output.LoginOutput;
import com.majin.mappoi.Utilities.CustomEventBus;
import com.majin.mappoi.Utilities.Logger;
import com.majin.mappoi.Utilities.SharedPreferencesManager;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by davidericci on 02/03/17.
 */

public class RESTService implements IService{

    private Context context_;

    private String url = "https://murmuring-retreat-76939.herokuapp.com/api/";

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
            request.put("x-access-token", SharedPreferencesManager.getManager(context_).getSharedPref(SharedPreferencesManager.ACCESS_TOKEN));

            return request;
        } catch (Exception e) {
            Logger.getInstance(context_).error("RestServices > buildDefaultRequestHeader", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void doLogin(final String name, final String password) throws JSONException {

        String path = url + "auth/login";
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", name);
        requestBody.put("password", password);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, path, requestBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        LoginOutput output = new Gson().fromJson(response.toString(), LoginOutput.class);
                        SharedPreferencesManager.getManager(context_).putSharedPref(SharedPreferencesManager.ACCESS_TOKEN, output.getToken());
                        CustomEventBus.getInstance().postLoginEvent(new LoginEvent(output));
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //event
                    }
                })
        {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }
        };
        requestQueue_.add(jsObjRequest);

    }

    @Override
    public void getPoint(Number latitude, Number longitude) throws JSONException {
        JSONObject requestBody = new JSONObject();
        requestBody = buildDefaultRequestHeader(requestBody);
        String path = url + "coord/random";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, path, requestBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //event
                    }
                });
        requestQueue_.add(jsObjRequest);
    }


}
