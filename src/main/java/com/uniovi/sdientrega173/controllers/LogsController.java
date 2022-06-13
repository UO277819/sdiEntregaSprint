package com.uniovi.sdientrega173.controllers;

import com.uniovi.sdientrega173.entities.Log;
import com.uniovi.sdientrega173.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogsController {

    @Autowired
    private LogsService logsService;

    /**
     * Muestra la lista de logs
     *
     * @param model
     * @param pageable
     *
     * @return http:localhost:8090/log/list
     */
    @RequestMapping("log/list")
    public String getListado(Model model, Pageable pageable) {
        Page<Log> logs;
        logs = logsService.getLogs(pageable);
        model.addAttribute("logsList", logs.getContent());
        model.addAttribute("page", logs);
        model.addAttribute("filtered", false);
        logsService.petitionLog("log/list");
        return "log/list";
    }


    /**
     * Muestra los logs filtrados por un tipo concreto
     *
     * @param model
     * @param pageable
     * @param type
     *
     * @return http:localhost:8090/log/list
     */
    @RequestMapping("log/list/{type}")
    public String getFiltered(Model model, Pageable pageable,@PathVariable String type) {
        Page<Log> logs;
        logs = logsService.getLogsFiltered(pageable, type);
        model.addAttribute("logsList", logs.getContent());
        model.addAttribute("page", logs);
        model.addAttribute("filtered", true);
        logsService.petitionLog("log/list/{type} {type= "  + type+"}");
        return "log/list";
    }

    /**
     * Elimina todos los logs y redirige a la lista
     * de logs
     *
     * @return http:localhost:8090/log/list
     */
    @RequestMapping("log/delete")
    public String deleteLogs() {
        logsService.deleteLogs();
        logsService.petitionLog("log/delete");
        return "log/list";
    }



}























