package at.hochbichler.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class App {

    @Autowired
    private PersonClient client;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void listen() {
        System.out.println("Hello: " + client.findPersonByLastName("Hochbichler"));
    }

    public @Bean
    Session session() {
        Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
        return cluster.connect("mykeyspace");
    }
}
