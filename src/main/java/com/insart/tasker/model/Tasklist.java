package com.insart.tasker.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Evgeniy James on 22.02.2015.
 */
@Entity
@Table(name = "tasklist")
public class Tasklist implements Serializable{
    private long id;
    private String title;
    private Long idAuthor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 40)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "id_author")
    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasklist tasklist = (Tasklist) o;

        if (id != tasklist.id) return false;
        if (title != null ? !title.equals(tasklist.title) : tasklist.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tasklist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", idAuthor=" + idAuthor +
                '}';
    }
}
