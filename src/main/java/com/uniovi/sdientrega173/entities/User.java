package com.uniovi.sdientrega173.entities;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String email;
    private String name, lastName, role, password;
    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy = "source",cascade = CascadeType.ALL)
    private Set<Relationship> relationshipsSend;

    @OneToMany(mappedBy = "target",cascade = CascadeType.ALL)
    private Set<Relationship> relationshipsRecived;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Publication> publications; // Publicaciones pertenecientes al autor

    private boolean selected;

    public User() {
    }

    public User(String email, String name, String lastName) {
        super();
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        setSelected(false);
    }

    public boolean hasPetition(String email) {

        for (Relationship r: relationshipsSend){
            if ((r.getSource().getEmail().equals(email) && r.getTarget().getEmail().equals(getEmail()))
                    || (r.getSource().getEmail().equals(getEmail()) && r.getTarget().getEmail().equals(email)))
                return true;
        }
        for (Relationship r: relationshipsRecived){
            if ((r.getSource().getEmail().equals(email) && r.getTarget().getEmail().equals(getEmail()))
                    || (r.getSource().getEmail().equals(getEmail()) && r.getTarget().getEmail().equals(email)))
                return true;
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String dni) {
        this.email = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Relationship> getRelationships() {
        return relationshipsSend;
    }

    public void setRelationships(Set<Relationship> relationships) {
        this.relationshipsSend = relationships;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Set<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }

    public boolean isNotAdmin() {
        if (this.getRole() == "ROLE_ADMIN")
            return false;
        else
            return true;
    }

}
