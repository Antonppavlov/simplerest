package ru.pavlov.simplerest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nick_name")
    @NotNull
    private String nickName;

    @Column(name = "user_type")
    @NotNull
    private String userType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(userType, user.userType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nickName, userType);
    }
}
