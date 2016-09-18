package vn.edu.fpt.mola.bom.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import vn.edu.fpt.mola.bom.config.annotation.RestEndpointAdvice;


@RestEndpointAdvice
public class RestExceptionHandler
{
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e)
    {
        ErrorResponse errors = new ErrorResponse();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            ErrorItem error = new ErrorItem();
            error.setCode(violation.getMessageTemplate());
            error.setMessage(violation.getMessage());
            errors.addError(error);
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e)
    {
        ErrorResponse errors = new ErrorResponse();
        ErrorItem error = new ErrorItem();
        error.setCode(HttpStatus.BAD_REQUEST.toString());
        error.setMessage(e.getMessage());
        errors.addError(error);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
    public ResponseEntity<ErrorResponse> handle(
            NoSuchRequestHandlingMethodException e)
    {
        ErrorResponse errors = new ErrorResponse();
        ErrorItem error = new ErrorItem();
        error.setCode(HttpStatus.NOT_FOUND.toString());
        error.setMessage(e.getMessage());
        errors.addError(error);
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(ResourceNotFoundException e)
    {
        ErrorResponse errors = new ErrorResponse();
        ErrorItem error = new ErrorItem();
        error.setCode(HttpStatus.NOT_FOUND.toString());
        error.setMessage(e.getMessage());
        errors.addError(error);
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("unused")
    public static class ErrorItem
    {
        private String code;
        private String message;

        @XmlAttribute
        public String getCode()
        {
            return code;
        }

        public void setCode(String code)
        {
            this.code = code;
        }

        @XmlValue
        public String getMessage()
        {
            return message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }
    }

    @SuppressWarnings("unused")
    @XmlRootElement(name = "errors")
    public static class ErrorResponse
    {
        private List<ErrorItem> errors = new ArrayList<>();

        @XmlElement(name = "error")
        public List<ErrorItem> getErrors()
        {
            return errors;
        }

        public void setErrors(List<ErrorItem> errors)
        {
            this.errors = errors;
        }

        public void addError(ErrorItem error)
        {
            this.errors.add(error);
        }
    }
}
