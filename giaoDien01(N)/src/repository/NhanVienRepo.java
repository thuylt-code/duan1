/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import util.ConnectDB;
import repository.NhanVienResp;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author DUNG
 */
public class NhanVienRepo {

    public List<NhanVienResp> getAllDangLam() {

        String query = """
                       SELECT dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.ID, dbo.Nhan_vien.so_dt, dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh, 
                                                                                                 dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, dbo.Nhan_vien.trang_thai
                                                                                    FROM   dbo.Chuc_vu INNER JOIN
                                                                                                 dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                       where [trang_thai]=1
                       """;
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            List<NhanVienResp> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienResp nv = NhanVienResp.builder()
                        .maChucVu(rs.getString(1))
                        .tenChucVu(rs.getString(2))
                        .maNhanVien(rs.getString(3))
                        .hoTen(rs.getString(4))
                        .luong(rs.getDouble(5))
                        .id(rs.getInt(6))
                        .sdt(rs.getString(7))
                        .email(rs.getString(8))
                        .diaChi(rs.getString(9))
                        .ngaySinh(rs.getDate(10))
                        .gioiTinh(rs.getBoolean(11))
                        .ngayBatDau(rs.getDate(12))
                        .matKhau(rs.getString(13))
                        .trangThai(rs.getInt(14))
                        //                        .idChucVu(rs.getInt(15))
                        .build();
                list.add(nv);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NhanVienResp> getAllNghiViec() {

        String query = """
                       SELECT dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.ID, dbo.Nhan_vien.so_dt, dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh, 
                                                                                                 dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, dbo.Nhan_vien.trang_thai
                                                                                    FROM   dbo.Chuc_vu INNER JOIN
                                                                                                 dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                       where [trang_thai]=0
                       """;
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            List<NhanVienResp> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienResp nv = NhanVienResp.builder()
                        .maChucVu(rs.getString(1))
                        .tenChucVu(rs.getString(2))
                        .maNhanVien(rs.getString(3))
                        .hoTen(rs.getString(4))
                        .luong(rs.getDouble(5))
                        .id(rs.getInt(6))
                        .sdt(rs.getString(7))
                        .email(rs.getString(8))
                        .diaChi(rs.getString(9))
                        .ngaySinh(rs.getDate(10))
                        .gioiTinh(rs.getBoolean(11))
                        .ngayBatDau(rs.getDate(12))
                        .matKhau(rs.getString(13))
                        .trangThai(rs.getInt(14))
                        //                        .idChucVu(rs.getInt(15))
                        .build();
                list.add(nv);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NhanVienResp> getAll() {

        String query = """
                       SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
                       dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
                       dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
                                                                                     dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
                                                                        FROM   dbo.Chuc_vu INNER JOIN
                                                                                     dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                       """;
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            List<NhanVienResp> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienResp response = new NhanVienResp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getDate(10),
                        rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));
                list.add(response);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(NhanVien nv) {
        int check = 0;
        String sql = """
                     INSERT INTO [dbo].[Nhan_vien]
                                                       ([ma_nhan_vien]
                                                       ,[ho_ten]
                                                       ,[luong]
                                                       ,[so_dt]
                                                       ,[email]
                                                       ,[dia_chi]
                                                       ,[ngay_sinh]
                                                       ,[gioi_tinh]
                                                       ,[ngay_bat_dau]
                                                       ,[mat_khau]
                                                       ,[id_chuc_vu]
                                                       ,[trang_thai])
                                                 VALUES
                                                       (?,?,?,?,?,?,?,?,?,?,?,?)
                    """;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nv.getMaNhanVien());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getLuong());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getNgaySinh());
            ps.setObject(8, nv.getGioiTinh());
            ps.setObject(9, nv.getNgayBatDau());
            ps.setObject(10, nv.getMatKhau());
            ps.setObject(11, nv.getIdChucVu());
            ps.setObject(12, nv.getTrangThai());

            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(Integer id, NhanVien nv) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Nhan_vien]
                          SET [ma_nhan_vien] = ?
                             ,[ho_ten] =?
                             ,[luong] = ?
                             ,[so_dt] = ?
                             ,[email] = ?
                             ,[dia_chi] = ?
                             ,[ngay_sinh] = ?
                             ,[gioi_tinh] = ?
                             ,[ngay_bat_dau] = ?
                             ,[mat_khau] = ?
                             ,[id_chuc_vu] = ?
                             ,[trang_thai] = ?
                        WHERE id = ?
                       """;
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setObject(1, nv.getMaNhanVien());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getLuong());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getNgaySinh());
            ps.setObject(8, nv.getGioiTinh());
            ps.setObject(9, nv.getNgayBatDau());
            ps.setObject(10, nv.getMatKhau());
            ps.setObject(11, nv.getIdChucVu());
            ps.setObject(12, nv.getTrangThai());
            ps.setObject(13, id);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean remove(Integer id) {
        int check = 0;
        String sql = """
                     UPDATE [dbo].[Nhan_vien]
                             SET [trang_thai] = 0
                           WHERE ID = ?
                     """;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    public ArrayList<NhanVienResp> search(String keyword
    ) {
        String sql = """
                   SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
                                             dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
                                             dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
                      					   dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
                      					   FROM   dbo.Chuc_vu INNER JOIN
                      					   dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                      						where 
                     """;
        if (keyword.length() > 0) { // isempty
            sql += """
                   
                  	(ma_nhan_vien like ?
                        or ho_ten like ?
                        or so_dt like ?
                        or email like ?
                        or dia_chi like ?
   			)
                  """;
        } else {
            return null;
        }
        ArrayList<NhanVienResp> lists = new ArrayList<>();
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            int index = 1; // Vi tri cua dau hoi cham dau tien 

            if (keyword.length() > 0) {
                String value = "%" + keyword + "%";
                // search 1 o input nhieu truong
                ps.setObject(index++, value);
                ps.setObject(index++, value);
                ps.setObject(index++, value);
                ps.setObject(index++, value);
                ps.setObject(index++, value);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lists.add(new NhanVienResp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getDate(10),
                        rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14)));

            }
        } catch (Exception e) {
            e.printStackTrace(System.out); // nem loi khi xay ra 
        }
        return lists;
    }

//    public List<NhanVienResp> loc(Integer idCv, Integer gt) {
//
//        String query = """
// SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
//           dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
//           dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
//           dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
//            FROM   dbo.Chuc_vu INNER JOIN
//            dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
//                       
//            where (dbo.Chuc_vu.ID = ? or ? is null)
//            and (dbo.Nhan_vien.gioi_tinh = ? or ? is null)
//                                 
//                       """;
//        List<NhanVienResp> list = new ArrayList<>();
//        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setObject(1, idCv);
//            ps.setObject(2, idCv);
//            ps.setObject(3, gt);
//            ps.setObject(4, gt);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                NhanVienResp response = new NhanVienResp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
//                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getDate(10),
//                        rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));
//                list.add(response);
//            }
//            return list;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public List<NhanVienResp> locVaiTro(Integer idCv) {

        String query = """
                       SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
             dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
         dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
                     dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
                                                      FROM   dbo.Chuc_vu INNER JOIN
                     dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
        				 where dbo.Chuc_vu.ID = ? and [trang_thai]=1
                       """;
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idCv);
            ResultSet rs = ps.executeQuery();
            List<NhanVienResp> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienResp response = new NhanVienResp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getDate(10),
                        rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));
                list.add(response);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<NhanVienResp> loc01(Integer gioiTinh) {

        String query = """
                       SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
                       dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
                      dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
                      dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
                       FROM   dbo.Chuc_vu INNER JOIN
                           dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                                                                                                                                                                                                                                                                                
                            where dbo.Nhan_vien.gioi_tinh = ? and [trang_thai]=1
                       """;
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, gioiTinh);
            ResultSet rs = ps.executeQuery();
            List<NhanVienResp> list = new ArrayList<>();
            while (rs.next()) {
                NhanVienResp response = new NhanVienResp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getDate(10),
                        rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));
                list.add(response);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<NhanVienResp> loc(Integer idCv, Integer gt) {
    List<NhanVienResp> list = new ArrayList<>();
    String query = null;

    if (gt == null && idCv != null) {
        // Khi giới tính là NULL, tìm kiếm theo chức vụ
        query = """
                SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
                       dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
                       dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
                       dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
                FROM dbo.Chuc_vu INNER JOIN
                dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                WHERE dbo.Chuc_vu.ID = ?
                """;
    } else if (idCv == null && gt != null) {
        // Khi chức vụ là NULL, tìm kiếm theo giới tính
        query = """
                SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
                       dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
                       dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
                       dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
                FROM dbo.Chuc_vu INNER JOIN
                dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                WHERE dbo.Nhan_vien.gioi_tinh = ?
                """;
    } else if (idCv != null && gt != null) {
        // Khi cả giới tính và chức vụ đều không phải NULL
        query = """
                SELECT dbo.Nhan_vien.ID, dbo.Nhan_vien.ma_nhan_vien, dbo.Nhan_vien.ho_ten, dbo.Nhan_vien.luong, dbo.Nhan_vien.so_dt,
                       dbo.Nhan_vien.email, dbo.Nhan_vien.dia_chi, dbo.Nhan_vien.ngay_sinh, dbo.Nhan_vien.gioi_tinh,
                       dbo.Nhan_vien.ngay_bat_dau, dbo.Nhan_vien.mat_khau, 
                       dbo.Nhan_vien.trang_thai, dbo.Chuc_vu.ma_chuc_vu, dbo.Chuc_vu.ten_chuc_vu
                FROM dbo.Chuc_vu INNER JOIN
                dbo.Nhan_vien ON dbo.Chuc_vu.ID = dbo.Nhan_vien.id_chuc_vu
                WHERE dbo.Chuc_vu.ID = ? AND dbo.Nhan_vien.gioi_tinh = ?
                """;
    }

    if (query == null) {
        System.out.println("Cả giới tính và chức vụ đều không được NULL.");
        return list;
    }

    try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
        if (gt == null && idCv != null) {
            // Khi giới tính là NULL, thiết lập tham số cho chức vụ
            ps.setInt(1, idCv);
        } else if (idCv == null && gt != null) {
            // Khi chức vụ là NULL, thiết lập tham số cho giới tính
            ps.setInt(1, gt);
        } else if (idCv != null && gt != null) {
            // Khi cả giới tính và chức vụ đều không phải NULL
            ps.setInt(1, idCv);
            ps.setInt(2, gt);
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            NhanVienResp response = new NhanVienResp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getDate(8), rs.getBoolean(9), rs.getDate(10),
                    rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));
            list.add(response);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

}
