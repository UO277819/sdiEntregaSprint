package com.uniovi.sdientrega173.controllers;

import com.uniovi.sdientrega173.services.*;
import com.uniovi.sdientrega173.validators.SignUpFormValidator;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.uniovi.sdientrega173.entities.*;

import java.security.Principal;
import java.util.LinkedList;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private SignUpFormValidator signUpFormValidator;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private LogsService logsService;
    @Autowired
    private RelationshipService relationshipService;

    private String authenticated;


    /**
     * Actualiza la tabla de usuarios
     *
     * @param model
     * @param pageable
     * @return http:localhost:8090/user/list::tableUsers
     */
    @RequestMapping("/user/list/update")
    public String updateList(Model model, Pageable pageable) {
        Page<User> users = usersService.getUsers(pageable);
        model.addAttribute("usersList", users.getContent());
        return "user/list::tableUsers";
    }

    /**
     * Muestra la tabla de usuarios
     *
     * @param model
     * @param pageable
     * @param searchText
     * @return http:localhost:8090/user/list
     */
    @RequestMapping("user/list")
    public String getListado(Model model, Pageable pageable, @RequestParam(value = "", required = false) String searchText) {
        Page<User> users;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        if (searchText != null && !searchText.isEmpty()) {
            model.addAttribute("searchText", searchText);
            users = usersService.searchByNameLastNameAndEmail(pageable, searchText);
        } else {
            model.addAttribute("searchText", false);
            if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))
                users = usersService.getUsers(pageable);
            else
                users = usersService.getUsersAuthenticated(pageable, email);
        }
        logsService.petitionLog("user/list {searchText= " + searchText + "}");
        model.addAttribute("usersList", users.getContent());
        model.addAttribute("page", users);

        return "user/list";
    }


    /**
     * Borra un usuario y redirige a la lista de usuarios
     *
     * @param id
     * @return http:localhost:8090/user/list
     */
    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable Long id) {
        usersService.deleteUser(id);
        return "redirect:/user/list";
    }

    /**
     * Registra a un nuevo usuario en la aplicación y redirige
     * a la lista de usuarios
     *
     * @param user
     * @param result
     * @return http:localhost:8090/user/list
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Validated User user, BindingResult result) {
        signUpFormValidator.validate(user, result);
        if (result.hasErrors())
            return "signup";
        user.setRole(rolesService.getRoles()[0]);
        usersService.addUser(user);
        securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
        logsService.signUpLog(user.getEmail());
        logsService.petitionLog("signup");
        return "redirect:/user/list";
    }

    /**
     * Muestra el formulario de registro
     *
     * @param model
     * @return http:localhost:8090/signup
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    /**
     * Muestra el formulario de login
     *
     * @param model
     * @param error
     * @param logout
     * @return http:localhost:8090/login
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Error.login.message");
        if (logout != null)
            model.addAttribute("message", "logout.message.succesfull");

        logsService.petitionLog("/login {error= " + error +", logout= " + logout+"}");
        model.addAttribute("user", new User());
        return "login";
    }


    /**
     * Muestra la página de inicio
     *
     * @param model
     * @return http:localhost:8090/home
     */
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User activeUser = usersService.getUserByEmail(email);
        //model.addAttribute("markList", activeUser.getMarks());
        logsService.petitionLog("home");
        return "home";
    }

    /**
     * Elimina los usuarios seleccionados y redirige
     * a la lista de usuarios.
     *
     * @param pageable
     * @return http:localhost:8090/user/list
     */
    @RequestMapping("/user/delete")
    public String delete(Pageable pageable) {
        Page<User> users = new PageImpl<User>(new LinkedList<User>());
        users = usersService.getSelected(pageable);
        for (User user : users) {
            relationshipService.deleteRelationshipsForUser(user.getId());
            usersService.deleteUser(user.getId());
        }
        logsService.petitionLog("user/delete");
        return "redirect:/user/list";
    }

    /**
     * Selecciona a un usuario
     *
     * @param model
     * @param id
     * @return http:localhost:8090/user/list :: tableUsers
     */
    @RequestMapping(value = "/user/{id}/select", method = RequestMethod.GET)
    public String setSelectedTrue(Model model, @PathVariable Long id) {
        usersService.setUserSelected(true, id);
        logsService.petitionLog("user/{id}/select {id= " + id + "}");
        return "user/list :: tableUsers";
    }

    /**
     * Deselecciona a un usuario
     *
     * @param model
     * @param id
     * @return http:localhost:8090/user/list :: tableUsers
     */
    @RequestMapping(value = "/user/{id}/noselect", method = RequestMethod.GET)
    public String setSelectedFalse(Model model, @PathVariable Long id) {
        usersService.setUserSelected(false, id);
        logsService.petitionLog("user/{id}/noselect {id= " + id + "}");
        return "user/list :: tableUsers";
    }


}
























