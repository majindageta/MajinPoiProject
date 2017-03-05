package com.majin.mappoi.Model.Services;

import android.content.Context;

import org.json.JSONException;

/**
 * Created by davidericci on 02/03/17.
 */

public interface IService {

    public void setContext(Context context);

    public void doLogin(String name, String password) throws JSONException;

    public void getPoint(Number latitude, Number longitude) throws JSONException;

    //Create here your methods
}
