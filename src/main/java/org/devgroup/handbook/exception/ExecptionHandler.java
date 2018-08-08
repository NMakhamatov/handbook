package org.devgroup.handbook.exception;

import org.devgroup.handbook.exception.exceptions.DepartmentException;
import org.devgroup.handbook.exception.exceptions.EmployeeException;
import org.devgroup.handbook.util.CustomErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExecptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);


    @ExceptionHandler({EmployeeException.class, DepartmentException.class})
    protected @ResponseBody
    ResponseEntity<?> handleAllCustomExceptions(RuntimeException e) {
        log.error(e.getMessage(), e.getCause());
        return new ResponseEntity<>(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected @ResponseBody ResponseEntity<?> handleDaoExceptions(RuntimeException e) {
        log.error(e.getMessage(), e.getCause());
        return new ResponseEntity<>(new CustomErrorResponse(e.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(e.getMessage(), e.getCause());
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            sb.append(error.getDefaultMessage());
            sb.append("  ");
        }
        return new ResponseEntity<>(new CustomErrorResponse("Ошибка валидации: " + sb.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<?> handleAllExceptions(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new CustomErrorResponse("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
