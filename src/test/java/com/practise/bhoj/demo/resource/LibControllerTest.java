package com.practise.bhoj.demo.resource;

import com.practise.bhoj.demo.dto.BookDTO;
import com.practise.bhoj.demo.service.LibraryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@WebMvcTest(controllers = LibController.class)
public class LibControllerTest {

    @InjectMocks
    LibController libController = new LibController();

    private MockMvc mockmvc;
    @Mock
    LibraryService libraryService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockmvc= MockMvcBuilders.standaloneSetup(libController).build();
    }

    @Test
    public void testGetLibs() throws Exception{
        when(libraryService.fetchAllLibrary()).thenReturn(new ArrayList<>());
        mockmvc.perform(get("/getlibs" )).andExpect(status().isOk());
    }

    @Test
    public void testGetlibDetail() throws Exception{
        when(libraryService.fetchLibraryDetails(any())).thenReturn(new ArrayList<>());
        mockmvc.perform(post("/getlibDetail?libId=1" )).andExpect(status().isOk());
    }

    @Test
    public void testAddBook() throws Exception{
        doNothing().when(spy(new LibraryService())).addBooksInLibrary(any(),any());
        mockmvc.perform(post("/addBook?libId=1" ).content("{}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    @Test
    public void testUpdateBook() throws Exception{
       doNothing().when(spy(new LibraryService())).updateBooksInLibrary(any(),any());
        mockmvc.perform(post("/updateBook?libId=1" ).content("{}").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}