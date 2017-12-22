package ru.pavlov.simplerest.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "body")
    @NotNull
    private String body;

    @Column(name = "time")
    @NotNull
    private Timestamp time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                Objects.equals(body, message.body) &&
                Objects.equals(time, message.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, body, time);
    }
}
