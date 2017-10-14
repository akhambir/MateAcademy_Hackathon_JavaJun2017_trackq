package com.mate.trackq.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_email_confirmation ", schema = "trackq")
public class UserConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    @Column(name = "USER_ID")
    private Long userID;

    @Column(name = "EXPIRATION_TIMESTAMP")
    private Timestamp timestamp;

    @Column(name = "CONFIRMATION_ID")
    private String confirmationID;

    public UserConfirmation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getConfirmationID() {
        return confirmationID;
    }

    public void setConfirmationID(String confirmationID) {
        this.confirmationID = confirmationID;
    }
}
