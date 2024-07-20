/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package view;

import java.awt.Color;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;

/**
 *
 * @author DUNG
 */
public class NewJFrame extends javax.swing.JFrame {

    private DrawerController drawer;
    Color DefaulttColor,ClickedColor;
    
    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
        DefaulttColor = new Color(255,204,0);
        ClickedColor = new Color(240,151,57);
        
        menu_ban_hang.setBackground(DefaulttColor);
        menu_san_pham.setBackground(DefaulttColor);
        menu_hoa_don.setBackground(DefaulttColor);
        menu_nhan_vien.setBackground(DefaulttColor);
        menu_khach_hang.setBackground(DefaulttColor);
        menu_thong_ke.setBackground(DefaulttColor);
        menu_exit.setBackground(DefaulttColor);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        imageAvatar1 = new view.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        menu_ban_hang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menu_san_pham = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        menu_hoa_don = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        menu_nhan_vien = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        menu_khach_hang = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        menu_thong_ke = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        menu_exit = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        menu_exit1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(1130, 720));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        imageAvatar1.setBorderSize(2);
        imageAvatar1.setBorderSpace(2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đàm Văn Tiến Dũng");

        menu_ban_hang.setBackground(new java.awt.Color(255, 204, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shop.png"))); // NOI18N
        jLabel2.setText("Bán hàng");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu_ban_hangLayout = new javax.swing.GroupLayout(menu_ban_hang);
        menu_ban_hang.setLayout(menu_ban_hangLayout);
        menu_ban_hangLayout.setHorizontalGroup(
            menu_ban_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_ban_hangLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_ban_hangLayout.setVerticalGroup(
            menu_ban_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        menu_san_pham.setBackground(new java.awt.Color(255, 204, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        jLabel4.setText("Sản phẩm");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu_san_phamLayout = new javax.swing.GroupLayout(menu_san_pham);
        menu_san_pham.setLayout(menu_san_phamLayout);
        menu_san_phamLayout.setHorizontalGroup(
            menu_san_phamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_san_phamLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_san_phamLayout.setVerticalGroup(
            menu_san_phamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        menu_hoa_don.setBackground(new java.awt.Color(255, 204, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        jLabel8.setText("Hóa Đơn");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menu_hoa_donLayout = new javax.swing.GroupLayout(menu_hoa_don);
        menu_hoa_don.setLayout(menu_hoa_donLayout);
        menu_hoa_donLayout.setHorizontalGroup(
            menu_hoa_donLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_hoa_donLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_hoa_donLayout.setVerticalGroup(
            menu_hoa_donLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        menu_nhan_vien.setBackground(new java.awt.Color(255, 204, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cilent.png"))); // NOI18N
        jLabel11.setText("Nhân viên");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu_nhan_vienLayout = new javax.swing.GroupLayout(menu_nhan_vien);
        menu_nhan_vien.setLayout(menu_nhan_vienLayout);
        menu_nhan_vienLayout.setHorizontalGroup(
            menu_nhan_vienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_nhan_vienLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_nhan_vienLayout.setVerticalGroup(
            menu_nhan_vienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        menu_khach_hang.setBackground(new java.awt.Color(255, 204, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        jLabel12.setText("Khách hàng");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu_khach_hangLayout = new javax.swing.GroupLayout(menu_khach_hang);
        menu_khach_hang.setLayout(menu_khach_hangLayout);
        menu_khach_hangLayout.setHorizontalGroup(
            menu_khach_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_khach_hangLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        menu_khach_hangLayout.setVerticalGroup(
            menu_khach_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        menu_thong_ke.setBackground(new java.awt.Color(255, 204, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/statistic.png"))); // NOI18N
        jLabel13.setText("Thống kê");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu_thong_keLayout = new javax.swing.GroupLayout(menu_thong_ke);
        menu_thong_ke.setLayout(menu_thong_keLayout);
        menu_thong_keLayout.setHorizontalGroup(
            menu_thong_keLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_thong_keLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_thong_keLayout.setVerticalGroup(
            menu_thong_keLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        menu_exit.setBackground(new java.awt.Color(255, 204, 0));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/voucher_3837379.png"))); // NOI18N
        jLabel14.setText("Voucher");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu_exitLayout = new javax.swing.GroupLayout(menu_exit);
        menu_exit.setLayout(menu_exitLayout);
        menu_exitLayout.setHorizontalGroup(
            menu_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_exitLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_exitLayout.setVerticalGroup(
            menu_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        menu_exit1.setBackground(new java.awt.Color(255, 204, 0));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        jLabel15.setText("Đăng xuất");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu_exit1Layout = new javax.swing.GroupLayout(menu_exit1);
        menu_exit1.setLayout(menu_exit1Layout);
        menu_exit1Layout.setHorizontalGroup(
            menu_exit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_exit1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu_exit1Layout.setVerticalGroup(
            menu_exit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_ban_hang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_san_pham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_hoa_don, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_nhan_vien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_khach_hang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_thong_ke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(menu_exit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(menu_ban_hang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu_san_pham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_hoa_don, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_nhan_vien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_khach_hang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_thong_ke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu_exit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 272, 751);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        jPanel2.add(jDesktopPane1);
        jDesktopPane1.setBounds(270, 0, 860, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        MenuBanHang mbh = new MenuBanHang();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(mbh).setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        MenuSanPham msp = new MenuSanPham();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(msp).setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        menu_ban_hang.setBackground(ClickedColor);
        menu_san_pham.setBackground(DefaulttColor);
        menu_hoa_don.setBackground(DefaulttColor);
        menu_nhan_vien.setBackground(DefaulttColor);
        menu_khach_hang.setBackground(DefaulttColor);
        menu_thong_ke.setBackground(DefaulttColor);
        menu_exit.setBackground(DefaulttColor);
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        menu_ban_hang.setBackground(DefaulttColor);
        menu_san_pham.setBackground(ClickedColor);
        menu_hoa_don.setBackground(DefaulttColor);
        menu_nhan_vien.setBackground(DefaulttColor);
        menu_khach_hang.setBackground(DefaulttColor);
        menu_thong_ke.setBackground(DefaulttColor);
        menu_exit.setBackground(DefaulttColor);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        menu_ban_hang.setBackground(DefaulttColor);
        menu_san_pham.setBackground(DefaulttColor);
        menu_hoa_don.setBackground(ClickedColor);
        menu_nhan_vien.setBackground(DefaulttColor);
        menu_khach_hang.setBackground(DefaulttColor);
        menu_thong_ke.setBackground(DefaulttColor);
        menu_exit.setBackground(DefaulttColor);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        // TODO add your handling code here:
        menu_ban_hang.setBackground(DefaulttColor);
        menu_san_pham.setBackground(DefaulttColor);
        menu_hoa_don.setBackground(DefaulttColor);
        menu_nhan_vien.setBackground(ClickedColor);
        menu_khach_hang.setBackground(DefaulttColor);
        menu_thong_ke.setBackground(DefaulttColor);
        menu_exit.setBackground(DefaulttColor);
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        menu_ban_hang.setBackground(DefaulttColor);
        menu_san_pham.setBackground(DefaulttColor);
        menu_hoa_don.setBackground(DefaulttColor);
        menu_nhan_vien.setBackground(DefaulttColor);
        menu_khach_hang.setBackground(ClickedColor);
        menu_thong_ke.setBackground(DefaulttColor);
        menu_exit.setBackground(DefaulttColor);
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
        menu_ban_hang.setBackground(DefaulttColor);
        menu_san_pham.setBackground(DefaulttColor);
        menu_hoa_don.setBackground(DefaulttColor);
        menu_nhan_vien.setBackground(DefaulttColor);
        menu_khach_hang.setBackground(DefaulttColor);
        menu_thong_ke.setBackground(ClickedColor);
        menu_exit.setBackground(DefaulttColor);
    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        // TODO add your handling code here:
        menu_ban_hang.setBackground(DefaulttColor);
        menu_san_pham.setBackground(DefaulttColor);
        menu_hoa_don.setBackground(DefaulttColor);
        menu_nhan_vien.setBackground(DefaulttColor);
        menu_khach_hang.setBackground(DefaulttColor);
        menu_thong_ke.setBackground(DefaulttColor);
        menu_exit.setBackground(ClickedColor);
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.ImageAvatar imageAvatar1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel menu_ban_hang;
    private javax.swing.JPanel menu_exit;
    private javax.swing.JPanel menu_exit1;
    private javax.swing.JPanel menu_hoa_don;
    private javax.swing.JPanel menu_khach_hang;
    private javax.swing.JPanel menu_nhan_vien;
    private javax.swing.JPanel menu_san_pham;
    private javax.swing.JPanel menu_thong_ke;
    // End of variables declaration//GEN-END:variables

}
