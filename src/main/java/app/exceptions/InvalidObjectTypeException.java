package app.exceptions;

@SuppressWarnings("serial")
public class InvalidObjectTypeException extends Exception {
    public InvalidObjectTypeException(String invalidType) {
        super("Invalid object type requested : " + invalidType);
    }
}
