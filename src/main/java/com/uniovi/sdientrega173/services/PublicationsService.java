package com.uniovi.sdientrega173.services;

import com.uniovi.sdientrega173.entities.Publication;
import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.repositories.PublicationsRepository;
import com.uniovi.sdientrega173.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Service
public class PublicationsService {

    @Autowired
    private PublicationsRepository publicationsRepository;

    @Autowired
    private UsersRepository usersRepository;


    private final HttpSession httpSession;

    public PublicationsService(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    /**
     * Almacena una publicación en la base de datos.
     * @param publication Publicación a almacenar.
     */
    public void addPublication(Publication publication) {
        publicationsRepository.save(publication);
    }


    /**
     * Recupera de la base de datos las publicaciones para un ususario.
     * @param pageable Objeto necesario para la paginación.
     * @param user Usuario del que se quieren recuperar las publicaciones almacenadas.
     * @return Un objeto Page con todas las publicaciones del usuario.
     */
    public Page<Publication> getPublicationsForUser(Pageable pageable, User user) {
        Page<Publication> publications = publicationsRepository.findAllByUser(pageable,user);
        return publications;
    }

    /**
     * Comprueba si el usuario cuyo email es email1 es amigo del usuario cuyo id es id2.
     * @param email1 Email del usuario 1
     * @param id2 Id del usuario 2
     * @return True si son amigos el usuario 1 y el usuario 2. False en caso contrario.
     */
    public boolean areFriends(String email1, Long id2) {
        User user1 = usersRepository.findByEmail(email1);
        User user2 = usersRepository.findById(id2).get();
        for (Relationship r : user1.getRelationships()) {
            if (r.getSource().getEmail().equals(user2.getEmail()))
                return true;
            if (r.getTarget().getEmail().equals(user2.getEmail()))
                return true;
        }
        for (Relationship r : user2.getRelationships()) {
            if (r.getSource().getEmail().equals(user1.getEmail()))
                return true;
            if (r.getTarget().getEmail().equals(user1.getEmail()))
                return true;
        }
        return false;
    }

   public Publication findById(Pageable page,String id){
       Page<Publication> r=publicationsRepository.findById(page,id);
        return r.getContent().get(0);
   }

    /**
     * Obtiene un usuario
     *
     * @param id
     *
     * @return user
     */
    public Publication getPublication(Long id) {
        return publicationsRepository.findById(id).get();
    }

    public Page<Publication> getAllPublications(Pageable pageable) {
        return publicationsRepository.findAll(pageable);
    }
}
