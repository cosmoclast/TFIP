/**
 * Codes from
 * https://www.javaguides.net/2020/01/spring-boot-mariadb-crud-example-tutorial.html
 */

package main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom ResourceNotFoundException to indicate that a particular data is not found from the database
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message){
        super(message);
    }
}
