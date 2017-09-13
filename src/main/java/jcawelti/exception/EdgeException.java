package jcawelti.exception;

public class EdgeException extends Exception {

    private String reason;

    public EdgeException(String reason) {
        this.reason = reason;
    }

    public String message() {
        return "Invalid edge construction: " + reason;
    }

}