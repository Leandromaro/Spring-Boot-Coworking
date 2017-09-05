package hello.service.interfaces;

import hello.service.Exceptions.InvalidInputException;

import java.util.List;

/**
 * Created by leandromaro on 20/6/17.
 */
public interface FormValidator {
    List<String> validate(String name, String lastName, String email, String dni) throws InvalidInputException;
}
