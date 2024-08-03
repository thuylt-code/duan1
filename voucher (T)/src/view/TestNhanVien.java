/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import response.NhanVienResp;
import java.util.List;
import repository.NhanVienRepo;

/**
 *
 * @author DUNG
 */
public class TestNhanVien {
     public static void main(String[] args) {
        // Giả sử NhanVienDAO là lớp chứa phương thức getAll()
         NhanVienRepo nhanVienDAO = new NhanVienRepo();
        List<NhanVienResp> nhanVienList = nhanVienDAO.getAll();
        
        // Kiểm tra nếu danh sách không null và không rỗng
        if (nhanVienList != null && !nhanVienList.isEmpty()) {
            System.out.println("Dữ liệu đã được lấy thành công:");
            
            for (NhanVienResp nv : nhanVienList) {
                System.out.println(nv.getTenChucVu());
            }
        } else {
            System.out.println("Không có dữ liệu hoặc lỗi khi lấy dữ liệu.");
        }
    }
}
