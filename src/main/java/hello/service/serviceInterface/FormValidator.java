package hello.service.serviceInterface;

import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by leandromaro on 20/6/17.
 */
public interface FormValidator {
    String validate() throws UnirestException;
}
