package hello.service.implementation;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import hello.entities.UserData;
import hello.serviceResponse.RegularExpresion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public String validate(UserData userData) throws IllegalArgumentException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RegularExpresion[]> expresions = restTemplate.getForEntity(URI, RegularExpresion[].class);
        RegularExpresion[] expresion = expresions.getBody();
        for (RegularExpresion r: expresion) {
            if(r.getExpresion().equals("email")){
                emailRegex = r.getField();
            }
            if(r.getExpresion().equals("int")){
                integerRegex = r.getField();
            }
            if(r.getExpresion().equals("String")){
                stringRegex = r.getField();
            }
        }

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern stringPattern = Pattern.compile(stringRegex);
        Pattern integerPattern = Pattern.compile(integerRegex);

//        if (!emailPattern.matcher(userData.getEmail()).matches()) {
//            throw new IllegalArgumentException("Invalid String");
//        }
        if ((!stringPattern.matcher(userData.getName()).matches())||
                (!stringPattern.matcher(userData.getLastName()).matches())) {
            throw new IllegalArgumentException("Invalid String");
        }
        String dni = Integer.toString(userData.getIdentificationNumber());
        if (!integerPattern.matcher(dni).matches()) {
            throw new IllegalArgumentException("Invalid String");
        }
        return "OK";
    }

}
