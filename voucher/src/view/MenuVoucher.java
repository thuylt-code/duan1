/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import entity.Voucher;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import logic.RandomStringGenerator;
import repository.repo_voucher;
import logic.Validate;

/**
 *
 * @author DUNG
 */
public class MenuVoucher extends javax.swing.JInternalFrame {

    TableRowSorter<TableModel> sorterSearch;
    DefaultTableModel model = null;
    ArrayList<Voucher> vouchers = null;
    repo_voucher repo_voucher = new repo_voucher();

    /**
     * Creates new form MenuVoucher
     */
    public MenuVoucher() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        model = (DefaultTableModel) tblVoucher.getModel();
        sorterSearch = new TableRowSorter<>(model);
        tblVoucher.setRowSorter(sorterSearch);

        rdConHang.setSelected(true);
        loadListVoucherToTable();

        ArrayList<String> cboxSearchItems = getColumnNameVoucher();
        for (String i : cboxSearchItems) {
            cboxSearchVoucher.addItem(i);
        }
    }

    public void loadListVoucherToTable() {
        vouchers = repo_voucher.getListVoucherFromDb();
        model.setRowCount(0);
        for (Voucher i : vouchers) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dateStart = simpleDateFormat.format(i.getNgayBatDau());
            String dateEnd = simpleDateFormat.format(i.getNgayKetThuc());
            String trangThai;
            switch (i.getTrangThai()) {
                case 0:
                    trangThai = "Hết hàng";
                    break;
                case 1:
                    trangThai = "Còn hàng";
                    break;
                default:
                    throw new AssertionError();
            };
            String mucGiam = formatMucGiam(i.getMucGia(), i.getGioiHanGiamToiDa());
            if (rdConHang.isSelected() && i.getTrangThai() == 1) {
                model.addRow(new Object[]{
                    i.getMaVoucher(), i.getTenVoucher(), i.getSoLuongVoucher(), i.getGioiHanGiamToiThieu(), i.getGioiHanGiamToiDa(), mucGiam, dateStart, dateEnd, i.getHinhThucGiam(), trangThai});

            } else if (rdHetHang.isSelected() && i.getTrangThai() == 0) {

                model.addRow(new Object[]{
                    i.getMaVoucher(), i.getTenVoucher(), i.getSoLuongVoucher(), i.getGioiHanGiamToiThieu(), i.getGioiHanGiamToiDa(), mucGiam, dateStart, dateEnd, i.getHinhThucGiam(), trangThai});

            }
        }
    }

    public String formatMucGiam(int mucGiam, double gioiHanGiamGiaToiDa) {
        if (mucGiam <= 100) {
            return mucGiam + "% cua " + gioiHanGiamGiaToiDa;
        } else {
            return mucGiam + "VND";
        }
    }

    public Voucher getVoucherFormMa(String maVoucher) {
        for (Voucher i : vouchers) {
            if (i.getMaVoucher().equals(maVoucher)) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<String> getColumnNameVoucher() {
        TableColumnModel columnModel = tblVoucher.getColumnModel();
        ArrayList<String> columnNames = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String columnName = columnModel.getColumn(i).getHeaderValue().toString();
            columnNames.add(columnName);
        }
        return columnNames;
    }

    private Voucher getNewVoucherFromForm() {
        Date dateStart = dateLocNgayBatDau.getDate();
        Date dateEnd = dateLocNgayKetThuc.getDate();
        Voucher voucher = new Voucher(
                RandomStringGenerator.generateRandomString("VC"), // maVoucher
                txtTenVoucher.getText(), // tenVoucher
                cboxHinhThucGiam.getSelectedItem().toString(), // hinhThucGiam
                Integer.parseInt(txtSoLuong.getText()), // soLuongVoucher
                1, // trangThai
                Double.parseDouble(txtGioiHanGiamToiThieu.getText()), // gioiHanGiamToiThieu
                Double.parseDouble(txtGioiHanGiamToiDa.getText()), // gioiHanGiamToiDa
                dateStart, // ngayBatDau
                dateEnd,// ngayKetThuc
                Integer.parseInt(txtMucGiam.getText())
        );
        return voucher;
    }

    private Validate check() {
        Validate validate = new Validate();
        validate.khongDuocTrong(txtTenVoucher, txtMucGiam, txtGioiHanGiamToiThieu, txtGioiHanGiamToiDa, txtSoLuong);
        validate.chiDuocChuaSo(txtMucGiam, txtGioiHanGiamToiThieu, txtGioiHanGiamToiDa, txtSoLuong);
        if (cboxHinhThucGiam.getSelectedIndex() == 0) {
            validate.mucGiamTheoSoTienPhaiLonHon1000VND(txtMucGiam);
        } else {
            validate.mucGiamTheoPhanTramPhaiLonHon0VaBeHon100(txtMucGiam);
        }
        validate.khongDuocTrong("Thời gian bắt đầu", dateLocNgayBatDau.getDate() + "");
        validate.khongDuocTrong("Thời gian kết thúc", dateLocNgayKetThuc.getDate() + "");
        validate.checkDateIsAfterOrEqualCurrent(dateLocNgayBatDau);
        validate.checkDateIsBefore(dateLocNgayBatDau, dateLocNgayKetThuc);
        validate.phaiLonHon0(txtGioiHanGiamToiDa, txtGioiHanGiamToiThieu, txtMucGiam, txtMucGiam);
        return validate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rdConHang = new javax.swing.JRadioButton();
        rdHetHang = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnXoaVoucher = new javax.swing.JButton();
        btnSuaVoucher = new javax.swing.JButton();
        btnThemVoucher = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboxHinhThucGiam = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dateLocNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dateLocNgayKetThuc = new com.toedter.calendar.JDateChooser();
        txtTenVoucher = new com.raven.swing.TextField();
        txtGioiHanGiamToiThieu = new com.raven.swing.TextField();
        txtGioiHanGiamToiDa = new com.raven.swing.TextField();
        txtMucGiam = new com.raven.swing.TextField();
        txtSoLuong = new com.raven.swing.TextField();
        jPanel4 = new javax.swing.JPanel();
        txtSearchVoucher = new javax.swing.JTextField();
        cboxSearchVoucher = new javax.swing.JComboBox<>();

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên voucher", "Số lượng", "Giới hạn giảm tối thiểu", "Giới hạn giảm tối đa", "Mức Giảm", "Ngày bắt đầu", "Ngày kết thúc", "Hình thức giảm", "Trạng thái"
            }
        ));
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucher);
        if (tblVoucher.getColumnModel().getColumnCount() > 0) {
            tblVoucher.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(rdConHang);
        rdConHang.setText("Còn hàng");
        rdConHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdConHangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdHetHang);
        rdHetHang.setText("Hết hàng");
        rdHetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHetHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdConHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(rdHetHang)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdConHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdHetHang))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnReset.setBackground(new java.awt.Color(255, 153, 0));
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnXoaVoucher.setBackground(new java.awt.Color(255, 153, 0));
        btnXoaVoucher.setText("Xóa");
        btnXoaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVoucherActionPerformed(evt);
            }
        });

        btnSuaVoucher.setBackground(new java.awt.Color(255, 153, 0));
        btnSuaVoucher.setText("Sửa ");
        btnSuaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVoucherActionPerformed(evt);
            }
        });

        btnThemVoucher.setBackground(new java.awt.Color(255, 153, 0));
        btnThemVoucher.setText("Thêm ");
        btnThemVoucher.setBorderPainted(false);
        btnThemVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVoucherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaVoucher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Hình thức giảm");

        cboxHinhThucGiam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm giá theo số tiền", "Giảm giá theo %", "" }));

        jLabel5.setText("Thời gian bắt đầu ");

        dateLocNgayBatDau.setDateFormatString("dd-MM-yyyy");

        jLabel6.setText("Thời gian kết thúc");

        dateLocNgayKetThuc.setDateFormatString("dd-MM-yyyy");

        txtTenVoucher.setLabelText("Tên voucher");

        txtGioiHanGiamToiThieu.setLabelText("Giới hạn giảm tối thiểu");

        txtGioiHanGiamToiDa.setLabelText("Giới hạn giảm tối đa");

        txtMucGiam.setLabelText("Mức giảm");

        txtSoLuong.setLabelText("Số lượng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxHinhThucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLocNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(txtGioiHanGiamToiThieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMucGiam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLocNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(txtGioiHanGiamToiDa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(525, 525, 525)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGioiHanGiamToiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiHanGiamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxHinhThucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLocNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLocNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtMucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(167, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtSearchVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchVoucherActionPerformed(evt);
            }
        });

        cboxSearchVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSearchVoucherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboxSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(987, 987, 987)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(335, 335, 335)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(430, 430, 430))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVoucherActionPerformed
        Validate validate = check();
        if (validate.isChuoiHopLe()) {
            Voucher voucher = getNewVoucherFromForm();
            repo_voucher.addVoucherToDB(voucher);
            loadListVoucherToTable();
        } else {
            validate.showWarning(this);
        }
    }//GEN-LAST:event_btnThemVoucherActionPerformed

    private void btnSuaVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVoucherActionPerformed
        int index = tblVoucher.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn dòng muốn sửa");
        } else {
            Validate validate = check();
            if (validate.isChuoiHopLe()) {
                Voucher voucher = getNewVoucherFromForm();
                String maVoucher = tblVoucher.getValueAt(index, 0).toString();
                voucher.setMaVoucher(maVoucher);
                repo_voucher.updateVoucherToDb(voucher);
                loadListVoucherToTable();
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
            } else {
                validate.showWarning(this);
            }
        }

    }//GEN-LAST:event_btnSuaVoucherActionPerformed

    private void rdHetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHetHangActionPerformed
        loadListVoucherToTable();
    }//GEN-LAST:event_rdHetHangActionPerformed

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        int index = tblVoucher.getSelectedRow();
        Voucher voucher = getVoucherFormMa(tblVoucher.getValueAt(index, 0).toString());

        txtTenVoucher.setText(voucher.getTenVoucher());
        cboxHinhThucGiam.setSelectedItem(voucher.getHinhThucGiam());
        txtGioiHanGiamToiDa.setText(voucher.getGioiHanGiamToiDa() + "");
        txtGioiHanGiamToiThieu.setText(voucher.getGioiHanGiamToiThieu() + "");
        dateLocNgayBatDau.setDate(voucher.getNgayBatDau());
        dateLocNgayKetThuc.setDate(voucher.getNgayKetThuc());
        txtMucGiam.setText(formatMucGiam(voucher.getMucGia(), voucher.getGioiHanGiamToiDa()));
        txtSoLuong.setText(voucher.getSoLuongVoucher() + "");
        cboxSearchVoucher.setSelectedItem(voucher.getHinhThucGiam());
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void btnXoaVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVoucherActionPerformed
        int index = tblVoucher.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn dòng muốn xóa");
        } else {
            String maVoucher = tblVoucher.getValueAt(index, 0).toString();
            repo_voucher.removeVoucherToDb(maVoucher);
            loadListVoucherToTable();
            JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
        }
    }//GEN-LAST:event_btnXoaVoucherActionPerformed

    private void rdConHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdConHangActionPerformed
        loadListVoucherToTable();
    }//GEN-LAST:event_rdConHangActionPerformed

    private void txtSearchVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchVoucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchVoucherActionPerformed

    private void cboxSearchVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSearchVoucherActionPerformed
        txtSearchVoucher.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(txtSearchVoucher.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(txtSearchVoucher.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(txtSearchVoucher.getText());
            }

            private void search(String text) {
                int columnIndex = cboxSearchVoucher.getSelectedIndex();
                sorterSearch.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
            }
        });
    }//GEN-LAST:event_cboxSearchVoucherActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtTenVoucher.setText("");
        txtGioiHanGiamToiDa.setText("");
        txtGioiHanGiamToiThieu.setText("");
        dateLocNgayBatDau.setDate(null);
        dateLocNgayKetThuc.setDate(null);
        txtMucGiam.setText("");
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSuaVoucher;
    private javax.swing.JButton btnThemVoucher;
    private javax.swing.JButton btnXoaVoucher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboxHinhThucGiam;
    private javax.swing.JComboBox<String> cboxSearchVoucher;
    private com.toedter.calendar.JDateChooser dateLocNgayBatDau;
    private com.toedter.calendar.JDateChooser dateLocNgayKetThuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdConHang;
    private javax.swing.JRadioButton rdHetHang;
    private javax.swing.JTable tblVoucher;
    private com.raven.swing.TextField txtGioiHanGiamToiDa;
    private com.raven.swing.TextField txtGioiHanGiamToiThieu;
    private com.raven.swing.TextField txtMucGiam;
    private javax.swing.JTextField txtSearchVoucher;
    private com.raven.swing.TextField txtSoLuong;
    private com.raven.swing.TextField txtTenVoucher;
    // End of variables declaration//GEN-END:variables
}
