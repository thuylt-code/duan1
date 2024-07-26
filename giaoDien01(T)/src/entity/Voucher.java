/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.Date;
import lombok.*;
/**
 *
 * @author Ca1
 */
public class Voucher {

    private String maVoucher, tenVoucher, hinhThucGiam;
    private int soLuongVoucher, trangThai;
    private double gioiHanGiamToiThieu, gioiHanGiamToiDa;
    private Date ngayBatDau, ngayKetThuc;

    public Voucher() {
    }

    public Voucher(String maVoucher, String tenVoucher, String hinhThucGiam, int soLuongVoucher, int trangThai, double gioiHanGiamToiThieu, double gioiHanGiamToiDa, Date ngayBatDau, Date ngayKetThuc) {
        this.maVoucher = maVoucher;
        this.tenVoucher = tenVoucher;
        this.hinhThucGiam = hinhThucGiam;
        this.soLuongVoucher = soLuongVoucher;
        this.trangThai = trangThai;
        this.gioiHanGiamToiThieu = gioiHanGiamToiThieu;
        this.gioiHanGiamToiDa = gioiHanGiamToiDa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getTenVoucher() {
        return tenVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
    }

    public String getHinhThucGiam() {
        return hinhThucGiam;
    }

    public void setHinhThucGiam(String hinhThucGiam) {
        this.hinhThucGiam = hinhThucGiam;
    }

    public int getSoLuongVoucher() {
        return soLuongVoucher;
    }

    public void setSoLuongVoucher(int soLuongVoucher) {
        this.soLuongVoucher = soLuongVoucher;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public double getGioiHanGiamToiThieu() {
        return gioiHanGiamToiThieu;
    }

    public void setGioiHanGiamToiThieu(double gioiHanGiamToiThieu) {
        this.gioiHanGiamToiThieu = gioiHanGiamToiThieu;
    }

    public double getGioiHanGiamToiDa() {
        return gioiHanGiamToiDa;
    }

    public void setGioiHanGiamToiDa(double gioiHanGiamToiDa) {
        this.gioiHanGiamToiDa = gioiHanGiamToiDa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    
}
