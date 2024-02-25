/**
 * A concrete class to create custom exceptions to for non-Throwable
 * error messages
 */
public class CustomException extends RuntimeException{
    /**
     * Class Constructor to initialise the error message
     *
     * @param msg error message
     */
    public CustomException(String msg){
        super(msg);
    }
}