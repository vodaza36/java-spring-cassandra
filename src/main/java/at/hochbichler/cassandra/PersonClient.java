package at.hochbichler.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonClient {
    @Autowired
    private PersonRepository personRepository;

    public PersonClient() {
    }

    public String findPersonByLastName(String lastName) {
        Optional<Person> first = personRepository.findByLastName(lastName).stream().findFirst();
        return first.map(p->p.getFirstName()).orElse("No person found");
    }
}
