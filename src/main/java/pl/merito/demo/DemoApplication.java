package pl.merito.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.merito.demo.breed.Breed;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Breed breed = new Breed();
		breed.setName("Labrador");
		breed.setDescription("Labrador Retriever is a friendly and outgoing breed known for its intelligence and loyalty.");


	}

}

//https://github.com/arcyro/wsbCW7todolist
