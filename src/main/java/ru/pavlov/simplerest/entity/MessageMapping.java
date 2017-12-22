package ru.pavlov.simplerest.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "message_mapping")
public class MessageMapping implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @JoinColumn(name = "to_user_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User toUserId;

    @NotNull
    @JoinColumn(name = "from_user_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User fromUserId;


    @NotNull
    @JoinColumn(name = "message_id")
    @ManyToOne(targetEntity = Message.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User messageId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getToUserId() {
        return toUserId;
    }

    public void setToUserId(User toUserId) {
        this.toUserId = toUserId;
    }

    public User getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(User fromUserId) {
        this.fromUserId = fromUserId;
    }

    public User getMessageId() {
        return messageId;
    }

    public void setMessageId(User messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageMapping that = (MessageMapping) o;
        return id == that.id &&
                Objects.equals(toUserId, that.toUserId) &&
                Objects.equals(fromUserId, that.fromUserId) &&
                Objects.equals(messageId, that.messageId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, toUserId, fromUserId, messageId);
    }
}
