package addressbook;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    //private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            // save a couple of books
            repository.save(new AddressBook("test1"));
            repository.save(new AddressBook("test2"));
            repository.save(new AddressBook("test3"));
            repository.save(new AddressBook());
            repository.save(new AddressBook());


            // fetch all customers
            log.info("Books found with findAll():");
            log.info("-------------------------------");
            for (AddressBook book : repository.findAll()) {
                log.info(book.toString());
            }
            log.info("");


            /*
            // fetch an individual customer by ID
            AddressBook book = repository.findOne(1L);
            log.info("Books found with findOne(1L):");
            log.info("--------------------------------");
            log.info(book.toString());
            log.info("");

            // fetch books by last name
            log.info("Books found with findByOwner(3):");
            log.info("--------------------------------------------");
            for (AddressBook book : repository.findByOwner("Default")) {
                log.info(book.toString());
            }
            log.info("");

        };
    }
    */

}
