package exception;

/**
 * Created by Admin on 4/20/2017.
 */
public class DataAccessException extends Exception {
    public DataAccessException(String message, Throwable cause){
        super(message, cause);
    }
}
