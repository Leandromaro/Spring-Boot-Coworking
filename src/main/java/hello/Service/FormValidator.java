package hello.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by leandromaro on 14/6/17.
 */
@Service
public class FormValidator {

    private static final String URI_BOOK = "http://localhost:8080/v1/books";

    public String validate() throws UnirestException {
        RestTemplate restTemplate = new RestTemplate();
        Object object = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Object.class);

            // These code snippets use an open-source library. http://unirest.io/java
            HttpResponse<String> response = Unirest.get("https://yoda.p.mashape.com/yoda?sentence=You+will+learn+how+to+speak+like+me+someday.++Oh+wait.")
                    .header("X-Mashape-Key", "bbFBSSpbCTmshK8aJNfWxKGbShe3p1EWYppjsn13vq82oAPil3")
                    .header("Accept", "text/plain")
                    .asString();

        return "OK";
    }




//    public UserData createBook(Book book) throws Exception {
//        HttpResponse<Book> response = Unirest.post(URI_BOOK).header("accept", "application/json")
//                .header("Content-Type", "application/json").body(book).asObject(Book.class);
//        int status = response.getStatus();
//        System.out.println("Status code: " + status);
//        Book createdBook = response.getBody();
//        return createdBook;
//
//    }

}
