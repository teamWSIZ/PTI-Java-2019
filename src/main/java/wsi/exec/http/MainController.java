package wsi.exec.http;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import wsi.exec.model.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 *
 */

@Data
@AllArgsConstructor
class Ocena {
    String nazwa;
    Double value;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Post {
    Integer userId;
    Integer id;
    String title;
    String body;
}


@RestController
@CrossOrigin
@Slf4j
public class MainController {

    @GetMapping(value = "/status")
    public GenericResponse appStatus() {
        return new GenericResponse("Hello TheFunnyApp is running OK");
    }

    @GetMapping(value = "/oceny")
    public List<Ocena> getOceny() {
        List<Ocena> res = Arrays.asList(new Ocena("bdb", 5.), new Ocena("db", 4.));
        return res;
    }


    @GetMapping(value = "/proxy")
    public List<Post> proxyToHttps() {
        RestTemplate template = new RestTemplate();

        //http://api.nbp.pl/api/exchangerates/rates/a/cad?format=json
        ResponseEntity<List<Post>> response = template.exchange(
                "https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>(){});
        return response.getBody();
    }



}
