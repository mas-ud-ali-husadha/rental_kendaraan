package com.example.rentalkendaraan.Admin;

import com.example.rentalkendaraan.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "admin")
public class Admin extends User {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(length = 20)
    private LocalDate tanggal_bekerja;

    public Admin() {
    }

    public Admin(String nama, String alamat, String telp, String email, String password, LocalDate tanggal_bekerja) {
        super(nama, alamat, telp, email, password);
        this.tanggal_bekerja = tanggal_bekerja;
    }

    public LocalDate getTanggal_bekerja() {
        return tanggal_bekerja;
    }

    public void setTanggal_bekerja(LocalDate tanggal_bekerja) {
        this.tanggal_bekerja = tanggal_bekerja;
    }
}
