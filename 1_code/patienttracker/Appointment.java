/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patienttracker;

import java.util.Date;

/**
 *
 * @author siarasaylor
 */
class Appointments{
    String provider;
    String network;
    String location;
    Date date;
    String selected; //check box... could be a different data type
    String kind;
    String type;
    String details;
    Integer appointmentID;
    String patientfname;
    String patientlname;
    String patientUName;
    
    Appointments(Integer appointmentid, String pusername, String fname, String lname, String provider, 
            String network, String location, Date date, String selected, String kind, String type, String details) {
        
        this.appointmentID = appointmentid;
        this.patientUName = pusername;
        this.patientfname = fname;
        this.patientlname = lname;
        this.provider = provider;
        this.network = network;
        this.location = location;
        this.date = date;
        this.selected = selected;
        this.kind = kind;
        this.type = type;
        this.details = details;
        
    }
    public void printAppointments(Appointments appointment) {
        System.out.println(appointment);
    }
    /* getters and setters */
    public String getusername() {
        return patientUName;
    }

    public void setusername(String userName) {
        this.patientUName = userName;
    }

    public Integer getappointmentID() {
        return appointmentID;
    }

    public void setpassword(Integer apptID) {
        this.appointmentID = apptID;
    }

    public String getfName() {
        return patientfname;
    }

    public void setfName(String fname) {
        this.patientfname = fname;
    }

    public String getlastName() {
        return patientlname;
    }

    public void setlastName(String lname) {
        this.patientlname = lname;
    }
    public String getkind() {
        return patientlname;
    }

    public void setkind(String knd) {
        this.kind = knd;
    }
    public String gettype() {
        return type;
    }

    public void settype(String tp) {
        this.type = tp;
    }
    public String getdetails() {
        return details;
    }

    public void setdetails(String dets) {
        this.details = dets;
    }
    
    public String getprovider() {
        return provider;
    }

    public void setprovider(String prvdr) {
        this.provider = prvdr;
    }
    public String getnetworkd() {
        return network;
    }

    public void setnetwork(String ntwk) {
        this.network = ntwk;
    }
    public String getlocation() {
        return location;
    }

    public void setlocation(String loc) {
        this.location = loc;
    }
    public Date getdate() {
        return date;
    }

    public void setdate(Date dt) {
        this.date = dt;
    }
    public String getselected() {
        return selected;
    }

    public void setselected(String st) {
        this.selected = st;
    }
}
