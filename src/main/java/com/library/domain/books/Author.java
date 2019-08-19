package com.library.domain.books;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(name = "name_author")
    private String nameAuthor;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> authorSet = new HashSet<Book>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Set<Book> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Book> authorSet) {
        this.authorSet = authorSet;
    }
}
