package com.library.domain.books;

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
    @JsonView(View.Name.class)
    private String name;

    @ManyToMany(mappedBy = "genres")
    @JsonView(View.upBook.class)
    private Set<Book> books;

    public Genre() {
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
