package com.insart.tasker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name="id")
    private String name;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    private ArrayList<TaskList> taskLists=new ArrayList<>(); //список тасклистов

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany
    public ArrayList<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(ArrayList<TaskList> taskLists) {
        this.taskLists = taskLists;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}