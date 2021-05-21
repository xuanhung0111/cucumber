package com.zinio.zenith.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Created by ducnguyen on 9/21/16.
 */

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseError {
    private boolean status;
    private ErrorDetail error;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ResponseError.ErrorDetail getError() {
        return error;
    }

    public void setError(ResponseError.ErrorDetail error) {
        this.error = error;
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class ErrorDetail {
        private String internalCode;
        private String message;

        public String getInternalCode() {
            return internalCode;
        }

        public void setInternalCode(String internalCode) {
            this.internalCode = internalCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
