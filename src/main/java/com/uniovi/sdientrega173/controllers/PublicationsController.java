package com.uniovi.sdientrega173.controllers;

import com.uniovi.sdientrega173.entities.Publication;
import com.uniovi.sdientrega173.entities.Recomendar;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.services.LogsService;
import com.uniovi.sdientrega173.services.PublicationsService;
import com.uniovi.sdientrega173.services.RecomendarService;
import com.uniovi.sdientrega173.services.UsersService;
import com.uniovi.sdientrega173.validators.PublicationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

@Controller
public class PublicationsController {

    @Autowired
    private PublicationFormValidator publicationFormValidator;

    @Autowired
    private PublicationsService publicationsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private LogsService logsService;

    @Autowired
    private RecomendarService recomedarService;

    /**
     * Devuelve la vista con las publicaciones pertenecientes al amigo seleccionado.
     *
     * @param model     Objeto a través del cual se envía la lista de publicaciones a la vista
     * @param pageable  Objeto necesario en la paginacion
     * @param principal Objeto que encapsula al usuario autenticado en el sistema.
     * @param email     email del usuario del que se quieren listar las publicaciones
     * @return Vista con la lista de publicaciones (si es amigo). Vista con los usuarios del sistema,
     * en otro caso.
     */
    @RequestMapping("/publication/list/{email}")
    public String getFriendList(Model model, Pageable pageable, Principal principal, @PathVariable String email) {
        Long id = usersService.getUserByEmail(principal.getName()).getId();
        if (!publicationsService.areFriends(email, id)) {
            return "redirect:/user/list";
        }
        User user = usersService.getUserByEmail(email);
        Page<Publication> publications = publicationsService.getPublicationsForUser(pageable, user);

        model.addAttribute("publicationList", publications.getContent());
        model.addAttribute("page", publications);
        return "publication/list";
    }


    /**
     * Devuelve la vista con las publicaciones del usuario autenticado
     *
     * @param model     Objeto a través del cual se envía la lista de publicaciones a la vista.
     * @param pageable  Objeto necesario para la paginación.
     * @param principal Objeto que encapsula al usuario autenticado en el sistema.
     * @return Vista con el listado de las publicaciones del usuario autenticado.
     */
    @RequestMapping("/publication/list")
    public String getList(Model model, Pageable pageable, Principal principal) {
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
        Page<Publication> publications = publicationsService.getPublicationsForUser(pageable, user);

        model.addAttribute("publicationList", publications.getContent());
        model.addAttribute("page", publications);
        logsService.petitionLog("publication/list {principal= " + principal.getName() + "}");
        return "publication/list";
    }

    /**
     * Se encarga de validar la nueva publicación creada y de guardarla en la base de datos en caso de ser
     * correcta.
     *
     * @param publication Publicación creada que se tiene que validar.
     * @param result      Objeto donde se almacena el resultado de la validación y, a través del cual, se conoce si
     *                    la publicación tiene algún error en sus campos.
     * @param principal   Objeto que encapsula al usuario autenticado en el sistema.
     * @return Vista con las publicaciones propias del usuario en caso de no tener errores y añadirse correctamente.
     * La vista con el formulario de creación de una nueva publicación, en caso contrario.
     */
    @RequestMapping(value = "/publication/add", method = RequestMethod.POST)
    public String setPublication(@Validated Publication publication, BindingResult result, Principal principal) {
        publicationFormValidator.validate(publication, result);
        if (result.hasErrors()) {
            logsService.petitionLog("publication/add {principal= " + principal.getName() + ", errors= true}");
            return "publication/add";
        }

        // Añadimos a la publicacion la fecha y su usuario
        LocalDate publicationDate = LocalDate.now();
        String email = principal.getName();
        User publicationOwner = usersService.getUserByEmail(email);
        publication.setAuthor(publicationOwner);
        publication.setDate(publicationDate);
        publicationsService.addPublication(publication);
        logsService.petitionLog("publication/add {principal= " + principal.getName() + "}");
        return "redirect:/publication/list";
    }

    /**
     * Se encarga de mostrar el formulario al usuario del sistema y de recoger la publicación creada con
     * los datos introducidos para paársela al post.
     *
     * @param model Objeto que almacena la publicación creada.
     * @return Vista con el formulario de creación de una nueva publicación.
     */
    @RequestMapping(value = "/publication/add", method = RequestMethod.GET)
    public String setPublication(Model model) {
        model.addAttribute("publication", new Publication());
        logsService.petitionLog("publication/add");
        return "publication/add";
    }


    /**
     * Recomienda una Publicación
     *
     * @param id
     * @return http:localhost:8090/publication/list
     */
    @RequestMapping("/publication/recommend/{id}")
    public String Recomendar(@PathVariable Long id,Principal principal){
        String email = principal.getName();
        User user = usersService.getUserByEmail(email);
       // Publication publi=publicationsService.getPublicationsForUser(page,""+id);
        Publication publi=publicationsService.getPublication(id);
        Recomendar recom=new Recomendar(user,publi);
        recomedarService.add(recom);
        logsService.petitionLog("/publication/recommend/"+id);
        return "redirect:/publication/list/"+publi.getAuthor().getEmail();
    }

    /**
     * Devuelve la vista con las publicaciones de todos los usuarios
     *
     * @param model     Objeto a través del cual se envía la lista de publicaciones a la vista.
     * @param pageable  Objeto necesario para la paginación.
     * @return Vista con el listado de las publicaciones del usuario autenticado.
     */
    @RequestMapping("/publication/all")
    public String getAllPublication(Model model, Pageable pageable) {
        Page<Publication> publications = publicationsService.getAllPublications(pageable);

        model.addAttribute("publicationList", publications.getContent());
        model.addAttribute("page", publications);
        logsService.petitionLog("publication/all");
        return "publication/all";
    }
}
