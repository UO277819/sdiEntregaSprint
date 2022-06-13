package com.uniovi.sdientrega173.services;

import com.uniovi.sdientrega173.entities.Log;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.repositories.LogsRepository;
import com.uniovi.sdientrega173.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

@Service
public class LogsService {

    @Autowired
    private LogsRepository logsRepository;

    /**
     * Método que se ejecuta despues de lanzarse la aplicacion
     */
    @PostConstruct
    public void init() {
    }

    /**
     * Obtiene todos los logs
     *
     * @param pageable
     *
     * @return logs
     */
    public Page<Log> getLogs(Pageable pageable) {
        Page<Log> logs = logsRepository.findAll(pageable);
        return logs;
    }

    /**
     * Añade un log
     *
     * @param log
     */
    public void addLog(Log log) {
        logsRepository.save(log);
    }

    /**
     * Añade un log del tipo petición
     *
     * @param description
     */
    public void petitionLog(String description) {
        this.addLog(new Log("PET", new Timestamp(System.currentTimeMillis()), description));
    }

    /**
     * Añade un log del tipo registro
     *
     * @param description
     */
    public void signUpLog(String description) {
        this.addLog(new Log("ALTA", new Timestamp(System.currentTimeMillis()), description));
    }

    /**
     * Añade un log del tipo login
     *
     * @param user
     */
    public void loginLog(String user) {
        this.addLog(new Log("LOGIN-EX", new Timestamp(System.currentTimeMillis()), user));
    }

    /**
     * Añade un log del tipo login error
     *
     * @param user
     */
    public void loginErrorLog(String user) {
        this.addLog(new Log("LOGIN-ERR", new Timestamp(System.currentTimeMillis()), user));
    }

    /**
     * Añade un log del tipo logout
     *
     * @param user
     */
    public void logoutLog(String user) {
        this.addLog(new Log("LOGOUT", new Timestamp(System.currentTimeMillis()), user));
    }

    /**
     * Elimina todos los logs
     */
    public void deleteLogs() {
        logsRepository.deleteAll();
    }

    /**
     * Obtiene todos los logs filtrados por un tipo
     *
     * @param pageable
     * @param type
     *
     * @return logs
     */
    public Page<Log> getLogsFiltered(Pageable pageable, String type) {
        Page<Log> logs = logsRepository.getLogsFiltered(pageable,type);
        return logs;
    }
}
