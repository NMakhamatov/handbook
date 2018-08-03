package org.devgroup.handbook.util;

public class CustomErrorResponse {
    private String error;

    public CustomErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
