package app.raidhub.JBA.oauth2.exceptions;

public class CodeNotReceived extends Exception {
    public CodeNotReceived(String errorMessage) {
        super(errorMessage);
    }
}