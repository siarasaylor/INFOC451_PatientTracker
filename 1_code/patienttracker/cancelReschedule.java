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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author siarasaylor
 */
class cancelReschedule {
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
    cancelReschedule() {
        crapointment();
    }
    static void crapointment() {
        System.out.println("Cancel/Reschedule Appointment");

        //set up items
        JLabel scheduleAppointment = new JLabel("Cancel/Reschedule Appointment");
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
        patientHome = new JFrame("Patient Tracker - Cancel/Reschedule Appointment");
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
        JLabel header1 = new JLabel("Cancel/Reschedule Appointment");
        JLabel header2 = new JLabel("Cancel Appointment");
        JLabel header3 = new JLabel("Please provide a reason for cancelling your appointment.");
        JLabel header4 = new JLabel("Reschedule");
        
        
        header1.setFont(new Font("Arial", Font.PLAIN, 30));
        header2.setFont(new Font("Arial", Font.BOLD, 24));
        header3.setFont(new Font("Arial", Font.PLAIN, 14));
        header4.setFont(new Font("Arial", Font.BOLD, 24));
        
        
        JTextArea reason = new JTextArea();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        reason.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        //kind of appointment buttons
        JButton cancel = new JButton("Cancel");
        JButton labs = new JButton("Labs");
        
        //Menu for type of appointment
        JButton phone = new JButton("Phone");
        JButton zoom = new JButton("Zoom");
        JButton inperson = new JButton("In Person");
        
        JButton nextBtn = new JButton("Next");
        JButton backBtn = new JButton("Back");
        
        //image logo
        JLabel img1 = new JLabel(new ImageIcon("logo3.jpg"));
        
        //horizontal line 
        MyLine horizontal1 = new MyLine();
        MyLine horizontal2 = new MyLine();
        MyLine horizontal3 = new MyLine();
        
        //combo box for Provider
        JLabel providers = new JLabel("Provider");
        providers.setFont(new Font("Arial", Font.BOLD, 14));
        String[] providerNames = {"Dr. Kathy Smith", "Dr. Christopher Jones", "Dr. Grant Ward"};
        JComboBox providerS = new JComboBox(providerNames);
        
        //combo box for Network
        JLabel network = new JLabel("Network");
        network.setFont(new Font("Arial", Font.BOLD, 14));
        String[] net = {"Anthem", "CareSource", "Celtic Insurance", "Ambetter"};
        JComboBox netWork = new JComboBox(net);
        
        //combo box for Location
        JLabel location = new JLabel("Location");
        location.setFont(new Font("Arial", Font.BOLD, 14));
        String[] loc = {"Indianapolis", "Washington Street", "Fishers", "Avon"};
        JComboBox locations = new JComboBox(loc);
        
        //table to show results from search
        String[] columnNames = {"Date/Time", "Doctor", "Location", "Schedule" };
        
        //example data will need to work on being able to populate from text file
        Object[][] data = {{"2/7/2021", "Smith", "Fishers", false},
        {"2/7/2021", "Doe", "Fishers", false},
        {"2/7/2021", "Black", "Fishers", false},
        {"2/7/2021", "White", "Fishers", false},
        {"2/7/2021", "Brown", "Fishers", false}
        };
        
        //calendar
        JLabel calendar = new JLabel("Pick a Date: ");
        calendar.setFont(new Font("Arial", Font.BOLD, 14));
        DateTextField cal = new DateTextField();
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBackground(Color.lightGray);

        
        
        
        //header
        img1.setBounds(10, 10, img1.getPreferredSize().width, img1.getPreferredSize().height);
        header1.setBounds(125, 100, 450, 40);
        horizontal2.setBounds(0, -250, 1300, 800);
        header2.setBounds(125,150,450,40);
       
        //section1
        horizontal1.setBounds(0, -100, 1300, 800);
        header3.setBounds(125,175,450,40 );
        reason.setBounds(125, 225, 650, 50);
        cancel.setBounds(800, 255, 80, 20);
        //section2
        horizontal3.setBounds(0, 100, 1300,800);
        header4.setBounds(125, 300, 450,40);
        providers.setBounds(150, 335, 80, 20);
        providerS.setBounds(150, 355, providerS.getPreferredSize().width, providerS.getPreferredSize().height);
        network.setBounds(360, 335, 80, 20);
        netWork.setBounds(360, 355, netWork.getPreferredSize().width, netWork.getPreferredSize().height);
        location.setBounds(550, 335, 80,20);
        locations.setBounds(550, 355, locations.getPreferredSize().width, locations.getPreferredSize().height);
        calendar.setBounds(150, 395, 100, 20);
        cal.setBounds(255, 395, cal.getPreferredSize().width, cal.getPreferredSize().height);
         scrollPane.setBounds(150, 495, 1000, 100);
        
        //section3
        
        nextBtn.setBounds(1000, 655, nextBtn.getPreferredSize().width, nextBtn.getPreferredSize().height);
        backBtn.setBounds(900, 655, nextBtn.getPreferredSize().width, nextBtn.getPreferredSize().height);
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
        mainPanel2.add(horizontal1);
        
        mainPanel2.add(horizontal2);
        mainPanel2.add(header2);

        mainPanel2.add(header3);
        mainPanel2.add(reason);
        mainPanel2.add(cancel);

        mainPanel2.add(header4);
        mainPanel2.add(providers);
        mainPanel2.add(providerS);
        
        mainPanel2.add(network);
        mainPanel2.add(netWork);
        
        mainPanel2.add(location);
        mainPanel2.add(locations);
        
        mainPanel2.add(scrollPane);
        mainPanel2.add(calendar);
        mainPanel2.add(cal);
        
        mainPanel2.add(nextBtn);
        mainPanel2.add(backBtn);
      
        //add panels to JFrame
        patientHome.getContentPane().add(BorderLayout.NORTH, patientMenu);
        patientHome.getContentPane().add(BorderLayout.CENTER,mainPanel2);
        patientHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientHome.setResizable(false);
        patientHome.setVisible(true);
        
        mainPanel2.setBackground(Color.WHITE);
        
        //action to go to newAppointment2 page when button is clicked
        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Review newApp = new Review();
                patientHome.dispose(); //close screen
            }
        });
        //action to go to newAppointment page when button is clicked
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScheduleAppointment sch = new ScheduleAppointment();
                patientHome.dispose(); //close screen
            }
        });
        
        //action to go to newAppointment2 page when button is clicked
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "Appointment Cancelled.", "Success", JOptionPane.INFORMATION_MESSAGE);
                PatientMenu pat = new PatientMenu();
                patientHome.dispose(); //close screen
            }
        });
    }
}
