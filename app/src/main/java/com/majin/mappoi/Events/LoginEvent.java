package com.majin.mappoi.Events;

import com.majin.mappoi.Model.Services.Output.LoginOutput;

/**
 * Created by Majin on 05/03/2017.
 */

public class LoginEvent implements IEvents{
    private LoginOutput output;

    public LoginEvent(LoginOutput output) {
        this.output = output;
    }

    @Override
    public LoginOutput getJSON() {
        return output;
    }
}
