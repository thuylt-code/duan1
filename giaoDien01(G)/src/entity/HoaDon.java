/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int id;
    private String ma;
    private int idKH;
    private int idNV;
    private String ten;
    private String diaChi;
    private String sdt;
    private String ngay;
    private Double tongTien;
    private String hinhThucTT;
    private int idVoucher;
    private int trangThai;

    public HoaDon() {
    }

    public HoaDon(int id, String ma, int idKH, int idNV, String ten, String diaChi, String sdt, String ngay, Double tongTien, String hinhThucTT, int idVoucher, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngay = ngay;
        this.tongTien = tongTien;
        this.hinhThucTT = hinhThucTT;
        this.idVoucher = idVoucher;
        this.trangThai = trangThai;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
