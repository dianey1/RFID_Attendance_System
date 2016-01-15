/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportGeneration;

import Registration.*;
import SystemVars.status;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wilma
 */
//This class is going to be working on 3 database tables: Attendance Record, Registered Personel
// and Registered_Personel_has_Attendance_Record
public class RecordAttendance {

    public RecordAttendance() {
        checkID();
        //status.setState("report");
        if (verify_ID){
        if (status.getCurrentID() != SerialTest.getResult() || status.getCurrentTime() != Time.valueOf(LocalTime.now())) {
            record();
        }
        }

    }
    
    public boolean checkID(){
         verify_ID = false;
            DataBase verifyID = DataBase.getInstance();
            verifyID.connect();
            verifyID.query("Select Tag_ID from `Registered Personel`");
            ResultSet tagID = verifyID.getResultSet();
           
        
        try {
            while(tagID.next()){
                 System.out.println("Checking to Record  Tag");
                if (tagID.getString("Tag_ID").equals(SerialTest.getResult())){
                    //RecordAttendance attend = new RecordAttendance();
                    verify_ID = true;
                    System.out.println("Checking to Record  Tag loop");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationInterface.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return verify_ID;
        
    }
    
    boolean verify_ID;
    Date presentDate;
    Time presentTime;
    String depName, facName;
    
    public void record() {
        String id = SerialTest.getResult();
        Calendar dat = Calendar.getInstance();

        while (id != null) {

            System.out.println("The dte is" + Date.valueOf(LocalDate.now()));
            presentDate = Date.valueOf(LocalDate.now());
            presentTime = Time.valueOf(LocalTime.now());
            //Date.valueOf(LocalDate.now());
            
            DataBase recordAttend = DataBase.getInstance();
            recordAttend.connect();
            
            try {
                //        recordAttend.query("select Departments_Name from `Registered Personel` where Tag_ID='" +SerialTest.getResult()+"'");
//        ResultSet DeptName = recordAttend.getResultSet();
//        
//            try {
//                while(DeptName.next())
//                {
//                    depName = DeptName.getString(1);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(RecordAttendance.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//        recordAttend.query("select Departments_Faculties_Name from `Registered Personel` where Tag_ID='" +SerialTest.getResult()+"'");
//        ResultSet FactName = recordAttend.getResultSet();
//        
//         try {
//                while(FactName.enext())
//                {
//                    facName = FactName.getString(1);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(RecordAttendance.class.getName()).log(Level.SEVERE, null, ex);
//            }
                //System.out.println(SerialTest.getResult());
                //String query="insert into `attendance record` (Date, Time, `Registered Personel_Tag_ID`) values ('" +presentDate + "','" +presentTime+ "','" +SerialTest.getResult()+"')";
                DataBase.statement.execute("insert into `attendance record` (Date, Time, `Registered Personel_Tag_ID`) values ('" +presentDate + "','" +presentTime+ "','" +SerialTest.getResult()+"')");
            } catch (SQLException ex) {
                Logger.getLogger(RecordAttendance.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(query);
        id=null;
           
            
        }
    }

    public static void main(String[] args) {
        RecordAttendance test = new RecordAttendance();
    }

}
