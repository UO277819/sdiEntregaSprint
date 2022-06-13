package com.uniovi.sdientrega173.repositories;

import com.uniovi.sdientrega173.entities.Log;
import com.uniovi.sdientrega173.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface LogsRepository extends CrudRepository<Log, Long> {

    @Query("SELECT l FROM Log l ORDER BY l.time DESC")
    Page<Log> findAll(Pageable pageable);

    @Query("SELECT l FROM Log l WHERE l.type=?1 ORDER BY l.time DESC")
    Page<Log> getLogsFiltered(Pageable pageable, String type);
}
