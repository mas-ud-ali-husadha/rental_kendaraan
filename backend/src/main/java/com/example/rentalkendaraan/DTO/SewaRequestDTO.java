package com.example.rentalkendaraan.DTO;

public class SewaRequestDTO {
    public Integer pelangganId;
    public Integer kendaraanId;
    public String tanggalMulai;
    public String tanggalSelesai;
    public Integer totalBiaya;

    public SewaRequestDTO(){

    }

    public SewaRequestDTO(Integer pelangganId, Integer kendaraanId, String tanggalMulai, String tanggalSelesai, Integer totalBiaya) {
        this.pelangganId = pelangganId;
        this.kendaraanId = kendaraanId;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.totalBiaya = totalBiaya;
    }

    public Integer getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(Integer pelangganId) {
        this.pelangganId = pelangganId;
    }

    public Integer getKendaraanId() {
        return kendaraanId;
    }

    public void setKendaraanId(Integer kendaraanId) {
        this.kendaraanId = kendaraanId;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public Integer getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(Integer totalBiaya) {
        this.totalBiaya = totalBiaya;
    }
}
