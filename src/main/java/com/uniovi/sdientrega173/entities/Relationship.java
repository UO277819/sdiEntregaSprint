package com.uniovi.sdientrega173.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "relationship")
public class Relationship {

    public enum StateType {
        FRIENDS, PENDING;
    }

    @Id
    @GeneratedValue
    private Long id;
    private StateType state;
    private boolean accept;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private User source;
    @ManyToOne
    @JoinColumn(name = "target_id")
    private User target;

    public Relationship() {}

    public Relationship(User user1, User user2) {
        super();
        this.source = user1;
        this.target = user2;
        this.state = StateType.PENDING;
        this.accept = false;
    }

    public Relationship(User user1, User user2, boolean accept) {
        super();
        this.source = user1;
        this.target = user2;
        if (accept) this.state = StateType.FRIENDS;
        else this.state = StateType.PENDING;
        this.accept = accept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

    public User getSource() {
        return source;
    }

    public void setSource(User source) {
        this.source = source;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getName(String email){
        if(source.getEmail().equals(email))
            return target.getName();
        else
            return source.getName();
    }

    public String getLastName(String email){
        if(source.getEmail().equals(email))
            return target.getLastName();
        else
            return source.getLastName();
    }

    public String getEmail(String email){
        if(source.getEmail().equals(email))
            return target.getEmail();
        else
            return source.getEmail();
    }

}
