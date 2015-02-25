package com.insart.tasker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "tasklist")
public class TaskList implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    private ArrayList<Task> tasks =new ArrayList<>(); //список тасков

    private User author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @OneToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}