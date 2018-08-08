package org.devgroup.handbook.util;

public class CustomSuccessResponse {
    private String message;

    public CustomSuccessResponse() { this.message = "success"; }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
