package com.example.mychat;

import jakarta.persistence.*;

@Entity
public class ChatBox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
  private   int sno;
    @Column
    private String sender;
    @Column
    private String receiver;
    @Column
    private String message;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
