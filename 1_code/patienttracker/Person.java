/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patienttracker;

import javax.swing.JFrame;

/**
 *
 * @author siarasaylor
 */
class Person {

    public static JFrame frame;

    public String username;
    public String password;
    protected String firstName;
    protected String lastName;

    Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /* getters and setters */
    public String getusername() {
        return username;
    }

    public void setusername(String userName) {
        this.username = userName;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String passWord) {
        this.password = passWord;
    }

    public String getfName() {
        return firstName;
    }

    public void setfName(String fname) {
        this.firstName = fname;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lname) {
        this.lastName = lname;
    }

    //will need to add all information on the person
    public static void personView(String username, String password) {
        boolean found = false;

        if (username.matches("[0-9]+") && username.length() > 2) {
            if (username.startsWith("1") && username.length() > 2) {
                found = true;
                DoctorHome dstaff = new DoctorHome();
                frame.dispose();

            }
            if (username.startsWith("2") && username.length() > 2) {
                found = true;
                NurseHome nstaff = new NurseHome();
                frame.dispose();

            }
            if (username.startsWith("3") && username.length() > 2) {
                found = true;
                FDHome fdstaff = new FDHome();
                frame.dispose();

            } else {
                found = true;
                PatientMenu menu = new PatientMenu();
                frame.dispose();
            }

        }
    }
}
