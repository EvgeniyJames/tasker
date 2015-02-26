package com.insart.tasker.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

import static com.insart.tasker.entities.User.TABLE_NAME;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 0:43
 */
@Entity
@Table(name = TABLE_NAME)
public class User implements Serializable{

    public static final String TABLE_NAME = "user";

    private Long id;
    private String login;
    private String password;
    private String email;
    private ArrayList<TaskList> taskLists=new ArrayList<>(); //список тасклистов
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*@OneToOne
    public ArrayList<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(ArrayList<TaskList> taskLists) {
        this.taskLists = taskLists;
    }*/
}
