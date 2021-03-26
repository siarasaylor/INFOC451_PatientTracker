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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import static patienttracker.NewAppointment2.patientMenu;

/**
 *
 * @author siarasaylor
 */
class prevAppointment {
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
    prevAppointment() {
        paapointment();
    }
    static void paapointment() {
        System.out.println("Previous Appointment");

        //set up items
        JLabel scheduleAppointment = new JLabel("Previous Appointment");
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
        patientHome = new JFrame("Patient Tracker - Previous Appointment");
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
        JLabel header1 = new JLabel("Previous Appointment");
        header1.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel header2 = new JLabel("Date/Time");
        header2.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel header3 = new JLabel("Provider");
        header3.setFont(new Font("Arial", Font.BOLD, 14));
        
        //labels
        JLabel weight = new JLabel("Weight");
        JLabel height = new JLabel("Height");
        JLabel bmi = new JLabel("BMI");
        JLabel bp = new JLabel("Blood Pressure");
        JLabel cholesterol = new JLabel("Cholesterol");
        JLabel waistSize = new JLabel("Waist Size");
        JLabel addnotes = new JLabel("Additional Notes");
        JLabel medications = new JLabel("Medications Prescribed");
        
        //text boxes to be auto filled
        JTextField wht = new JTextField();
        JTextField ht = new JTextField();
        JTextField bMI = new JTextField();
        JTextField bloodP = new JTextField();
        JTextField chol = new JTextField();
        JTextField wSize = new JTextField();
       
        //notes left from doctor/nurse
        JTextArea notes = new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        notes.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        

        

        JButton backBtn = new JButton("Back");
        
        //image logo
        JLabel img1 = new JLabel(new ImageIcon("logo3.jpg"));
        
        //horizontal line 
        MyLine horizontal2 = new MyLine();
        
        //medication table
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][]{{"IBProfin", "Back Pain","Take once a day with food", "10 days", "No", "Smith"},
        {"Advil", "Back Pain","Take once a day with food", "14 days", "Yes - 2", "Jones"},}, 
                new Object[]{"Name", "Purpose", "Directions", "Duration", "Refills", "Doctor"});

        JTable table = new JTable(dm);

        JScrollPane scroll = new JScrollPane(table);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());//thanks mKorbel +1 http://stackoverflow.com/questions/10551995/how-to-set-jscrollpane-layout-to-be-the-same-as-jtable

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        
        
        //header
        img1.setBounds(10, 10, img1.getPreferredSize().width, img1.getPreferredSize().height);
        header1.setBounds(125, 100, 450, 40);
        horizontal2.setBounds(0, -250, 1300, 800);
       
        //section1
        header2.setBounds(150, 175, 150, 20);
        header3.setBounds(150, 200, 150, 20);
        
        weight.setBounds(150, 250, 150, 20);
        wht.setBounds(150, 275, 150, 20);
        
        height.setBounds(150, 300, 150, 20);
        ht.setBounds(150, 325, 150, 20);
        
        bmi.setBounds(150, 350, 150, 20);
        bMI.setBounds(150, 375, 150, 20);
        
        bp.setBounds(150, 400, 150, 20);
        bloodP.setBounds(150, 425, 150, 20);
        
        cholesterol.setBounds(150, 450, 150, 20);
        chol.setBounds(150, 475, 150, 20);
       
        waistSize.setBounds(150, 500, 150, 20);
        wSize.setBounds(150, 525, 150, 20);
        
        addnotes.setBounds(530, 250, 150, 20);
        notes.setBounds(530, 275, 550, 150);
        
        medications.setBounds(530, 450, 150, 20);
        scroll.setBounds(530, 475, 550, 150);
        backBtn.setBounds(1000, 655, backBtn.getPreferredSize().width, backBtn.getPreferredSize().height);

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
        mainPanel2.add(header3);

        mainPanel2.add(weight);
        mainPanel2.add(wht);
        
        mainPanel2.add(height);
        mainPanel2.add(ht);
        
        mainPanel2.add(bmi);
        mainPanel2.add(bMI);
        
        mainPanel2.add(bp);
        mainPanel2.add(bloodP);
        
        mainPanel2.add(cholesterol);
        mainPanel2.add(chol);
        
        mainPanel2.add(waistSize);
        mainPanel2.add(wSize);
        
        mainPanel2.add(addnotes);
        mainPanel2.add(notes);
        
        mainPanel2.add(medications);
        mainPanel2.add(scroll);

        mainPanel2.add(backBtn);
      
        //add panels to JFrame
        patientHome.getContentPane().add(BorderLayout.NORTH, patientMenu);
        patientHome.getContentPane().add(BorderLayout.CENTER,mainPanel2);
        patientHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientHome.setResizable(false);
        patientHome.setVisible(true);
        
        mainPanel2.setBackground(Color.WHITE);
        

        //action to go to newAppointment page when button is clicked
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScheduleAppointment sch = new ScheduleAppointment();
                patientHome.dispose(); //close screen
            }
        });
    }
}
