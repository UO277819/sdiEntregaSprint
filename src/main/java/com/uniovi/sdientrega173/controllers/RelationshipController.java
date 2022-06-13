package com.uniovi.sdientrega173.controllers;

import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.services.LogsService;
import com.uniovi.sdientrega173.services.RelationshipService;
import com.uniovi.sdientrega173.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private LogsService logsService;

    /**
     * Muestra la lista de peticiones de amistad
     *
     * @param model
     * @param pageable
     * @param principal
     * @return http:localhost:8090/relationship/list
     */
    @RequestMapping("/relationship/list")
    public String getList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        Page<Relationship> relationships = relationshipService.getRelationshipsForUser(pageable, user);
        /*Page<Relationship> list;
        for(Relationship elem : relationships){
            if(elem.getState()== Relationship.StateType.PENDING)
                list.
        }*/
        model.addAttribute("relationList", relationships.getContent());
        model.addAttribute("page", relationships);
        logsService.petitionLog("relationship/list {principal= " + principal.getName() + "}");
        return "relationship/list";
    }

    /**
     * Acepta la petición de amistad
     *
     * @param id
     * @return http:localhost:8090/relationship/list
     */
    @RequestMapping("/relationship/accept/{id}")
    public String accept(@PathVariable Long id){
        relationshipService.accept(id);
        logsService.petitionLog("relationship/accept/{id} {id= " + id + "}");
        return "redirect:/relationship/list";
    }



    /**
     * Actualiza la lista de peticiones de amistad
     *
     * @param model
     * @param pageable
     * @param principal
     * @return http:localhost:8090/relationship/list  :: tableRelationship
     */
    @RequestMapping("/relationship/list/update")
    public String updateList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        Page<Relationship> relationships = relationshipService.getRelationshipsForUser(pageable, user);

        model.addAttribute("relationList", relationships.getContent());
        logsService.petitionLog("relationship/list/update {principal= " + principal.getName() + "}");
        return "relationship/list :: tableRelationship";
    }

    /**
     * Crea una petición de amistad
     *
     * @param id
     * @param principal
     * @return http:localhost:8090/user/list
     */
    @RequestMapping("/user/list/addFriend/{id}")
    public String setRelationship(@PathVariable Long id, Principal principal) {
        String email = principal.getName();
        User source = usersService.getUserByEmail(email);
        User target = usersService.getUser(id);

        logsService.petitionLog("user/list/addFriend/{id} {id= " + id +"}");
       // relationshipService.addDuplicated(new Relationship(source, target));
        relationshipService.add(new Relationship(source, target));
        return "redirect:/user/list";
    }

}
