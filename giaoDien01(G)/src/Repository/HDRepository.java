/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author Admin
 */
import entity.HoaDon;
import entity.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DBContext;
public class HDRepository {
    Connection conn;
    public HDRepository() {
        try {
            conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<HoaDon> findall() {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        String sql = "SELECT * FROM Hoa_don";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {         
                int id = rs.getInt("ID");
                String ma = rs.getString("ma_hoa_don");
                int idKH = rs.getInt("id_khach_hang");
                int idNV = rs.getInt("id_nhan_vien");
                String ten = rs.getString("ten_khach_hang");
                String diaChi = rs.getString("dia_chi_khach_hang");
                String sdt = rs.getString("so_dt");
                String ngay = rs.getString("ngay_tao");
                Double tongTien = rs.getDouble("tong_tien");
                String hinhThucTT = rs.getString("hinh_thuc_thanh_toan");
                int idVoucher = rs.getInt("id_voucher");
                int trangThai = rs.getInt("trang_thai");
                HoaDon hd = new HoaDon(id, ma, idKH, idNV, ten, diaChi, sdt, ngay, tongTien, hinhThucTT, idVoucher, trangThai);
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
    public ArrayList<HoaDonChiTiet> findChiTietByidHD(int idHD) {
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        String sql = "select * from Hoa_don_chi_tiet where id_hoa_don = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setId(rs.getInt("id"));
                hdct.setMa(rs.getString("ma_hoa_don_chi_tiet"));
                hdct.setIdHD(rs.getInt("id_hoa_don"));
                hdct.setIdSP(rs.getInt("id_san_pham_chi_tiet"));
                hdct.setSl(rs.getInt("so_luong"));
                hdct.setDonGia(rs.getDouble("don_gia"));
                hdct.setThanhTien(rs.getDouble("thanh_tien"));
                hdct.setTrangThai(rs.getInt("trang_thai"));
                listHDCT.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }
    public ArrayList<HoaDon> search(String keyword) {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Hoa_don WHERE ma_hoa_don LIKE ? OR ten_khach_hang LIKE ? OR so_dt LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            String key = "%" +keyword+ "%";
            ps.setString(1, key);
            ps.setString(2, key);
            ps.setString(3, key);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("ma_hoa_don");
                int idKH = rs.getInt("id_khach_hang");
                int idNV = rs.getInt("id_nhan_vien");
                String ten = rs.getString("ten_khach_hang");
                String diaChi = rs.getString("dia_chi_khach_hang");
                String sdt = rs.getString("so_dt");
                String ngay = rs.getString("ngay_tao");
                Double tongTien = rs.getDouble("tong_tien");
                String hinhThucTT = rs.getString("hinh_thuc_thanh_toan");
                int idVoucher = rs.getInt("id_voucher");
                int trangThai = rs.getInt("trang_thai");
                HoaDon hd = new HoaDon(id, ma, idKH, idNV, ten, diaChi, sdt, ngay, tongTien, hinhThucTT, idVoucher, trangThai);
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
    public ArrayList<HoaDon> filterTrangThai(int trangThai) {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        String sql = "SELECT * FROM Hoa_don WHERE trang_thai = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("ma_hoa_don");
                int idKH = rs.getInt("id_khach_hang");
                int idNV = rs.getInt("id_nhan_vien");
                String ten = rs.getString("ten_khach_hang");
                String diaChi = rs.getString("dia_chi_khach_hang");
                String sdt = rs.getString("so_dt");
                String ngay = rs.getString("ngay_tao");
                Double tongTien = rs.getDouble("tong_tien");
                String hinhThucTT = rs.getString("hinh_thuc_thanh_toan");
                int idVoucher = rs.getInt("id_voucher");
                trangThai = rs.getInt("trang_thai");
                HoaDon hd = new HoaDon(id, ma, idKH, idNV, ten, diaChi, sdt, ngay, tongTien, hinhThucTT, idVoucher, trangThai);
                listHD.add(hd);
            }
        } catch (Exception e) {
        }
        return listHD;
    }
    
    public String getTenNV(int idNV) {
        String tenNV ="";
        try {
            String sql = "SELECT ho_ten  FROM Nhan_vien WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                
              tenNV = rs.getString("ho_ten");  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNV;
    }
    public Double getGiaTriVoucher(int idV) {
        Double giaTriVoucher = 0.0;
        try {
            String sql = "SELECT gioi_han_giam_toi_thieu FROM Voucher WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                giaTriVoucher = rs.getDouble("gioi_han_giam_toi_thieu");
            }
        } catch (Exception e) {
        }
        return giaTriVoucher;
    }
    public String getTenSPCT(int idSPCT) {
        String tenSPCT ="";
        try {
            String sql ="SELECT ten_san_pham_chi_tiet FROM San_pham_chi_tiet WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSPCT);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                tenSPCT = rs.getString("ten_san_pham_chi_tiet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenSPCT;
    }
}
