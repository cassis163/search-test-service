package nl.omoda.ecsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import nl.omoda.ecsearchservice.messaging.Channels;

@EnableBinding(Channels.class)
@SpringBootApplication
@EnableJpaRepositories
public class EcSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcSearchServiceApplication.class, args);
	}

}
