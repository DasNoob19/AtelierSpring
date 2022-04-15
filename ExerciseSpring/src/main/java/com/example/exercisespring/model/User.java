package com.example.exercisespring.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "credit")
    private int credit;

    public User() {
    }

    public User(long id, String name, String email, String phone, int credit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.credit = credit;
    }

    public User(String name, String email, String phone, int credit) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.credit = credit;
    }

    public User(int credit) {
        this.credit = credit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", credit=" + credit +
                '}';
    }
}
