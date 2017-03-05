package com.majin.mappoi.Model.Services.Output;

import java.io.Serializable;

/**
 * Created by Majin on 05/03/2017.
 */

public class LoginOutput implements Serializable {

    private boolean success;
    private String message;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
