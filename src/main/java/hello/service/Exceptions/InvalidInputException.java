package hello.service.Exceptions;

import java.util.ArrayList;

/**
 * Created by leandromaro on 7/8/17.
 */
public class InvalidInputException extends Exception {

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
