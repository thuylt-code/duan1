/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Ca1
 */
public class Validate {

    private boolean chuoiHopLe = true;
    Map<String, String> listWarning = new LinkedHashMap<>();

    public Validate() {
    }

    public void checkNull(String label, String giaTri) {
        if (giaTri.trim().isEmpty() || giaTri.equalsIgnoreCase("null")) {
            listWarning.put(label, label + " không được để trống");
            chuoiHopLe = false;
        }
    }

    ;
    
    public void checkNumber(String label, String number) {
        try {
            Double.parseDouble(number);
        } catch (Exception e) {
            if (!number.isEmpty()) {
                listWarning.put(label, label + " chỉ được chứa số");
            }
            chuoiHopLe = false;
        }
    }

    public boolean isChuoiHopLe() {
        return chuoiHopLe;
    }

    public void setChuoiHopLe(boolean chuoiHopLe) {
        this.chuoiHopLe = chuoiHopLe;
    }

    public void showWarning(JRootPane jRootPane) {
        String warning = "";
        for (Map.Entry<String, String> entry : listWarning.entrySet()) {
            warning += entry.getValue() + "\n";
        }
        JOptionPane.showMessageDialog(jRootPane, warning);
    }
}
