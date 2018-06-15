package com.intern.response;

import com.intern.dto.Error;

public class ErrorResponse extends CommonResponse {

    private Error error;

    public ErrorResponse(String statusCode, Error error) {

        super(statusCode);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
