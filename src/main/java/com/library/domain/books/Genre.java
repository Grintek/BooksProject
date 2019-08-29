package com.library.domain.books;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.library.domain.View;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Id.class)
    private Long id;

    @Column(name = "name_genre")
    @JsonView(View.Book.class)
    private String genre_name;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;

    public Genre() {
    }

    public Genre(String genre_name) {
        this.genre_name = genre_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
