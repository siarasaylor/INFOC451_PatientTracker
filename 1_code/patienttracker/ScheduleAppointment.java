/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patienttracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static patienttracker.ScheduleAppointment.patientHome;

/**
 *
 * @author siarasaylor
 */
//-----------------------------------
class ScheduleAppointment extends PatientMenu {

    ScheduleAppointment() {
        schedAppt();
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
    static JTable table2;
    static DefaultTableModel dm2;
    static JTable table;
    static DefaultTableModel dm;

    public static void schedAppt() {
        System.out.println("Schedule Appointment");

        //set up items
        JLabel scheduleAppointment = new JLabel("Schedule Appointment");
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
        patientHome = new JFrame("Patient Tracker - Schedule Appointment");
        patientHome.setSize(1300, 800);
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
        JLabel header1 = new JLabel("Appointments");
        JLabel header2 = new JLabel("Upcoming Appointments");
        JLabel header3 = new JLabel("Previous Appointments");

        header1.setFont(new Font("Arial", Font.PLAIN, 30));
        header2.setFont(new Font("Arial", Font.PLAIN, 24));
        header3.setFont(new Font("Arial", Font.PLAIN, 24));

        JButton newAppointment = new JButton("Schedule New Appointment");

        //image logo
        JLabel img1 = new JLabel(new ImageIcon("logo3.jpg"));

        //horizontal line
        MyLine horizontal1 = new MyLine();
        MyLine horizontal2 = new MyLine();
        MyLine horizontal3 = new MyLine();

        //pull information from text file and populate
        try {
            BufferedReader br = new BufferedReader(new FileReader("appointments.txt"));
            Scanner s = new Scanner(new File("appointments.txt"));

            String line = "";

            Object[][] data = {};
            String[] columnNames = {"Date", "Time", "Doctor", "Location", "PreAppointment", "Cancel/Reschedule"};
            dm2 = new DefaultTableModel(data, columnNames);
            table2 = new JTable(dm2);
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table2.getModel());
                sorter.setComparator(0, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                sorter.setSortsOnUpdates(true);
                List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                table2.setRowSorter(sorter);
            Object[][] data2 = {};
            String[] columnNames1 = {"Date", "Time", "Doctor", "Location", "View Details"};
            dm = new DefaultTableModel(data2, columnNames1);
            table = new JTable(dm);
            TableRowSorter<TableModel> sorter2 = new TableRowSorter<>(table.getModel());
                sorter2.setComparator(0, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                sorter2.setSortsOnUpdates(true);
                List<RowSorter.SortKey> sortKeys2 = new ArrayList<RowSorter.SortKey>();
                sortKeys2.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                sorter2.setSortKeys(sortKeys2);
                table.setRowSorter(sorter2);
            while ((line = br.readLine()) != null) {

                String in = s.nextLine();
                String[] sArray = in.split(",");
                String day = sArray[5].toString();
                SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                Date date = parser.parse(day);
                Date todayDate = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = formatter.format(date);
                String formattedDate1 = formatter.format(todayDate);
                
                for (String word : sArray) {
                    if (word.equals(userInput)) {

                        //for (int x = 0; x < count; ++x) {
                        System.out.println(formattedDate);
                        System.out.println(todayDate);
                        int result = formattedDate.compareTo(formattedDate1);
                        System.out.println("result: " + result);

                        if (result == 0) {
                            dm2.addRow(new Object[]{formattedDate,  sArray[6].toString() + "-" + sArray[7].toString(),
                                sArray[8].toString(),
                                sArray[9].toString() + " / " + sArray[11].toString(),
                                "PreAppointment",
                                "Cancel/Reschedule"});

                        } else if (result > 0) {
                            dm2.addRow(new Object[]{formattedDate, sArray[6].toString() + "-" + sArray[7].toString(),
                                sArray[8].toString(),
                                sArray[9].toString() + " / " + sArray[11].toString(),
                                "PreAppointment",
                                "Cancel/Reschedule"});

                        } else if (result < 0) {
                            dm.addRow(new Object[]{formattedDate, sArray[6].toString() + "-" + sArray[7].toString(),
                                sArray[8].toString(),
                                sArray[9].toString() + " / " + sArray[11].toString(),
                                "Details"});

                        }
                        
                        //}
                    }

                }
            }

        } catch (FileNotFoundException d) {
            JOptionPane.showMessageDialog(null, "User Database Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleAppointment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException exx) {
            // TODO Auto-generated catch block
            exx.printStackTrace();
        }

        table2.getColumn("PreAppointment").setCellRenderer(new ButtonRenderer());
        table2.getColumn("PreAppointment").setCellEditor(new ButtonEditor(new JCheckBox()));
        table2.getColumn("Cancel/Reschedule").setCellRenderer(new ButtonRenderer());
        table2.getColumn("Cancel/Reschedule").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scroll2 = new JScrollPane(table2);

        table2.setPreferredScrollableViewportSize(table2.getPreferredSize());//thanks mKorbel +1 http://stackoverflow.com/questions/10551995/how-to-set-jscrollpane-layout-to-be-the-same-as-jtable

        table2.getColumnModel().getColumn(0).setPreferredWidth(100);

        table.getColumn("View Details").setCellRenderer(new ButtonRenderer());
        table.getColumn("View Details").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scroll = new JScrollPane(table);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());//thanks mKorbel +1 http://stackoverflow.com/questions/10551995/how-to-set-jscrollpane-layout-to-be-the-same-as-jtable

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        //header
        img1.setBounds(10, 10, img1.getPreferredSize().width, img1.getPreferredSize().height);
        header1.setBounds(125, 100, 450, 40);
        horizontal2.setBounds(0, -250, 1300, 800);

        //Section1
        newAppointment.setBounds(150, 185, newAppointment.getPreferredSize().width, newAppointment.getPreferredSize().height);

        //section2
        horizontal1.setBounds(0, -150, 1300, 800);
        header2.setBounds(125, 250, 450, 40);
        scroll2.setBounds(150, 290, 1000, 100);

        //section3
        horizontal3.setBounds(0, 5, 1300, 800);
        header3.setBounds(125, 405, 450, 40);
        scroll.setBounds(150, 445, 1000, 100);

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

        mainPanel2.add(newAppointment);

        mainPanel2.add(horizontal2);
        mainPanel2.add(header2);
        mainPanel2.add(scroll2);

        mainPanel2.add(horizontal3);
        mainPanel2.add(header3);
        mainPanel2.add(scroll);

//add panels to JFrame
        patientHome.getContentPane().add(BorderLayout.NORTH, patientMenu);
        patientHome.getContentPane().add(BorderLayout.CENTER, mainPanel2);
        patientHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientHome.setResizable(false);
        patientHome.setVisible(true);

        mainPanel2.setBackground(Color.WHITE);

        //action to go to new appointment page when button is clicked
        newAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewAppointment newApp = new NewAppointment();
                patientHome.dispose(); //close screen
            }
        });

    }
}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton details;
    protected JButton preAppt;
    protected JButton canresch;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        details = new JButton();
        details.setOpaque(true);
        details.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            details.setForeground(table.getSelectionForeground());
            details.setBackground(table.getSelectionBackground());
        } else {
            details.setForeground(table.getForeground());
            details.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        details.setText(label);
        isPushed = true;
        return details;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            if (label.equals("Details")) {
                prevAppointment prevApp = new prevAppointment();
                patientHome.dispose(); //close screen
            }
            if (label.equals("PreAppointment")) {
                preAppt preappt = new preAppt();
                patientHome.dispose(); //close screen
            }
            if (label.equals("Cancel/Reschedule")) {
                cancelReschedule canres = new cancelReschedule();
                patientHome.dispose(); //close screen
            }
            if (label.equals("Patient Information")) {
                JOptionPane.showMessageDialog(null, "Patient Information Page", "Success", JOptionPane.INFORMATION_MESSAGE);
                cancelReschedule patInf = new cancelReschedule();
                patientHome.dispose(); //close screen
            }

        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
