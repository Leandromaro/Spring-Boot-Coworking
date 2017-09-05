package hello.controllers;

import hello.entities.UserData;
import hello.service.implementation.FormValidator;
import hello.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactFormController {

    @Autowired
    FormValidator formValidator;
    
    @Autowired
    UserService userService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ModelAndView greeting(@RequestParam(value="name", required=false, defaultValue="World") String name,
                                 @RequestParam(value="lname", required=false, defaultValue="test") String lname,
                                 @RequestParam(value="email", required=false, defaultValue="test") String email,
                                 @RequestParam(value="dni", required=false)  String dni,
                                 Model model) {
        ModelAndView mav = new ModelAndView("notValid");

        List<String> wrongFields = formValidator.validate(name, lname, email, dni);

        if(wrongFields.isEmpty()){
            model.addAttribute("name", name);
            model.addAttribute("lname", lname);
            model.addAttribute("dni", dni);
            model.addAttribute("email", email);
            int identificationNumber = Integer.parseInt(dni);
            UserData userData = new UserData(name, lname, email, identificationNumber);
            userService.saveUser(userData);
            mav.setViewName("greeting");
        }else {
            mav.addObject("error", wrongFields);
        }
        return mav;
    }



}