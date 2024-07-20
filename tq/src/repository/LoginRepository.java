/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import config.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class LoginRepository {
    
    public String getUser(String maNV, String matKhau) {
        String sql = """
                     SELECT id_chuc_vu FROM Nhan_vien
                     WHERE ma_nhan_vien = ? AND mat_khau = ?
                     """;
        try (Connection con = DBConnect.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {          
            ps.setObject(1, maNV);
            ps.setObject(2, matKhau);
            ResultSet rs = ps.executeQuery();
            String user = null;
            while (rs.next()) {
                user = rs.getString("id_chuc_vu");
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
