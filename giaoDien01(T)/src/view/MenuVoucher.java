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
            if (rdConHang.isSelected() && i.getTrangThai() == 1) {
                model.addRow(new Object[]{
                    i.getMaVoucher(), i.getTenVoucher(), i.getSoLuongVoucher(), i.getGioiHanGiamToiThieu(), i.getGioiHanGiamToiDa(), dateStart, dateEnd, i.getHinhThucGiam(), trangThai});

            } else if (rdHetHang.isSelected() && i.getTrangThai() == 0) {

                model.addRow(new Object[]{
                    i.getMaVoucher(), i.getTenVoucher(), i.getSoLuongVoucher(), i.getGioiHanGiamToiThieu(), i.getGioiHanGiamToiDa(), dateStart, dateEnd, i.getHinhThucGiam(), trangThai});

            }

        }
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
                txtHinhThucGiam.getSelectedItem().toString(), // hinhThucGiam
                Integer.parseInt(txtSoLuong.getText()), // soLuongVoucher
                1, // trangThai
                Double.parseDouble(txtGioiHanGiamToiThieu.getText()), // gioiHanGiamToiThieu
                Double.parseDouble(txtGioiHanGiamToiDa.getText()), // gioiHanGiamToiDa
                dateStart, // ngayBatDau
                dateEnd// ngayKetThuc
        );
        return voucher;
    }

    private Validate check() {
        Validate validate = new Validate();
        validate.checkNull("Tên voucher", txtTenVoucher.getText());
        validate.checkNull("Số lượng", txtSoLuong.getText());
        validate.checkNumber("Số lượng", txtSoLuong.getText());
        validate.checkNull("Giới hạn giảm tối thiểu", txtGioiHanGiamToiThieu.getText());
        validate.checkNumber("Giới hạn giảm tối thiểu", txtGioiHanGiamToiThieu.getText());
        validate.checkNull("Giới hạn giảm tối đa", txtGioiHanGiamToiDa.getText());
        validate.checkNumber("Giới hạn giảm tối đa", txtGioiHanGiamToiDa.getText());
        validate.checkNull("Thời gian bắt đầu", dateLocNgayBatDau.getDate() + "");
        validate.checkNull("Thời gian kết thúc", dateLocNgayKetThuc.getDate() + "");
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

        jLabel2 = new javax.swing.JLabel();
        txtTenVoucher = new javax.swing.JTextField();
        btnThemVoucher = new javax.swing.JButton();
        txtGioiHanGiamToiThieu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSuaVoucher = new javax.swing.JButton();
        rdHetHang = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnXoaVoucher = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtGioiHanGiamToiDa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdConHang = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        txtSearchVoucher = new javax.swing.JTextField();
        cboxSearchVoucher = new javax.swing.JComboBox<>();
        dateLocNgayBatDau = new com.toedter.calendar.JDateChooser();
        dateLocNgayKetThuc = new com.toedter.calendar.JDateChooser();
        txtHinhThucGiam = new javax.swing.JComboBox<>();

        jLabel2.setText("Hình thức giảm");

        btnThemVoucher.setBackground(new java.awt.Color(255, 153, 0));
        btnThemVoucher.setText("Thêm ");
        btnThemVoucher.setBorderPainted(false);
        btnThemVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVoucherActionPerformed(evt);
            }
        });

        jLabel4.setText("Giới hạn giảm tối đa");

        btnSuaVoucher.setBackground(new java.awt.Color(255, 153, 0));
        btnSuaVoucher.setText("Sửa ");
        btnSuaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVoucherActionPerformed(evt);
            }
        });

        rdHetHang.setText("Hết hàng");
        rdHetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHetHangActionPerformed(evt);
            }
        });

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên voucher", "Số lượng", "Giới hạn giảm tối thiểu", "Giới hạn giảm tối đa", "Ngày bắt đầu", "Ngày kết thúc", "Hình thức giảm", "Trạng thái"
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

        jLabel6.setText("Thời gian kết thúc");

        btnXoaVoucher.setBackground(new java.awt.Color(255, 153, 0));
        btnXoaVoucher.setText("Xóa");
        btnXoaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVoucherActionPerformed(evt);
            }
        });

        jLabel7.setText("Số lượng");

        jLabel3.setText("Giới hạn giảm tối thiếu");

        rdConHang.setText("Còn hàng");
        rdConHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdConHangActionPerformed(evt);
            }
        });

        jLabel5.setText("Thời gian bắt đầu ");

        jLabel1.setText("Tên voucher");

        btnReset.setBackground(new java.awt.Color(255, 153, 0));
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

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

        dateLocNgayBatDau.setDateFormatString("dd-MM-yyyy");

        dateLocNgayKetThuc.setDateFormatString("dd-MM-yyyy");

        txtHinhThucGiam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm giá theo số tiền", "Giảm giá theo phần trăm", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboxSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdConHang))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenVoucher, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHinhThucGiam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(40, 40, 40)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(txtGioiHanGiamToiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addComponent(btnSuaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(btnXoaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dateLocNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGioiHanGiamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(dateLocNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jLabel7)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(97, 97, 97)
                .addComponent(rdHetHang)
                .addGap(294, 294, 294))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGioiHanGiamToiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGioiHanGiamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dateLocNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(txtTenVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addComponent(txtHinhThucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateLocNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdHetHang)
                    .addComponent(rdConHang)
                    .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            validate.showWarning(rootPane);
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
                validate.showWarning(rootPane);
            }
        }
    }//GEN-LAST:event_btnSuaVoucherActionPerformed

    private void rdHetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHetHangActionPerformed
        loadListVoucherToTable();
    }//GEN-LAST:event_rdHetHangActionPerformed

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        int index = tblVoucher.getSelectedRow();
        Voucher voucher = vouchers.get(index);

        txtTenVoucher.setText(voucher.getTenVoucher());
        txtHinhThucGiam.setSelectedItem(voucher.getHinhThucGiam());
        txtGioiHanGiamToiDa.setText(voucher.getGioiHanGiamToiDa() + "");
        txtGioiHanGiamToiThieu.setText(voucher.getGioiHanGiamToiThieu() + "");
        dateLocNgayBatDau.setDate(voucher.getNgayBatDau());
        dateLocNgayKetThuc.setDate(voucher.getNgayKetThuc());
        txtSoLuong.setText(voucher.getSoLuongVoucher() + "");
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
        dateLocNgayBatDau.setDateFormatString("");
        dateLocNgayKetThuc.setDateFormatString("");
        txtSoLuong.setText("");
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSuaVoucher;
    private javax.swing.JButton btnThemVoucher;
    private javax.swing.JButton btnXoaVoucher;
    private javax.swing.JComboBox<String> cboxSearchVoucher;
    private com.toedter.calendar.JDateChooser dateLocNgayBatDau;
    private com.toedter.calendar.JDateChooser dateLocNgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdConHang;
    private javax.swing.JRadioButton rdHetHang;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTextField txtGioiHanGiamToiDa;
    private javax.swing.JTextField txtGioiHanGiamToiThieu;
    private javax.swing.JComboBox<String> txtHinhThucGiam;
    private javax.swing.JTextField txtSearchVoucher;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenVoucher;
    // End of variables declaration//GEN-END:variables
}
