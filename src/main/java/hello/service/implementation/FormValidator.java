package hello.service.implementation;

import hello.entities.UserData;
import hello.serviceResponse.RegularExpresion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by leandromaro on 14/6/17.
 */
@Service
public class FormValidator implements hello.service.interfaces.FormValidator {

    private static final String URI = "http://localhost:8181/allExpresions";

    private String emailRegex = "";
    private String stringRegex = "";
    private String integerRegex = "";
    private static Pattern emailPattern;
    private static Pattern stringPattern;
    private static Pattern integerPattern;
    private ArrayList<String> wrongFields;

    @Override
    public ArrayList<String> validate(String name, String lastName, String email, String dni) {
        this.loadExpresions();
        return exceptionHandler(name, lastName, email, dni);
    }

    private void loadExpresions(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RegularExpresion[]> expresions = restTemplate.getForEntity(URI, RegularExpresion[].class);
        RegularExpresion[] expresion = expresions.getBody();
        for (RegularExpresion r: expresion) {
            if(r.getField().equals("email")){
                emailRegex = r.getExpresion();
            }
            if(r.getField().equals("int")){
                integerRegex = r.getExpresion();
            }
            if(r.getField().equals("string")){
                stringRegex = r.getExpresion();
            }
        }
        emailPattern = Pattern.compile(emailRegex);
        stringPattern = Pattern.compile(stringRegex);
        integerPattern = Pattern.compile(integerRegex);
    }

    private ArrayList<String> exceptionHandler(String name, String lastName, String email, String dni){
        wrongFields = new ArrayList<String>();
        if (!emailPattern.matcher(email).matches()) {
                wrongFields.add("email");
        }
        if(!stringPattern.matcher(name).matches()){
            wrongFields.add("name");
        }
        if(!stringPattern.matcher(lastName).matches()) {
            wrongFields.add("LastName");
        }

        if(!integerPattern.matcher(dni).matches()){
            wrongFields.add("dni");
        }
        return wrongFields;
    }

}
