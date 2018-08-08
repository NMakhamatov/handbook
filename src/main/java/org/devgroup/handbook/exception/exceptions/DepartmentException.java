package org.devgroup.handbook.exception.exceptions;

public class DepartmentException extends RuntimeException {
    public DepartmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentException(String message) {
        super(message);
    }
}
