package com.example.rentalkendaraan.DTO;

import com.example.rentalkendaraan.User.User;

public class UserLoginDTO {
    private Integer id;
    private String nama;
    private String alamat;
    private String telp;
    private String email;
    private User.Role role;

    public UserLoginDTO() {
    }

    public UserLoginDTO(Integer id, String nama, String alamat, String telp, String email, User.Role role) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.email = email;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }
}
