package com.practise.bhoj.demo.service;

import com.practise.bhoj.demo.dto.BookDTO;
import com.practise.bhoj.demo.dto.LibraryDTO;
import com.practise.bhoj.demo.model.Book;
import com.practise.bhoj.demo.model.Library;
import com.practise.bhoj.demo.repository.BookRepository;
import com.practise.bhoj.demo.repository.LibraryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(PowerMockRunner.class)
public class LibraryServiceTest {
    @InjectMocks
    LibraryService libraryService;
    @Mock
    BookRepository bookRepository;

    @Mock
    LibraryRepository libraryRepository;

    @Test
    public void  testFetchLibraryDetails() throws Exception{
         Book book = new Book();
         book.setAuthor("TEST_Author");
         book.setBookName("TEST_BOOK_NAME");
         book.setBookId(1);
         List<Book> list = new ArrayList<Book>();
         list.add(book);
         Optional<List<Book>> optional = Optional.of(list);
         when(bookRepository.findByLibId(any())).thenReturn(optional);
         List<BookDTO> books= libraryService.fetchLibraryDetails(1);
         assertTrue(books.get(0).getBookName().equals("TEST_BOOK_NAME"));

    }

    @Test
    public void  testFetchAllLibrary() throws Exception{
        Library library = new Library();
        library.setLibId(12);
        library.setLibName("TEST");
        List<Library> list = new ArrayList<Library>();
        list.add(library);
        when(libraryRepository.findAll()).thenReturn(list);
        List<LibraryDTO> libs =libraryService.fetchAllLibrary();
        assertTrue(libs.get(0).getLibName().equals("TEST"));
    }

    @Test
    public void  testAddBooksInLibrary() throws Exception{
        when(libraryRepository.save(any())).thenReturn(new Book());
        libraryService.addBooksInLibrary(1,new BookDTO(0,"TEST_NAME","CAT","TES_AUTH"));

    }

    @Test
    public void  testUpdateBooksInLibrary() throws Exception{
        when(libraryRepository.save(any())).thenReturn(new Book());
        libraryService.updateBooksInLibrary(1,new BookDTO(2,"TEST_NAME","CAT","TES_AUTH"));

    }



}