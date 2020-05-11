package com.practise.bhoj.demo.repository;

import com.practise.bhoj.demo.model.Book;
import com.practise.bhoj.demo.model.BookID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends CrudRepository<Book, BookID> {

    Optional<List<Book>> findByLibId(Integer libId );

}
