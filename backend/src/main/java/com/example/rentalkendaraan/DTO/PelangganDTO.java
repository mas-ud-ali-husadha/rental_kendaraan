package com.example.rentalkendaraan.DTO;

import com.example.rentalkendaraan.User.User;

public class PelangganDTO {
    private Integer id;
    private String nama;
    private String alamat;
    private String telp;
    private String email;
    private User.Role role;
    private String no_ktp;
    private String nomor_sim;

    public PelangganDTO(String nama, String alamat, String telp, String email, User.Role role, String no_ktp, String nomor_sim) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.email = email;
        this.role = role;
        this.no_ktp = no_ktp;
        this.nomor_sim = nomor_sim;
    }

    public PelangganDTO() {

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

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getNomor_sim() {
        return nomor_sim;
    }

    public void setNomor_sim(String nomor_sim) {
        this.nomor_sim = nomor_sim;
    }
}
