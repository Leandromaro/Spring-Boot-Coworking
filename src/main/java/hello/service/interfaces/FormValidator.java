package hello.service.interfaces;

import hello.entities.UserData;
import hello.service.Exceptions.InvalidInputException;

import java.util.ArrayList;

/**
 * Created by leandromaro on 20/6/17.
 */
public interface FormValidator {
    ArrayList<String> validate(String name, String lastName, String email, String dni) throws InvalidInputException;
}
