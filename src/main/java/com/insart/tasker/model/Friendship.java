package com.insart.tasker.model;

import com.insart.tasker.enums.FriendshipStatus;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Evgeniy James
 * Date: 22.02.2015
 */
@Entity
public class Friendship implements Serializable{

    private Long id;
    private Long idOne;
    private Long idTwo;
    private FriendshipStatus relationship;


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
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "relationship", nullable = true, insertable = true, updatable = true)
    public FriendshipStatus getRelationship() {
        return relationship;
    }

    @Column(name = "id_one")
    public Long getIdOne() {
        return idOne;
    }

    public void setIdOne(Long idOne) {
        this.idOne = idOne;
    }

    @Column(name = "id_two")
    public Long getIdTwo() {
        return idTwo;
    }

    public void setIdTwo(Long idTwo) {
        this.idTwo = idTwo;
    }

    public void setRelationship(FriendshipStatus isInvite) {
        this.relationship = isInvite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friendship that = (Friendship) o;

        if (id != that.id) return false;
        if (relationship != null ? !relationship.equals(that.relationship) : that.relationship != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "id=" + id +
                ", idOne=" + idOne +
                ", idTwo=" + idTwo +
                ", isInvite=" + relationship +
                '}';
    }

}
