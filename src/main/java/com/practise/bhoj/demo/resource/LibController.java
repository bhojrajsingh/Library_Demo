package com.practise.bhoj.demo.resource;

import com.practise.bhoj.demo.dto.BookDTO;
import com.practise.bhoj.demo.dto.LibraryDTO;
import com.practise.bhoj.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibController {

    @Autowired
    LibraryService  libraryService;
    @RequestMapping(value="/getlibs", method = RequestMethod.GET)
    public List<LibraryDTO> getLibs(){
        return  libraryService.fetchAllLibrary();
        }

    @RequestMapping(value="/getlibDetail", method = RequestMethod.POST)
    public List<BookDTO> getLibs(@RequestParam Integer libId){
         return  libraryService.fetchLibraryDetails(libId);

    }
    @RequestMapping(value="/addBook", method = RequestMethod.POST)
    public void addBook(@RequestBody BookDTO bookDTO, @RequestParam Integer libId){
          libraryService.addBooksInLibrary(libId,bookDTO);

    }

    @RequestMapping(value="/updateBook", method = RequestMethod.POST)
    public void updateBook(@RequestBody BookDTO bookDTO, @RequestParam Integer libId){
        libraryService.updateBooksInLibrary(libId,bookDTO);

    }
}
