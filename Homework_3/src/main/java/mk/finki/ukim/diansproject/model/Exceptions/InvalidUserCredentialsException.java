package mk.finki.ukim.diansproject.model.Exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
    }
}

