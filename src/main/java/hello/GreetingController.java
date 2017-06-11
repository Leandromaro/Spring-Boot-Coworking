package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, @RequestParam(value="lname", required=false, defaultValue="test") String lname, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("lname", lname);
        return "greeting";
    }

}