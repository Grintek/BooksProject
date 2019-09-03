package com.library.repos;

import com.library.domain.Library;
import com.library.domain.books.Author;
import com.library.domain.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLibraryAndName(Library library, String book);

    Book findByName(String name);

    List<Book> findByNameAfter(String author);

    List<Book> findByAuthors(Author author);

}
