package hello.service.interfaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import hello.entities.UserData;

/**
 * Created by leandromaro on 20/6/17.
 */
public interface FormValidator {
    String validate(UserData userData) throws UnirestException;
}
