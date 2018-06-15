package com.endava.bod.challenge.api.repositories;

import com.endava.bod.challenge.api.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
    //org.springframework.boot:spring-boot-starter-data-jpa hibernate annotations
    //org.springframework.boot:spring-boot-starter-data-mongodb mongodb annotations
    //@Autowired annotation to dependency injection of defined class
}
