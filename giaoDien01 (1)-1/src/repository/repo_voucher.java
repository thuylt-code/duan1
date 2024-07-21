/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.Voucher;
import java.sql.*;
import util.*;

/**
 *
 * @author Ca1
 */
public class repo_voucher {

    public static ArrayList<Voucher> getListVoucherFromDb() {
        Connection sConn = ConnectDB.getConnection();
        String query = "SELECT * FROM Voucher";
        ArrayList<Voucher> vouchers = new ArrayList<>();

        try {
            Statement stm = sConn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                Voucher voucher = new Voucher();

                voucher.setMaVoucher(rs.getString("ma_voucher"));
                voucher.setTenVoucher(rs.getString("ten_voucher"));
                voucher.setSoLuongVoucher(rs.getInt("so_luong_voucher"));
                voucher.setGioiHanGiamToiThieu(rs.getDouble("gioi_han_giam_toi_thieu"));
                voucher.setGioiHanGiamToiDa(rs.getDouble("gioi_han_giam_toi_da"));
                voucher.setNgayBatDau(rs.getString("ngay_bat_dau"));
                voucher.setNgayKetThuc(rs.getString("ngay_ket_thuc"));
                voucher.setHinhThucGiam(rs.getString("hinh_thuc_giam"));
                voucher.setTrangThai(rs.getInt("trang_thai"));

                vouchers.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    ;
    
    public void addVoucherToDB(Voucher voucher) {
        Connection sConn = ConnectDB.getConnection();
        String query = "INSERT INTO dbo.Voucher\n"
                + "(\n"
                + "    ma_voucher,\n"
                + "    ten_voucher,\n"
                + "    so_luong_voucher,\n"
                + "    gioi_han_giam_toi_thieu,\n"
                + "    gioi_han_giam_toi_da,\n"
                + "    ngay_bat_dau,\n"
                + "    ngay_ket_thuc,\n"
                + "    hinh_thuc_giam,\n"
                + "    trang_thai\n"
                + ")\n"
                + "VALUES\n"
                + "(   ?, -- ma_voucher - varchar(10)\n"
                + "    ?, -- ten_voucher - nvarchar(50)\n"
                + "    ?, -- so_luong_voucher - int\n"
                + "    ?, -- gioi_han_giam_toi_thieu - money\n"
                + "    ?, -- gioi_han_giam_toi_da - money\n"
                + "    ?, -- ngay_bat_dau - date\n"
                + "    ?, -- ngay_ket_thuc - date\n"
                + "    ?, -- hinh_thuc_giam - nvarchar(50)\n"
                + "    ?  -- trang_thai - int\n"
                + "    )";
        try {
            PreparedStatement stm = sConn.prepareStatement(query);
            stm.setString(1, voucher.getMaVoucher());
            stm.setString(2, voucher.getTenVoucher());
            stm.setInt(3, voucher.getSoLuongVoucher());
            stm.setDouble(4, voucher.getGioiHanGiamToiThieu());
            stm.setDouble(5, voucher.getGioiHanGiamToiDa());
            stm.setString(6, voucher.getNgayBatDau());
            stm.setString(7, voucher.getNgayKetThuc());
            stm.setString(8, voucher.getHinhThucGiam());
            stm.setInt(9, voucher.getTrangThai());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateVoucherToDb(Voucher voucher) {
        Connection sConn = ConnectDB.getConnection();
        String query = "UPDATE dbo.Voucher\n"
                + "SET \n"
                + "    ten_voucher = ?,       -- nvarchar(50)\n"
                + "    so_luong_voucher = ?,  -- int\n"
                + "    gioi_han_giam_toi_thieu = ?, -- money\n"
                + "    gioi_han_giam_toi_da = ?,    -- money\n"
                + "    ngay_bat_dau = ?,      -- date\n"
                + "    ngay_ket_thuc = ?,     -- date\n"
                + "    hinh_thuc_giam = ?,    -- nvarchar(50)\n"
                + "    trang_thai = ?         -- int\n"
                + "WHERE \n"
                + "    ma_voucher = ?         -- varchar(10)";
        try {
            PreparedStatement stm = sConn.prepareStatement(query);
            stm.setString(1, voucher.getTenVoucher());
            stm.setInt(2, voucher.getSoLuongVoucher());
            stm.setDouble(3, voucher.getGioiHanGiamToiThieu());
            stm.setDouble(4, voucher.getGioiHanGiamToiDa());
            stm.setString(5, voucher.getNgayBatDau());
            stm.setString(6, voucher.getNgayKetThuc());
            stm.setString(7, voucher.getHinhThucGiam());
            stm.setInt(8, voucher.getTrangThai());
            stm.setString(9, voucher.getMaVoucher());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeVoucherToDb(String maVoucher) {
        Connection sConn = ConnectDB.getConnection();
        String query = "UPDATE dbo.Voucher SET trang_thai = 0 WHERE ma_voucher = ?";
        try {
            PreparedStatement stm = sConn.prepareStatement(query);
            stm.setString(1, maVoucher);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
