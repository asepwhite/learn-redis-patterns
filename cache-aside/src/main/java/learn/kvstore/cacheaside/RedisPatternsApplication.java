package learn.kvstore.cacheaside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class RedisPatternsApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisPatternsApplication.class, args);
	}

}
