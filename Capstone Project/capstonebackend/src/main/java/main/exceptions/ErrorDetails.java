/**
 * Codes from
 * https://www.javaguides.net/2020/01/spring-boot-mariadb-crud-example-tutorial.html
 */

package main.exceptions;

import java.time.LocalDateTime;

/**
 * ErrorDetails class to contain the information for error messages
 */
public class ErrorDetails {
    /**
     * LocalDateTime to record the date and time the error occurred
     */
    private LocalDateTime timestamp;
    /**
     * message to record the error message that occurred
     */
    private String message;
    /**
     * details to record what request caused the message to occur
     */
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
         super();
         this.timestamp = timestamp;
         this.message = message;
         this.details = details;
    }

    public LocalDateTime getTimestamp() {
         return timestamp;
    }
    public String getMessage() {
         return message;
    }
    public String getDetails() {
         return details;
    }
}
