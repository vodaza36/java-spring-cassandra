package at.hochbichler.cassandra;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonRepository extends Repository<Person, Long> {
    List<Person> findByLastName(String lastName);
}
