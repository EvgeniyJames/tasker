package com.insart.tasker.entities;

import javax.persistence.*;
import java.io.Serializable;

import static com.insart.tasker.entities.Friendship.TABLE_NAME;

/**
 * User: thur
 * Date: 18.02.2015
 * Time: 0:43
 */
@Entity
@Table(name = TABLE_NAME)
public class Friendship  implements Serializable{

    public static final String TABLE_NAME = "friendship";

    private Long id;
    private Boolean is_invite;
    private User first_friend;
    private  User second_friend;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "is_invite")
    public Boolean getIs_invite() {
        return is_invite;
    }

    public void setIs_invite(Boolean is_invite) {
        this.is_invite = is_invite;
    }


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
}
