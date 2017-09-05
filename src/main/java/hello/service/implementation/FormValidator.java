package hello.service.implementation;

import hello.serviceResponse.RegularExpresion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by leandromaro on 14/6/17.
 */
@Service
public class FormValidator implements hello.service.interfaces.FormValidator {

    private static final String URI = "http://localhost:8181/allExpresions";

    private RestTemplate restTemplate;

    @Autowired(required = true)
    public FormValidator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<String> validate(String name, String lastName, String email, String dni) {
        Map<String, Pattern> rules = getRules();
        return new InternalValidator(rules).validate(name, lastName, email, dni);
    }

    private Map<String, Pattern> getRules() {
        ResponseEntity<RegularExpresion[]> expressions = restTemplate.getForEntity(URI, RegularExpresion[].class);
        RegularExpresion[] expression = expressions.getBody();
        return Arrays.stream(expression).collect(Collectors.toMap((exp) -> exp.getField(), exp -> Pattern.compile(exp.getExpresion())));
    }

    private static class InternalValidator {
        private final Map<String, Pattern> rules;

        InternalValidator(Map<String, Pattern> rules) {
            this.rules = rules;
        }

        List<String> validate(String name, String lastName, String email, String dni) {
            List<String> wrongFields = new ArrayList<>();
            if (!rules.get("email").matcher(email).matches()) {
                wrongFields.add("email");
            }
            if(!rules.get("string").matcher(name).matches()){
                wrongFields.add("name");
            }
            if(!rules.get("string").matcher(lastName).matches()) {
                wrongFields.add("LastName");
            }
            if(!rules.get("int").matcher(dni).matches()){
                wrongFields.add("dni");
            }
            return wrongFields;
        }

//        List<String> validate(Map<String, String> fields) {
//            return fields.entrySet()
//                    .stream()
//                    .filter(this::test)
//                    .map(Map.Entry::getKey)
//                    .collect(Collectors.toList());
//        }
        /*
        private boolean test(Map.Entry<String, String> e) {
            return rules.containsKey(e.getKey()) && rules.get(e.getKey()).asPredicate().test(e.getValue());
        }*/
    }
}
