package com.example.rentalkendaraan.User;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")

//struktur data yang disimpan di database.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER(10)")
    protected Integer id;

    @Column(length = 20)
    protected String nama;

    @Column(length = 20)
    protected String alamat;

    @Column(length = 20)
    protected String telp;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('admin', 'pelanggan')")
    protected Role role;

    @Column(unique = true, length = 20)
    protected String email;

    @Column(length = 100)
    protected String password;

    public enum Role {
        admin, pelanggan
    }

    public User() {
    }

    public User(String nama, String alamat, String telp, String email, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}