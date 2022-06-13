package com.uniovi.sdientrega173.controllers;

import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class FriendsController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RelationshipService relationshipService;

    @Autowired
    private LogsService logsService;

    /**
     * Actualiza la lista de amigos en la vista
     * @param model
     * @param pageable
     * @param principal
     * @return retorna el enlace a la tabla de amigos
     */
    @RequestMapping("/friends/list/update")
    public String updateFriendsList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        Page<Relationship> friends = relationshipService.getFriendsByUser(pageable,user);
        model.addAttribute("friendsList", friends.getContent());
        logsService.petitionLog("friends/list/update");
        return "friends/list :: tableFriends";
    }

    /**
     * Obtiene la lista de amigos del usuario
     * @param model
     * @param pageable
     * @param principal
     * @return enlace a la vista de la lista de amigos
     */
    @RequestMapping("/friends/list")
    public String getFriendsList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        Page<Relationship> friends = relationshipService.getFriendsByUser(pageable,user);

        model.addAttribute("friendsList", friends.getContent());
        model.addAttribute("page", friends);
        logsService.petitionLog("friends/list");
        return "friends/list";
    }

}
