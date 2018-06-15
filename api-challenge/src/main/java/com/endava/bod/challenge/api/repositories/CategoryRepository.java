package com.endava.bod.challenge.api.repositories;

import com.endava.bod.challenge.api.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
