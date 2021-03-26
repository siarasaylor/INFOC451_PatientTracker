/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patienttracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author siarasaylor
 */
//--------------------------------------------------------------------------
//Doctor View
class prescriptionApprovals extends StaffMenuFDN{
    prescriptionApprovals(){
        papprovals();
    }
    
    public static void papprovals(){
        System.out.println("Prescription Approvals");

        //set up items
        JLabel pApprovals = new JLabel("Prescription Approvals");
        
        JPanel mainPanel = new JPanel();

        //set frame size and location
        JFrame staffHome = new JFrame("Patient Tracker - Prescription Approvals");
        staffHome.setSize(1300,800);
        staffHome.setLocationRelativeTo(null);
        //mainPanel.setLayout(null);

        
        //add items to panel
        mainPanel.add(pApprovals);
        
        if (userInput.startsWith("1") && userInput.length() > 2) {
            System.out.println("Doctor View");
            staffHome.getContentPane().add(BorderLayout.NORTH, dstaffMenu);

        }
        if (userInput.startsWith("2") && userInput.length() > 2) {
            System.out.println("Nurse View");
            staffHome.getContentPane().add(BorderLayout.NORTH, nstaffMenu);

        }
        
        staffHome.getContentPane().add(BorderLayout.CENTER,mainPanel);
        staffHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staffHome.setResizable(false);
        staffHome.setVisible(true);   
        mainPanel.setBackground(Color.WHITE);
    }
}
