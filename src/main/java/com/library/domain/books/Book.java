package com.library.domain.books;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.library.domain.Library;
import com.library.domain.View;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Id.class)
    private Long id;
    @NotBlank(message = "не может быть пустым")
    @JsonView(View.Name.class)
    private String name;
    @NotBlank(message = "не может быть пустым")
    @JsonView(View.Name.class)
    private String description;

    public Book() {
    }

    public Book(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Book(String name, String description, Set<Author> authors, Set<Genre> genres, PublishingHouses publishing, Library library) {
        this.name = name;
        this.description = description;
        this.authors = authors;
        this.genres = genres;
        this.publishing = publishing;
        this.library = library;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
    joinColumns = { @JoinColumn(name = "fk_book")},
    inverseJoinColumns = { @JoinColumn(name = "fk_author")})
    @JsonView(View.Book.class)
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre",
    joinColumns = { @JoinColumn(name = "fk_book")},
    inverseJoinColumns = { @JoinColumn(name = "fk_genre")})
    @JsonView(View.Book.class)
    private Set<Genre> genres = new HashSet<Genre>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonView(View.Book.class)
    private PublishingHouses publishing;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    public void updatedBook(Book upBook){
        if(!upBook.getAuthors().isEmpty()){
            this.setAuthors(upBook.getAuthors());
        }

        if(!upBook.getGenres().isEmpty()){
            this.setGenres(upBook.getGenres());
        }

        if(upBook.getDescription() != null){
            this.setDescription(upBook.getDescription());
        }

        if(upBook.getName() != null){
            this.setName(upBook.getName());
        }

        if(upBook.getPublishing() != null){
            this.setPublishing(upBook.getPublishing());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public PublishingHouses getPublishing() {
        return publishing;
    }

    public void setPublishing(PublishingHouses publishing) {
        this.publishing = publishing;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
