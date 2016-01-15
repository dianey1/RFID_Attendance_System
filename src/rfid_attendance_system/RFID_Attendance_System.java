/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfid_attendance_system;

import Registration.RegistrationInterface;
import SystemUsers.Login1;

/**
 *
 * @author Wilma
 */
public class RFID_Attendance_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Create and show the main interface
        //MainInterface mainInterface = new MainInterface();
        Login1 login = new Login1();
        login.show();
        //mainInterface.show();
        
    }
    
}
