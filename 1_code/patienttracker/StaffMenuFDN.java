/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patienttracker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author siarasaylor
 */
class StaffMenuFDN extends loginWindow{

    

    StaffMenuFDN() {
        menuStaff();
    }
    static JFrame staffHome;
    static JPanel mainPanel;
    static JMenuBar fdstaffMenu;
    static JMenuBar nstaffMenu;
    static JMenuBar dstaffMenu;
    static JMenuItem calendar;
    static JMenuItem patientSearch;
    static JMenuItem presApprovals;
    static JMenuItem homeButton;
    static JMenu staffexit;
    static JMenuItem logout;
    static JMenuItem exit;

    public static void menuStaff() {
       if (userInput.matches("[0-9]+") && userInput.length() > 2) {
            if (userInput.startsWith("1") && userInput.length() > 2) {
                
                doctorMenu();

            }
            if (userInput.startsWith("2") && userInput.length() > 2) {
                nurseMenu();

            }
            if (userInput.startsWith("3") && userInput.length() > 2) {
                frontDeskMenu();

            }

        }
    }

    public static void doctorMenu() {
        System.out.println("Doctor View");

        dstaffMenu = new JMenuBar();

        homeButton = new JMenuItem("Home");
        calendar = new JMenuItem("Calendar");
        patientSearch = new JMenuItem("Patient Search");
        presApprovals = new JMenuItem("Prescription Approvals");

        staffexit = new JMenu("Exit");
        logout = new JMenuItem("Log Out");
        exit = new JMenuItem("Exit");

        dstaffMenu.setPreferredSize(new Dimension(dstaffMenu.getPreferredSize().width, 30));

        //action to go to the staff main page when button is clicked
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorHome dstaff = new DoctorHome();
                    frame.dispose();
                    
            }
        });
        //action to go to calendar page when button is clicked
        calendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                staffHome.dispose();
                frame.dispose();
            }
        });
        //action to go to the Patient Search Page when button is clicked
        patientSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientSearch searchP = new PatientSearch();
                frame.dispose();
                staffHome.dispose();
            }
        });

        //action to go to the prescriptionApprovals page when button is clicked
        presApprovals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prescriptionApprovals pApprovals = new prescriptionApprovals();
                staffHome.dispose();
            }
        });

        //action to close when button is clicked
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffHome.dispose();
                System.exit(0);
            }
        });
        //action to close when button is clicked
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginWindow login = new loginWindow();
                staffHome.dispose();
                //System.exit(0);
            }
        });

        //add items to menu
        staffexit.add(logout);
        staffexit.add(exit);
        dstaffMenu.add(homeButton);
        dstaffMenu.add(calendar);
        dstaffMenu.add(patientSearch);
        dstaffMenu.add(presApprovals);
        dstaffMenu.add(staffexit);

        
    }

    public static void nurseMenu() {
        System.out.println("Nurse View");

        nstaffMenu = new JMenuBar();
        homeButton = new JMenuItem("Home");
        calendar = new JMenuItem("Calendar");
        patientSearch = new JMenuItem("Patient Search");
        presApprovals = new JMenuItem("Prescription Approvals");

        staffexit = new JMenu("Exit");
        logout = new JMenuItem("Log Out");
        exit = new JMenuItem("Exit");

        nstaffMenu.setPreferredSize(new Dimension(nstaffMenu.getPreferredSize().width, 30));
        //action to go to the staff main page when button is clicked
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NurseHome nstaff = new NurseHome();
                frame.dispose();
            }
        });

        //action to go to calendar page when button is clicked
        calendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                staffHome.dispose();
            }
        });
        //action to go to the Patient Search Page when button is clicked
        patientSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientSearch searchP = new PatientSearch();
                staffHome.dispose();
            }
        });

        //action to go to the prescriptionApprovals page when button is clicked
        presApprovals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prescriptionApprovals pApprovals = new prescriptionApprovals();
                staffHome.dispose();
                
            }
        });

        //action to close when button is clicked
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffHome.dispose();
                System.exit(0);
            }
        });
        //action to close when button is clicked
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginWindow login = new loginWindow();
                staffHome.dispose();
                //System.exit(0);
            }
        });

        //add items to menu
        staffexit.add(logout);
        staffexit.add(exit);
        nstaffMenu.add(homeButton);
        nstaffMenu.add(calendar);
        nstaffMenu.add(patientSearch);
        nstaffMenu.add(presApprovals);
        nstaffMenu.add(staffexit);

        
    }

    public static void frontDeskMenu() {
        System.out.println("Front Desk View");

        fdstaffMenu = new JMenuBar();

        homeButton = new JMenuItem("Home");
        calendar = new JMenuItem("Calendar");
        patientSearch = new JMenuItem("Patient Search");

        staffexit = new JMenu("Exit");
        logout = new JMenuItem("Log Out");
        exit = new JMenuItem("Exit");

        fdstaffMenu.setPreferredSize(new Dimension(fdstaffMenu.getPreferredSize().width, 30));
        //action to go to the staff main page when button is clicked
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FDHome fdstaff = new FDHome();
                frame.dispose();
            }
        });

        //action to go to calendar page when button is clicked
        calendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame();
                staffHome.dispose();
            }
        });
        //action to go to the Patient Search Page when button is clicked
        patientSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientSearch searchP = new PatientSearch();
                staffHome.dispose();
            }
        });
        //action to close when button is clicked
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                staffHome.dispose();
                System.exit(0);
            }
        });
        //action to close when button is clicked
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginWindow login = new loginWindow();
                staffHome.dispose();
                //System.exit(0);
            }
        });

        //add items to menu
        staffexit.add(logout);
        staffexit.add(exit);

        fdstaffMenu.add(homeButton);
        fdstaffMenu.add(calendar);
        fdstaffMenu.add(patientSearch);
        fdstaffMenu.add(staffexit);

        
    }
}
