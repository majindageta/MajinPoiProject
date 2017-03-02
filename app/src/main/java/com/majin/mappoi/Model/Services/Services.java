package com.majin.mappoi.Model.Services;

import android.content.Context;
/**
 * Created by davidericci on 02/03/17.
 */

public class Services {

    private static Services INSTANCE = null;

    private IService currentImplementation_ = null;

    private Services(Context context) {
//        if(Config.getInstance(context).isMock()){
            currentImplementation_ = new MockService( context );
//        } else {
//            currentImplementation_ = new RESTServices( context );
//        }
    }

    public static Services getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Services(context);
        }
        INSTANCE.currentImplementation_.setContext(context);
        return INSTANCE;
    }

    public IService getCurrentImplementation() {
        return currentImplementation_;
    }


    //Use example Services.getInstance(getContext()).getCurrentImplementation().
}
