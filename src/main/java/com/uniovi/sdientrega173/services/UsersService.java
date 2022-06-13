package com.uniovi.sdientrega173.services;

import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Método que se ejecuta despues de lanzarse la aplicacion
     */
    @PostConstruct
    public void init() {
    }

    /**
     * Obtiene todos los usuarios
     *
     * @param pageable
     *
     * @return users
     */
    public Page<User> getUsers(Pageable pageable) {
        Page<User> users = usersRepository.findAll(pageable);
        return users;
    }

    /**
     * Obtiene un usuario
     *
     * @param id
     *
     * @return user
     */
    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }

    /**
     * Añade un usuario
     *
     * @param user
     */
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    /**
     * Obtiene un usuario por su email
     *
     * @param email
     *
     * @return user
     */
    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    /**
     * Elimina un usuario
     *
     * @param id
     */
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    /**
     * Busca usuarios por email, nombre o apellidos
     *
     * @param pageable
     * @param searchText
     *
     * @return users
     */
    public Page<User> searchByNameLastNameAndEmail(Pageable pageable, String searchText) {
        Page<User> users;
        searchText = "%" + searchText + "%";
        users = usersRepository.searchByNameLastNameAndEmail(pageable, searchText);
        return users;
    }

    /**
     * Obtiene los usuarios seleccionados
     *
     * @param pageable
     *
     * @return users
     */
    public Page<User> getSelected(Pageable pageable) {
        Page<User> users = new PageImpl<User>(new LinkedList<User>());
        users = usersRepository.findSelected(pageable);
        return users;
    }

    /**
     * Selecciona o deselecciona un usuario
     *
     * @param b
     * @param id
     */
    public void setUserSelected(boolean b, Long id) {
        Optional<User> user = usersRepository.findById(id);
        user.get().setSelected(b);
        usersRepository.updateSelect(b,id);
    }

    /**
     * Obtiene todos los usuarios excepto los administradores
     * y el usuario autenticado
     *
     * @param pageable
     * @param email
     *
     * @return users
     */
    public Page<User> getUsersAuthenticated(Pageable pageable, String email) {
        Page<User> users = usersRepository.findForAuthenticated(pageable, email);
        return users;
    }
}
