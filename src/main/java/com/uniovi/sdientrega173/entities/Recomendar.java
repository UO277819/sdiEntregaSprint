package com.uniovi.sdientrega173.entities;

import javax.persistence.*;

@Entity
public class Recomendar {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;

    public Recomendar(User user,Publication publi){
        this.user=user;
        this.publication=publi;
    }

    public Recomendar() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publi) {
        this.publication = publi;
    }

}
