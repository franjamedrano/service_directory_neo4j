package bbva.qhsd.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@SpringBootApplication
@EntityScan("bbva.qhsd.neo4j")
public class ServiceDirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDirectoryApplication.class, args);
	}
}
