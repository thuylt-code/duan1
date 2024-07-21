/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import swing.Notification;

/**
 *
 * @author Ca1
 */
public class ShowMessageCustom {

   public static void showMessageWarning(JFrame jrFrame, String message) {
        Notification notii = new Notification(jrFrame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, message);
        notii.showNotification();
    }
    
    public static void showMessageSuccess(JFrame jFrame, String message) {
        Notification notii = new Notification(jFrame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, message);
        notii.showNotification();
    }
}
