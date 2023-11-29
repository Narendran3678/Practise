package springboot.ExceptionHandler;

import java.sql.Timestamp;

public class GenErrorResponse {
    private Integer statusCode ;
    private String errorMessage;
    private Timestamp timestamp;

    public GenErrorResponse(Integer statusCode, String errorMessage, Timestamp timestamp) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GenException{" +
                "statusCode=" + statusCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
