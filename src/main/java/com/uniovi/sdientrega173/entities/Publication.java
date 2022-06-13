package com.uniovi.sdientrega173.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Publication {

    @Id
    @GeneratedValue
    private Long id;
    private String title, text,state;
    private LocalDate date;

    @OneToMany(mappedBy = "publication",cascade = CascadeType.ALL)
    private Set<Recomendar> recomendaciones;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public Publication() {
    }

    public Publication(Long id, String title, String text, LocalDate date, User author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.author = author;
        this.state="ACEPTADA";
    }

    public Publication(String title, String text, User author, LocalDate date) {
        super();
        this.title = title;
        this.text = text;
        this.author = author;
        this.date = date;
        this.state="ACEPTADA";
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", user=" + author +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String title) {
        this.state = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User user) {
        this.author = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getRecomendaciones(){
        return recomendaciones.size();
    }

    public boolean canRecommend(String email){
        for(Recomendar recom:recomendaciones){
            if(recom.getUser().getEmail().equals(email)){
                return true;
            }
        }
        if(email.equals(getAuthor().getEmail())){
            return true;
        }
        return false;
    }
}
