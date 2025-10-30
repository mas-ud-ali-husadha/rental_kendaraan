package com.example.rentalkendaraan.DTO;

import com.example.rentalkendaraan.Pemesanan.Pemesanan;

public class PemesananStatusDTO {
    public Pemesanan pemesanan;

    public PemesananStatusDTO() {}

    public PemesananStatusDTO(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }

    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }
}
