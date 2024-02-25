/**
 * Codes from
 * https://www.javaguides.net/2020/01/spring-boot-mariadb-crud-example-tutorial.html
 */

package main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * ControllerAdvice to look for exceptions thrown by classes in the controller folder and interject with
 * the specific methods under the specific ExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Exception handler to handle resourceNotFoundExceptions
     *
     * @param ex ex is the exception that was thrown in the controller
     * @param request is the request that caused the exception to the thrown
     * @return error details with an associated http status
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex,
            WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                 ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Exception handler to handle all other exceptions that are not handled by custom exceptions
     *
     * @param ex ex is the exception that was thrown in the controller
     * @param request is the request that caused the exception to the thrown
     * @return error details with an associated http status
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
