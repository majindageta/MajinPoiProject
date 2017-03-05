package com.majin.mappoi.Model.Services;

import android.content.Context;

import org.json.JSONException;

/**
 * Created by davidericci on 02/03/17.
 */

public class MockService implements IService {

    private Context context_;

    public MockService(android.content.Context context) {
        this.context_ = context;
    }

    public void setContext(Context context_) {
        this.context_ = context_;
    }

    @Override
    public void doLogin(String name, String password) throws JSONException {

    }

    @Override
    public void getPoint(Number latitude, Number longitude) throws JSONException {

    }

    //here put mock version of methods defined in the IService Interface
}
