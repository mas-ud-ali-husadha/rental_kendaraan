package com.example.rentalkendaraan.DTO;

import com.example.rentalkendaraan.Kendaraan.Kendaraan;
import com.example.rentalkendaraan.Pelanggan.Pelanggan;
import com.example.rentalkendaraan.Pengembalian.Pengembalian;

public class RiwayatDetailDTO {
    public Integer id;
    public String kode_pemesanan;
    public Pelanggan pelanggan;
    public Kendaraan kendaraan;
    public String tanggal_mulai;
    public String tanggal_selesai;
    public String status;
    public Integer total_biaya;
    public String status_pembayaran;

    // Data Pengembalian
    public String tanggal_pengembalian;
    public Pengembalian.StatusPengembalian status_pengembalian;
    public String keterangan;
    public Integer denda;
    public Integer total_biaya_akhir;
    public Integer total_dibayarkan;

    public RiwayatDetailDTO(Integer id, String kode_pemesanan, Pelanggan pelanggan, Kendaraan kendaraan, String tanggal_mulai, String tanggal_selesai, String status, Integer total_biaya, String status_pembayaran, String tanggal_pengembalian, Pengembalian.StatusPengembalian status_pengembalian, String keterangan, Integer denda, Integer total_biaya_akhir, Integer total_dibayarkan) {
        this.id = id;
        this.kode_pemesanan = kode_pemesanan;
        this.pelanggan = pelanggan;
        this.kendaraan = kendaraan;
        this.tanggal_mulai = tanggal_mulai;
        this.tanggal_selesai = tanggal_selesai;
        this.status = status;
        this.total_biaya = total_biaya;
        this.status_pembayaran = status_pembayaran;
        this.tanggal_pengembalian = tanggal_pengembalian;
        this.status_pengembalian = status_pengembalian;
        this.keterangan = keterangan;
        this.denda = denda;
        this.total_biaya_akhir = total_biaya_akhir;
        this.total_dibayarkan = total_dibayarkan;
    }

    public RiwayatDetailDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode_pemesanan() {
        return kode_pemesanan;
    }

    public void setKode_pemesanan(String kode_pemesanan) {
        this.kode_pemesanan = kode_pemesanan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(Integer total_biaya) {
        this.total_biaya = total_biaya;
    }

    public String getStatus_pembayaran() {
        return status_pembayaran;
    }

    public void setStatus_pembayaran(String status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }

    public String getTanggal_pengembalian() {
        return tanggal_pengembalian;
    }

    public void setTanggal_pengembalian(String tanggal_pengembalian) {
        this.tanggal_pengembalian = tanggal_pengembalian;
    }

    public Pengembalian.StatusPengembalian getStatus_pengembalian() {
        return status_pengembalian;
    }

    public void setStatus_pengembalian(Pengembalian.StatusPengembalian status_pengembalian) {
        this.status_pengembalian = status_pengembalian;
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

    public Integer getTotal_biaya_akhir() {
        return total_biaya_akhir;
    }

    public void setTotal_biaya_akhir(Integer total_biaya_akhir) {
        this.total_biaya_akhir = total_biaya_akhir;
    }

    public Integer getTotal_dibayarkan() {
        return total_dibayarkan;
    }

    public void setTotal_dibayarkan(Integer total_dibayarkan) {
        this.total_dibayarkan = total_dibayarkan;
    }
}
