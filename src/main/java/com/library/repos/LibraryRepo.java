package com.library.repos;

import com.library.domain.Library;
import com.library.domain.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibraryRepo extends JpaRepository<Library, Long> {

}
