package com.uniovi.sdientrega173.repositories;

import com.uniovi.sdientrega173.entities.Publication;
import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RelationshipRepository extends CrudRepository<Relationship, Long> {

    @Query("SELECT p FROM Relationship p WHERE p.target = ?1 and p.accept=false ORDER BY p.id ASC")
    Page<Relationship> findAllByUser(Pageable pageable, User user);

    @Modifying
    @Transactional
    @Query("UPDATE Relationship set accept=true where id=?1")
    void accept(Long id);

    @Query("SELECT p FROM Relationship p WHERE (p.target = ?1 or p.source = ?1) and p.accept = true ORDER BY p.id ASC")
    Page<Relationship> findFriendsByUser(Pageable pageable, User user);

    @Transactional
    @Modifying
    @Query ("DELETE FROM Relationship WHERE (target.id = ?1 or source.id = ?1)")
    void deleteRelationshipsForUser(Long id);
}
