package com.example.rentalkendaraan.DTO;

import com.example.rentalkendaraan.User.User;

import java.time.LocalDate;

public class AdminDTO {
    private Integer id;
    private String nama;
    private String alamat;
    private String telp;
    private String email;
    private User.Role role;
    private LocalDate tanggal_bekerja;

    public AdminDTO(String nama, String alamat, String telp, String email, User.Role role, LocalDate tanggal_bekerja) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.email = email;
        this.role = role;
        this.tanggal_bekerja = tanggal_bekerja;
    }

    public AdminDTO() {

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

    public LocalDate getTanggal_bekerja() {
        return tanggal_bekerja;
    }

    public void setTanggal_bekerja(LocalDate tanggal_bekerja) {
        this.tanggal_bekerja = tanggal_bekerja;
    }
}
