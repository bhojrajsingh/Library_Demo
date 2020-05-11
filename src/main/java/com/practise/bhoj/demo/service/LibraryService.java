package com.practise.bhoj.demo.service;

import com.practise.bhoj.demo.dto.BookDTO;
import com.practise.bhoj.demo.dto.LibraryDTO;
import com.practise.bhoj.demo.model.Book;
import com.practise.bhoj.demo.model.Library;
import com.practise.bhoj.demo.repository.BookRepository;
import com.practise.bhoj.demo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;
    public List<BookDTO> fetchLibraryDetails(Integer libId){
        List<BookDTO> books = new ArrayList<BookDTO>();
        Optional<List<Book>> booksOption = bookRepository.findByLibId(libId);
        if (booksOption.isPresent()) {
            books.addAll(booksOption.get().stream().map(book -> new BookDTO(book.getBookId(),book.getBookName(),book.getCategory(),book.getAuthor())).collect(Collectors.toList()));
        }
       return books;
    }

    public  List<LibraryDTO> fetchAllLibrary(){
        List<LibraryDTO> libs = new ArrayList<LibraryDTO>();
        Iterable<Library> libOptions = libraryRepository.findAll();
        for(Library libOption :libOptions){
            LibraryDTO libDetails = new  LibraryDTO();
            libDetails.setLibID(libOption.getLibId().toString());
            libDetails.setLibName(libOption.getLibName());
            libs.add(libDetails);
        }
        return libs;
    }

    public void addBooksInLibrary(Integer libID,BookDTO bookDto ){
         bookRepository.save(new Book(libID, bookDto.getBookName(),bookDto.getCategory(),bookDto.getAuthor()));
    }

    public void updateBooksInLibrary(Integer libID,BookDTO bookDto ){
        bookRepository.save(new Book(bookDto.getBookId(),libID, bookDto.getBookName(),bookDto.getCategory(),bookDto.getAuthor()));
    }
}
