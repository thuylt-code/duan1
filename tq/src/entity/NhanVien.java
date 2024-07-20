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

/**
 *
 * @author ASUS
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NhanVien {
    private Integer id;
    private String maNV;
    private String hoTen;
    private Float luong;
    private String sdt;
    private String email;
    private String diaChi;
    private String ngaySinh;
    private Boolean gioiTinh;
    private Date ngayBatDau;
    private String matKhau;
    private Integer chucVu;
    private Integer trangThai;
}
