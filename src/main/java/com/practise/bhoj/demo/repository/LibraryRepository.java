package com.practise.bhoj.demo.repository;


import com.practise.bhoj.demo.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Integer> {
}
