package ch.tim.pizzashopv1.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private  static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<ErrorMessage> handleException(final ApplicationException ex) {
       log.error("Entity not found error occurred", ex);
        var notFoundHttpStatus = HttpStatus.NOT_FOUND;
        var errorMessage = new ErrorMessage(ex.getErrorDetail().getMessageCode().value(), ex.getErrorDetail().getMessageCode().getDescription(), notFoundHttpStatus, ZonedDateTime.now());
        return new ResponseEntity<>(errorMessage,notFoundHttpStatus);
    }

}
