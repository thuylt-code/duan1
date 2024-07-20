/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NhanVien {
    private Integer id;
    private String maNhanVien;
    private String hoTen;
    private Double luong;
    private String sdt;
    private String email;
    private String diaChi;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private Date ngayBatDau;
    private String matKhau;
    private Integer idChucVu;
    private Integer trangThai;

    public NhanVien(String maNhanVien, String hoTen, Double luong, String sdt, String email, String diaChi, Date ngaySinh, Boolean gioiTinh, Date ngayBatDau, String matKhau, Integer idChucVu, Integer trangThai) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.luong = luong;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.ngayBatDau = ngayBatDau;
        this.matKhau = matKhau;
        this.idChucVu = idChucVu;
        this.trangThai = trangThai;
    }

    
    
    

}
