package com.library.controllers;

import com.library.domain.Library;
import com.library.repos.LibraryRepo;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryRepo library;

    private LibraryService libraryService;

    @Autowired
    public void setLibraryService(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping
    public String library(){
        return "Библиотека";
    }

    @PostMapping("/add-lib")
    public ResponseEntity addLibrary(@RequestBody Library lib){
        libraryService.saveLibrary(lib);
        return new ResponseEntity("Библиотека создана",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public String books(@RequestParam("id")Integer id, Model model){

        return "libraryBooks";
    }
}
