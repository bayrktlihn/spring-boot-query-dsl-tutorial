package io.bayrktlihn.springbootquerydsltutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DataFeeder implements CommandLineRunner {


    private final PersonJpaRepository personJpaRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setFirstName("Alihan");
        person.setLastName("BAYRAKTAR");
        personJpaRepository.save(person);

        person = new Person();
        person.setFirstName("Mehmet");
        person.setLastName("Ayka");
        personJpaRepository.save(person);


        person = new Person();
        person.setFirstName("Sadi Evren");
        person.setLastName("Şeker");
        personJpaRepository.save(person);
    }
}
