package SystemVars;

import java.sql.Time;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilma
 */
public class status {
    public static String state ="report";
    public static Time CurrentTime;
    public static String CurrentID;
    public static String user;

    public static Time getCurrentTime() {
        return CurrentTime;
    }

    public static void setCurrentTime(Time CurrentTime) {
        status.CurrentTime = CurrentTime;
    }

    public static String getCurrentID() {
        return CurrentID;
    }

    public static void setCurrentID(String CurrentID) {
        status.CurrentID = CurrentID;
    }
    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        status.state = state;
    }
    
     public static void setUser(String state) {
        status.user = state;
    }
     
      public static String getUser() {
        return user;
    }
}
