package hello;

import com.mashape.unirest.http.exceptions.UnirestException;
import hello.Service.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {


    @Autowired
    FormValidator formValidator;


    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name,
                           @RequestParam(value="lname", required=false, defaultValue="test") String lname,
                           @RequestParam(value="dni", required=false, defaultValue="666") String dni,
                           @RequestParam(value="email", required=false, defaultValue="test") String email,
                           Model model) {
        try {
            formValidator.validate();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        model.addAttribute("name", name);
        model.addAttribute("lname", lname);
        model.addAttribute("dni", dni);
        model.addAttribute("email", email);
        return "greeting";
    }



}