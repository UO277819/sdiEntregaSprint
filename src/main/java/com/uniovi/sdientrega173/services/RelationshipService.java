package com.uniovi.sdientrega173.services;

import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.repositories.RelationshipRepository;
import com.uniovi.sdientrega173.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelationshipService {

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Muestra todas las relationship en las que el usuario esta
     * como target y este pendiente
     *
     * @param pageable
     * @param user
     */
    public Page<Relationship> getRelationshipsForUser(Pageable pageable, User user) {
        Page<Relationship> relationships = relationshipRepository.findAllByUser(pageable,user);
        return relationships;
    }
    /**
     * Borra una relationship
     *
     * @param elem
     */
    public void delete(Relationship elem){
        relationshipRepository.delete(elem);
    }
    /**
     * Cambia una Relationship al estado aceptado
     * añadiendo asi un amigo
     *
     * @param id
     */
    public void accept(Long id) {
        relationshipRepository.accept(id);
    }

    /**
     * Añade una relationship
     *
     * @param r1
     */
    public void add(Relationship r1) {
        //Relationship r2 = new Relationship(r1.getTarget(), r1.getSource());
        relationshipRepository.save(r1);
        //relationshipRepository.save(r2);
    }

    /**
     * Añade una doble relationship
     *
     * @param r1
     */
    public void addDuplicated(Relationship r1) {
        //Relationship r2 = new Relationship(r1.getTarget(), r1.getSource(), true);
        relationshipRepository.save(r1);
        //relationshipRepository.save(r2);
    }



    /**
     * Obtiene a los amigos del usuario
     *
     * @param pageable
     * @param user
     */
    public Page<Relationship> getFriendsByUser(Pageable pageable, User user) {
        Page<Relationship> relations = relationshipRepository.findFriendsByUser(pageable,user);
        /*List<User> friends = new ArrayList<User>();
        for (Relationship r : relations.getContent()) {
            if (r.getTarget().getEmail().equals(user.getEmail()) && !friends.contains(r.getSource()))
                friends.add(r.getSource());

            if (r.getSource().getEmail().equals(user.getEmail()) && !friends.contains(r.getTarget()))
                friends.add(r.getTarget());
        }

        Page<User> f = new PageImpl<>(friends);*/
        return relations;
    }
    /**
     * Borra una Relationship
     *
     * @param id
     */
    public void deleteRelationshipsForUser(Long id) {
        relationshipRepository.deleteRelationshipsForUser(id);
    }
}
