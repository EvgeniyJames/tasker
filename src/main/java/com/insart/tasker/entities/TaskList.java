package com.insart.tasker.entities;

import javax.persistence.*;
import java.io.Serializable;

import static com.insart.tasker.entities.TaskList.TABLE_NAME;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 0:43
 */
@Entity
@Table(name = TABLE_NAME)
public class TaskList implements Serializable{

    public static final String TABLE_NAME = "tasklist";

    private Long id;
    private String title;
    private User author; //автор
   // private ArrayList<Task> tasks =new ArrayList<>(); //список тасков


    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

   /* @OneToMany
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }*/

}
