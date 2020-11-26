package app.api;

public class InvalidObjectTypeException extends Exception {
    public InvalidObjectTypeException(String invalidType) {
        super("Invalid object type requested : " + invalidType);
    }
}
