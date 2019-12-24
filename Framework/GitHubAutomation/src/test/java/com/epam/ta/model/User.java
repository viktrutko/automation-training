package com.epam.ta.model;

import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String guest;

    public User(String name, String surname, String email, String phone, String guest) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.guest = guest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", guest='" + guest + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User)) return false;
        User user = (User) object;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(guest, user.guest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, phone, guest);
    }
}
