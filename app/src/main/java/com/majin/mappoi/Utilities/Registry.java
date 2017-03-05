package com.majin.mappoi.Utilities;

/**
 * Created by Majin on 05/03/2017.
 */

public class Registry {

    Registry instance;

    public Registry getInstance() {

        if (instance == null) {
            instance = new Registry();
        }

        return instance;
    }
}
