package be.technifutur.debiluseventmanager.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class DateConflitException extends RuntimeException {

    public DateConflitException() {
        super("the beginning date is after the end date");
    }

}
