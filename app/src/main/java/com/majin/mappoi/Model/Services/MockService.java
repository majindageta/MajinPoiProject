package com.majin.mappoi.Model.Services;

import android.content.Context;

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

    //here put mock version of methods defined in the IService Interface
}
