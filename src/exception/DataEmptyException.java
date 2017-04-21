package exception;

/**
 * Created by Admin on 4/21/2017.
 */
public class DataEmptyException extends Exception {

    public DataEmptyException(String message, Throwable cause){
        super(message, cause);
    }

    public DataEmptyException(String message){
        super(message);
    }
}
