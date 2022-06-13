package com.uniovi.sdientrega173.repositories;

import com.uniovi.sdientrega173.entities.Publication;
import com.uniovi.sdientrega173.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PublicationsRepository extends CrudRepository<Publication, Long> {

    Page<Publication> findAll(Pageable pageable);

    @Query("SELECT p FROM Publication p WHERE p.author = ?1 ORDER BY p.id ASC")
    Page<Publication> findAllByUser(Pageable pageable, User user);

    @Query("SELECT p FROM Publication p WHERE p.id = ?1")
    Page<Publication> findById(Pageable page, String user);
}






















