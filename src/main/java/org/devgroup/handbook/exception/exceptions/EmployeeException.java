package org.devgroup.handbook.exception.exceptions;

public class EmployeeException extends RuntimeException {
    public EmployeeException(String message) {
        super(message);
    }
    public EmployeeException(String message,Throwable cause)
    {
        super(message,cause);
    }
}
