package app.raidhub.JBA.oauth2.exceptions;

public class IncorrectStateReceived extends Exception {
    public IncorrectStateReceived(String errorMessage) {
        super(errorMessage);
    }
}