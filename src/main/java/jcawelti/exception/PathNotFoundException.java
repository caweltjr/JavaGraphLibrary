package jcawelti.exception;

public class PathNotFoundException extends Exception {
    private String reason;

    public PathNotFoundException(String reason) {
        this.reason = reason;
    }

    public String message() {
        return "Path Not Found: " + reason;
    }
}
