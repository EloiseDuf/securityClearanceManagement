package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

public class ValidationDataException extends Exception {
	private List<String> errorMessages;

    public ValidationDataException(String message, List<String> errorMessages) {
        super(message);
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
