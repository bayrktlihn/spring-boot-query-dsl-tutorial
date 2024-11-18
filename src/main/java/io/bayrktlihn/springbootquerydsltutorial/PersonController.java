package io.bayrktlihn.springbootquerydsltutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonApplicationService personApplicationService;


    @PostMapping("query")
    public List<Person> listPersons(
            @RequestBody PersonQuery personQuery
    ) {
        return personApplicationService.findAll(personQuery);
    }


}
