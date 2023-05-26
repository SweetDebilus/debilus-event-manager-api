package be.technifutur.debiluseventmanager.controller;

import be.technifutur.debiluseventmanager.exception.DateConflitException;
import be.technifutur.debiluseventmanager.model.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DateConflitException.class)
    public ErrorDTO handleDateConflitException(DateConflitException ex, HttpServletRequest request) {
        return ErrorDTO.builder(request.getRequestURI(), HttpMethod.valueOf(request.getMethod()))
                .add(ErrorDTO.Error.from(ex.getMessage(), ex.getClass().getSimpleName()))
                .build();
    }

}
