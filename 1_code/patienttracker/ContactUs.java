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
import static patienttracker.MyHealth.patientMenu;

/**
 *
 * @author siarasaylor
 */
//-----------------------------------
class ContactUs {

    ContactUs() {
        contact();
    }

    static JFrame patientHome;
    static JPanel mainPanel2;
    static JMenuBar patientMenu;
    static JMenuItem scheduleAppt;
    static JMenuItem refills;
    static JMenuItem myHealth;
    static JMenuItem profilePage;
    static JMenuItem contactUs;
    static JMenu patientexit;
    static JMenuItem logout;
    static JMenuItem exit;

    public static void contact() {
        System.out.println("Contact Us");

        //set up items
        JLabel patientContact = new JLabel("Contact Us");
        patientMenu = new JMenuBar();
        UIManager.put("MenuBar.background", Color.ORANGE);
        profilePage = new JMenuItem("Profile");
        scheduleAppt = new JMenuItem("Schedule Appointment");
        refills = new JMenuItem("Prescription Refills");
        myHealth = new JMenuItem("My Health");
        contactUs = new JMenuItem("Contact Us");
        
        patientexit = new JMenu("Exit");
        logout = new JMenuItem("Log Out");
        exit = new JMenuItem("Exit");
        
        mainPanel2 = new JPanel();
        patientMenu.setPreferredSize(new Dimension(patientMenu.getPreferredSize().width, 30));

        //set frame size and location
        patientHome = new JFrame("Patient Tracker - My Health");
        patientHome.setSize(1300,800);
        patientHome.setLocationRelativeTo(null);
        //mainPanel2.setLayout(null);

        //action to go to Profile page when button is clicked
        profilePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientMenu pat = new PatientMenu();
                patientHome.dispose(); //close screen
            }
        });
        //action to go to Schedule Appointment page when button is clicked
        scheduleAppt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScheduleAppointment sched = new ScheduleAppointment();
                patientHome.dispose(); //close screen
            }
        });
        //action to go to My Health page when button is clicked
        myHealth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MyHealth health = new MyHealth();
                patientHome.dispose(); //close screen
            }
        });
        //action to go to Contact page when button is clicked
        contactUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ContactUs con = new ContactUs();
                patientHome.dispose(); //close screen
            }
        });
        //action to go to Refills page when button is clicked
        refills.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PresRefills refill = new PresRefills();
                patientHome.dispose(); //close screen
            }
        });
        //action to close when button is clicked
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                patientHome.dispose(); //close screen
                System.exit(0);
            }
        });
        //action to close when button is clicked
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginWindow login = new loginWindow();
                patientHome.dispose(); //close screen
                //System.exit(0);
            }
        });
        //add items to menu
        patientexit.add(logout);
        patientexit.add(exit);
        patientMenu.add(profilePage);
        patientMenu.add(scheduleAppt);
        patientMenu.add(refills);
        patientMenu.add(myHealth);
        patientMenu.add(contactUs);
        patientMenu.add(patientexit);

        //add items to panel
        mainPanel2.add(patientContact);
        
        //add panels to JFrame
        patientHome.getContentPane().add(BorderLayout.NORTH, patientMenu);
        patientHome.getContentPane().add(BorderLayout.CENTER,mainPanel2);
        patientHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientHome.setResizable(false);
        patientHome.setVisible(true);
        
        mainPanel2.setBackground(Color.WHITE);
    }
}
