package lk.ucsc.sricare.billingpaymentsservice.Models;

public class APIResponse {
    private String message;
    private Object data;

    public APIResponse() {
    }

    public APIResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public APIResponse(String message) {
        this.message = message;
        this.data = null;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
