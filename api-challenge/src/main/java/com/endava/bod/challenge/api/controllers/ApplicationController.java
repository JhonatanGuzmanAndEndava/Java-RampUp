package com.endava.bod.challenge.api.controllers;

import com.endava.bod.challenge.api.entities.*;
import com.endava.bod.challenge.api.repositories.BookRepository;
import com.endava.bod.challenge.api.repositories.CategoryRepository;
import com.endava.bod.challenge.api.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private SubscriberRepository subscriberRepository;

    @Autowired
    public ApplicationController(BookRepository bookRepository, CategoryRepository categoryRepository, SubscriberRepository subscriberRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String hello() {
        return "Welcome to Api Challenge Java Ramp-up";
    }

    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@RequestBody Category category) {

        categoryRepository.save(category);
        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }

    @RequestMapping(path = "/books", method = RequestMethod.POST)
    public ResponseEntity<String> createBook(@RequestBody Book book) {

        bookRepository.save(book);
        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }

    @RequestMapping(path = "/subscribers", method = RequestMethod.POST)
    public ResponseEntity<String> createSubscriber(@RequestBody Subscriber subscriber) {

        subscriberRepository.save(subscriber);
        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }

    @RequestMapping(path = "/newsletters", method = RequestMethod.GET)
    public ResponseEntity<Newsletter> createSubscriber(@RequestParam String email) {

        /*
        0. Para cada registro en la tabla book_category_codes reconstruir la ruta hacia el padre, cada vez,
        que se encuentra un padre, verificar si el usuario tiene esa categoria agregada en la tabla subscriber_category_codes
        1. Si el usuario tiene la categoria, agregar la ruta al arraylist y continuar con el siguiente libro, sino continuar al siguiente padre del libro hasta que este sea nulo.
        2. Si se llega a un padre nulo, se descarta el libro actual y se continua con el siguiente
        3. Hacer lo mismo para cada libro en la base de datos.
        */

        Iterable<Book> allBooks = bookRepository.findAll();
        Subscriber subscriber = subscriberRepository.findOne(email);

        Notification notification = null;

        Newsletter newsletter = new Newsletter();
        newsletter.setRecipient(email);

        for (Book book : allBooks) {

            for(String categoryBook : book.getCategoryCodes()) {
                notification = new Notification();
                notification.setBookName(book.getTitle());
                String actual = categoryBook;
                Category category = categoryRepository.findOne(categoryBook);
                List<String> tmp2 = new ArrayList<>();
                tmp2.add(0,actual);
                while(true) {

                    if(subscriber.getCategoryCodes().contains(actual)) {

                        if(newsletter.getNotifications().contains(new Notification(book.getTitle()))) {
                            int index = newsletter.getNotifications().indexOf(new Notification(book.getTitle()));
                            newsletter.getNotifications().get(index).getPaths().add(tmp2);
                        }else {
                            notification.setBookName(book.getTitle());
                            notification.getPaths().add(tmp2);
                            newsletter.getNotifications().add(notification);
                        }
                        break;
                    }

                    if(category.getSuperCategoryCode() != null) {
                        category = categoryRepository.findOne(category.getSuperCategoryCode());
                        actual = category.getCode();
                        tmp2.add(0,actual);

                    }else {
                        break;
                    }

                }
            }
        }

        return new ResponseEntity<>(newsletter,HttpStatus.OK);
    }
}
