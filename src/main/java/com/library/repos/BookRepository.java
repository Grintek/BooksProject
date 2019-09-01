package com.library.repos;

import com.library.domain.Library;
import com.library.domain.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLibraryAndName(Library library, String book);

    Book findByName(String name);
}
