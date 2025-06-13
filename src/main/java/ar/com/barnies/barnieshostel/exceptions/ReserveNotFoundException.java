package ar.com.barnies.barnieshostel.exceptions;

public class ReserveNotFoundException extends RuntimeException {
    public ReserveNotFoundException(String message) {
        super(message);
    }
}