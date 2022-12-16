package br.com.challenge.exception;

public class JsonValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public JsonValidationException(String message) {
        super(message);
    }
}
