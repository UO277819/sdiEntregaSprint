package com.uniovi.sdientrega173.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private Timestamp time;
    private String description;

    public Log(){

    }

    public Log(String type, Timestamp time, String description){
        super();
        this.setType(type);
        this.setTime(time);
        this.setDescription(description);
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


