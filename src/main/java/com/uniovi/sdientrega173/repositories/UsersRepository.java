package com.uniovi.sdientrega173.repositories;

import com.uniovi.sdientrega173.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsersRepository extends CrudRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    @Query("SELECT u FROM User u WHERE (LOWER(u.name) LIKE LOWER(?1) OR LOWER(u.lastName) LIKE LOWER(?1) OR LOWER(u.email) LIKE LOWER(?1))")
    Page<User> searchByNameLastNameAndEmail(Pageable pageable, String searchText);

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.selected = TRUE ")
    Page<User> findSelected(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE User SET selected = ?1 WHERE id = ?2")
    void updateSelect(Boolean selected, Long id);

    @Query("SELECT u FROM User u WHERE u.role = 'ROLE_USER' AND u.email NOT LIKE(?1)")
    Page<User> findForAuthenticated(Pageable pageable, String email );
/*
    @Query("UPDATE User set where id=?1")
    void recomendar(Long id, User user);*/
}
