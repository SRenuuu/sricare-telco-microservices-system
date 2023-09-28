package lk.ucsc.sricare.userauthmanagementservice.exception;

import org.springframework.http.HttpStatusCode;

public class CustomException extends RuntimeException{
    HttpStatusCode httpStatusCode;

    public CustomException(String message, HttpStatusCode httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }
}
