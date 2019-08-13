package com.library.domain.books;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "не может быть пустым")
    private String name;
    @NotBlank(message = "не может быть пустым")
    private String description;

    public Book() {
    }

    public Book(String name, String description, Set<Author> authors, Set<Genre> genres, Set<PublishingHouses> publishing) {
        this.name = name;
        this.description = description;
        this.authors = authors;
        this.genres = genres;
        this.publishing = publishing;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
    joinColumns = { @JoinColumn(name = "fk_book")},
    inverseJoinColumns = { @JoinColumn(name = "fk_author")})
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_genre",
    joinColumns = { @JoinColumn(name = "fk_book")},
    inverseJoinColumns = { @JoinColumn(name = "fk_genre")})
    private Set<Genre> genres = new HashSet<Genre>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<PublishingHouses> publishing = new HashSet<PublishingHouses>();

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

    public Set<PublishingHouses> getPublishing() {
        return publishing;
    }

    public void setPublishing(Set<PublishingHouses> publishing) {
        this.publishing = publishing;
    }
}
