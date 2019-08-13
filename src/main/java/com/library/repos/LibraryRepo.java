package com.library.repos;

import com.library.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface LibraryRepo extends JpaRepository<Library, Long> {

}
