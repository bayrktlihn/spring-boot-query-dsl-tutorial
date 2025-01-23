package io.bayrktlihn.springbootquerydsltutorial;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PersonApplicationService {

    private final PersonJpaRepository personJpaRepository;


    @Transactional(readOnly = true)
    public List<Person> findAll(PersonQuery personQuery) {


        BooleanExpression booleanExpression = null;
        if (personQuery.getFirstName() != null && !personQuery.getFirstName().isEmpty()) {
            String firstName = personQuery.getFirstName().toLowerCase(new Locale("tr", "TR"));
            booleanExpression = QPerson.person.firstName.containsIgnoreCase(firstName);
        }

        if (personQuery.getLastName() != null && !personQuery.getLastName().isEmpty()) {
            String lastName = personQuery.getLastName().toLowerCase(new Locale("tr", "TR"));
            if (booleanExpression == null) {
                //BooleanExpression boolExp = Expressions.stringTemplate("REPLACE({0}, 'I', 'ı')", qUser.username).containsIgnoreCase(username);
                
                booleanExpression = QPerson.person.lastName.containsIgnoreCase(lastName);
                
            } else {
                booleanExpression = booleanExpression.and(QPerson.person.lastName.containsIgnoreCase(lastName));
            }
        }

        if (booleanExpression == null) {
            return personJpaRepository.findAll();
        }

        Iterable<Person> all = personJpaRepository.findAll(booleanExpression);

        List<Person> result = new ArrayList<>();

        for (Person person : all) {
            result.add(person);
        }

        return result;


    }


}
