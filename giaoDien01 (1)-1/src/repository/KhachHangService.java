/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.KhachHang;
import util.ConnectDB;

/**
 *
 * @author adim
 */
public class KhachHangService {
      private Connection conn;
    public KhachHangService(){
        conn = ConnectDB.getConnection();
    }
    
    public ArrayList<KhachHang> getData() throws SQLException{
        ArrayList<KhachHang> list = new ArrayList<>();
        String query = "Select * from Khach_Hang";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while(rs.next()){
            KhachHang kh = new KhachHang();
            kh.setId(rs.getInt("ID"));
            kh.setMaKH(rs.getString("ma_khach_hang"));
            kh.setTenKH(rs.getString("ten_khach_hang"));
            kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
            kh.setSdt(rs.getString("so_dt"));
            kh.setDiaChi(rs.getString("dia_chi"));
            kh.setEmail(rs.getString("email"));
            kh.setTrangThai(rs.getInt("trang_thai"));
            list.add(kh);
        }
        return list;
    }
    
    public void insert(KhachHang kh) throws SQLException{
        String query = "Insert into Khach_hang values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,kh.getId());
        ps.setString(2,kh.getMaKH());
        ps.setString(3,kh.getTenKH());
        ps.setBoolean(4,kh.isGioiTinh());
        ps.setString(5,kh.getSdt());
        ps.setString(6,kh.getDiaChi());
        ps.setString(7,kh.getEmail());
        ps.setInt(8,kh.getTrangThai());
        ps.executeUpdate();
    }
    
     public void remove(String maKH) throws SQLException{
        String query  = "Delete from Khach_hang where ma_khach_hang=?";
        PreparedStatement ps = conn.prepareStatement(maKH);
        ps.setString(2,maKH);
        ps.executeUpdate();
     }
     public void update( KhachHang kh) throws SQLException{
        String query = "Update Khach_hang Set ten_khach_hang=?, gioi_tinh=?, so_dt=?,dia_chi=?,email=?,trang_thai=? where ma_khach_hang=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,kh.getId());
        ps.setString(2,kh.getMaKH());
        ps.setString(3,kh.getTenKH());
        ps.setBoolean(4,kh.isGioiTinh());
        ps.setString(5,kh.getSdt());
        ps.setString(6,kh.getDiaChi());
        ps.setString(7,kh.getEmail());
        ps.setInt(8,kh.getTrangThai());
        ps.executeUpdate();
    }
}
