package de.iav.backend;

import de.iav.backend.model.Bag;
import de.iav.backend.repository.BagRepository;
import de.iav.backend.service.BagService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@SpringBootApplication
public class BackendApplication {



	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
		Bag bag1 = new Bag("1","tabby","23", "KS");
		Bag bag2 = new Bag("2","tabby","25", "KS");

	}

}
