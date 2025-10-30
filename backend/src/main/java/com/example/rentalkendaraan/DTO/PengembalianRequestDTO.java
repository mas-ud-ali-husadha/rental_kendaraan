package com.example.rentalkendaraan.DTO;

public class PengembalianRequestDTO {
    public Integer pemesananId;
    public String tanggalPengembalian;
    public String keterangan;
    public Integer denda;
    public Integer totalBiaya;
    public Integer totalDibayarkan;

    public PengembalianRequestDTO() {}

    public PengembalianRequestDTO(Integer pemesananId, String tanggalPengembalian, String keterangan, Integer denda, Integer totalDibayarkan) {
        this.pemesananId = pemesananId;
        this.tanggalPengembalian = tanggalPengembalian;
        this.keterangan = keterangan;
        this.denda = denda;
        this.totalDibayarkan = totalDibayarkan;
    }

    public Integer getPemesananId() {
        return pemesananId;
    }

    public void setPemesananId(Integer pemesananId) {
        this.pemesananId = pemesananId;
    }

    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getDenda() {
        return denda;
    }

    public void setDenda(Integer denda) {
        this.denda = denda;
    }

    public Integer getTotalDibayarkan() {
        return totalDibayarkan;
    }

    public void setTotalDibayarkan(Integer totalDibayarkan) {
        this.totalDibayarkan = totalDibayarkan;
    }
}
