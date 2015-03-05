package com.insart.tasker.model;

import com.insart.tasker.enums.TaskStatus;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Evgeniy James
 * Date: 22.02.2015
 */
@Entity
@Table(name = "task")
public class Task implements Serializable{

    private Long id;
    private String title;
    private String descripton;
    private TaskStatus status;
    private Long idTasklist;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Basic
    @Column(name = "descripton", nullable = true, insertable = true, updatable = true, length = 40)
    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    @Basic
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Basic
    @Column(name = "id_tasklist", nullable = true, insertable = true, updatable = true)
    public Long getIdTasklist() {
        return idTasklist;
    }

    public void setIdTasklist(Long idTasklist) {
        this.idTasklist = idTasklist;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (descripton != null ? !descripton.equals(task.descripton) : task.descripton != null) return false;
        if (idTasklist != null ? !idTasklist.equals(task.idTasklist) : task.idTasklist != null) return false;
        if (status != null ? !status.equals(task.status) : task.status != null) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (descripton != null ? descripton.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (idTasklist != null ? idTasklist.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descripton='" + descripton + '\'' +
                ", status=" + status +
                ", idTasklist=" + idTasklist+
                '}';
    }
}
