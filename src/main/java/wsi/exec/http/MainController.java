package wsi.exec.http;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
