package ch.tim.pizzashopv1.common.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorMessage {
    private String errorCode;
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime zonedDateTime;

    public ErrorMessage() {
    }

    public ErrorMessage(String errorCode,String message, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }
}
