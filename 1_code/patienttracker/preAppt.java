/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patienttracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author siarasaylor
 */
class preAppt {
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
    preAppt() {
        preapointment();
    }
    static void preapointment() {
        System.out.println("Pre Appointment");

        //set up items
        JLabel scheduleAppointment = new JLabel("Pre Appointment");
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
        patientHome = new JFrame("Patient Tracker - Pre Appointment");
        patientHome.setSize(1300,800);
        patientHome.setLocationRelativeTo(null);
        mainPanel2.setLayout(null);

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
        
        //create items for main panel
        JLabel header1 = new JLabel("Pre Appointment");
        JLabel header2 = new JLabel("Insurance Information");
        JLabel header3 = new JLabel("Pre-Medical Conditions");
        JLabel header4 = new JLabel("List any known allergies.");
        JLabel header5 = new JLabel("List any medications you are taking.");
        
        header1.setFont(new Font("Arial", Font.PLAIN, 30));
        header2.setFont(new Font("Arial", Font.BOLD, 24));
        header3.setFont(new Font("Arial", Font.BOLD, 24));
        header4.setFont(new Font("Arial", Font.PLAIN, 14));
        header5.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel inprovider = new JLabel("Insurance Provider");
        JTextField enterinprovider = new JTextField(50);
        JLabel membernum = new JLabel("Membership Number");
        JTextField entermembernum = new JTextField(25);
        
        JTextArea reason1 = new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        reason1.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        JTextArea reason2 = new JTextArea();
        Border border2 = BorderFactory.createLineBorder(Color.BLACK);
        reason2.setBorder(BorderFactory.createCompoundBorder(border2,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        
        JButton submit = new JButton("Submit");
        
        //image logo
        JLabel img1 = new JLabel(new ImageIcon("logo3.jpg"));
        
        //horizontal line 
        MyLine horizontal1 = new MyLine();
        MyLine horizontal2 = new MyLine();
   
        
        //header
        img1.setBounds(10, 10, img1.getPreferredSize().width, img1.getPreferredSize().height);
        header1.setBounds(125, 100, 450, 40);
        horizontal2.setBounds(0, -250, 1300, 800);
        
        //section1
        header2.setBounds(125,150,450,40);
        inprovider.setBounds(150, 200, 150, 20);
        enterinprovider.setBounds(150, 225, 150,20);
        membernum.setBounds(360, 200,150,20);
        entermembernum.setBounds(360,225,150,20);
        
        //section2
        horizontal1.setBounds(0, -100, 1300, 800);
        header3.setBounds(125,300,450,40 );
        
        header4.setBounds(125, 335, 450,40);
        header5.setBounds(700, 335, 450,40);
        reason1.setBounds(125, 385, 550, 100);
        reason2.setBounds(700, 385, 550, 100);
        submit.setBounds(1000, 655, submit.getPreferredSize().width, submit.getPreferredSize().height);
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
        mainPanel2.add(img1);
        mainPanel2.add(header1);
        mainPanel2.add(horizontal2);
        mainPanel2.add(header2);
        
        mainPanel2.add(horizontal1);
        mainPanel2.add(inprovider);
        mainPanel2.add(enterinprovider);
        
        mainPanel2.add(membernum);
        mainPanel2.add(entermembernum);
//        mainPanel2.add(prev);
//        mainPanel2.add(labs);
//        
//        mainPanel2.add(phone);
//        mainPanel2.add(zoom);
//        mainPanel2.add(inperson);
//        
//        mainPanel2.add(horizontal3);
        mainPanel2.add(header3);
//
        mainPanel2.add(header4);
        mainPanel2.add(header5);
        mainPanel2.add(reason1);
        mainPanel2.add(reason2);
        mainPanel2.add(submit);
      
        //add panels to JFrame
        patientHome.getContentPane().add(BorderLayout.NORTH, patientMenu);
        patientHome.getContentPane().add(BorderLayout.CENTER,mainPanel2);
        patientHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientHome.setResizable(false);
        patientHome.setVisible(true);
        
        mainPanel2.setBackground(Color.WHITE);
        
        //action to go to newAppointment2 page when button is clicked
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pre Appointment Completed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                PatientMenu pat = new PatientMenu();
                patientHome.dispose(); //close screen
            }
        });
        
    }
}
