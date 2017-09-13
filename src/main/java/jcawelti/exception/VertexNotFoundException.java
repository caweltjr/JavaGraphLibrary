package jcawelti.exception;

public class VertexNotFoundException extends Exception {

    private String reason;

    public VertexNotFoundException(String reason) {
        this.reason = reason;
    }

    public String message() {
        return "Invalid vertex: " + reason;
    }

}
