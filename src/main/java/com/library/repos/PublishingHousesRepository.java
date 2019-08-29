package com.library.repos;

import com.library.domain.books.PublishingHouses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouses, Long> {

}
