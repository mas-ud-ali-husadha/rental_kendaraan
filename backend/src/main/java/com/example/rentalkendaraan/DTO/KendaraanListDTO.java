package com.example.rentalkendaraan.DTO;

import com.example.rentalkendaraan.Kendaraan.Kendaraan;

public class KendaraanListDTO {
    private Integer id;
    private String model;
    private String merk;
    private String image;
    private Integer hargaSewa;
    private String warna;
    private Kendaraan.Status status;

    public KendaraanListDTO(Integer id, String model, String merk, String image, Integer hargaSewa, String warna, Kendaraan.Status status) {
        this.id = id;
        this.model = model;
        this.merk = merk;
        this.image = image;
        this.hargaSewa = hargaSewa;
        this.warna = warna;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(Integer hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public Kendaraan.Status getStatus() {
        return status;
    }

    public void setStatus(Kendaraan.Status status) {
        this.status = status;
    }
}
