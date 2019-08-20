package com.library.controllers;

import com.library.domain.Library;
import com.library.repos.LibraryRepo;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryRepo library;

    private LibraryService libraryService;

    @Autowired
    public void setLibraryService(LibraryService libraryService){
        this.libraryService = libraryService;
    }


    @GetMapping("/library")
    public List<Library> library(){
        List<Library> lib = library.findAll();
        return lib;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add-lib")
    public ResponseEntity addLibrary(@RequestParam String name){

        Library lib = new Library(name);

        libraryService.saveLibrary(lib);
        return new ResponseEntity("Библиотека создана",HttpStatus.OK);
    }

    @GetMapping("/library/{id}")
    public Library libraries(@PathVariable("id") Long id){

        return libraryService.getLibrary(id);
    }
}
