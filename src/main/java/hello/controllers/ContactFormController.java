package hello.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import hello.entities.UserData;
import hello.service.implementation.FormValidator;
import hello.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactFormController {

    @Autowired
    FormValidator formValidator;
    
    @Autowired
    UserService userService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name,
                           @RequestParam(value="lname", required=false, defaultValue="test") String lname,
                           @RequestParam(value="email", required=false, defaultValue="test") String email,
                           @RequestParam(value="dni", required=false, defaultValue="666") String dni,
                           Model model) {
        String validationAnswer = "";
        String view = "notValid";

        int identificationNumber = Integer.parseInt(dni);
        UserData userData = new UserData(name, lname, email, identificationNumber);

        try {
            validationAnswer = formValidator.validate(userData);
            model.addAttribute("name", name);
            model.addAttribute("lname", lname);
            model.addAttribute("dni", dni);
            model.addAttribute("email", email);
            userService.saveUser(userData);
            view = "greeting";
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }



        if (validationAnswer.equals("OK")) {


        }
        return view;

    }



}