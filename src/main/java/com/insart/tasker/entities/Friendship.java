package com.insart.tasker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friendship")
public class Friendship implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name="is_invite")
    private Boolean is_invite;

    private User first_friend;
    private User second_friend;

    @OneToOne
    public User getFirst_friend() {
        return first_friend;
    }

    public void setFirst_friend(User first_friend) {
        this.first_friend = first_friend;
    }

    @OneToOne
    public User getSecond_friend() {
        return second_friend;
    }

    public void setSecond_friend(User second_friend) {
        this.second_friend = second_friend;
    }

    public Boolean getIs_invite() {
        return is_invite;
    }

    public void setIs_invite(Boolean is_invite) {
        this.is_invite = is_invite;
    }
}