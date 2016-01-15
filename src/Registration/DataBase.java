/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rfid_attendance_system.AddFaculty;


/**
 *
 * @author Yanick
 */
public class DataBase {
    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/rfid_db_";
    static final String user = "root";
    static final String passWord = "wilma";
    
    private boolean loggedIn = false;
    
    ResultSet resultSet;
    Connection connection = null; // manages connection
    public static Statement statement = null; // query statement
    

    private DataBase(){
        connect();
    
    }

    /**
     * Connects to the database used for time table creation
     * Returns true on successful connection, and false on failure.
     * @return 
     */
    public boolean connect() {
          // connect to database time_table_db
        try {

        //Class.forName returns the Class object associated with 
        //the class or interface with the given string name
        Class.forName(JDBC_DRIVER); //load database driver class

        //Declare and initialize a Connection reference called connection
        connection = DriverManager.getConnection(DATABASE_URL, user, passWord);

        // create Statement for querying database
        //invokes Connection method createStatement to obtain an object 
        //that implements interface Statement
        statement = connection.createStatement();
        
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();                        
            
           if(sqlException.getErrorCode() == 1045  ){
               
               JOptionPane.showMessageDialog(null, "Wrong Username or Password","Loggin Error" , JOptionPane.ERROR_MESSAGE);                 
           }
             return false;                           
            }
        //ClassNotFoundExceptionis thrown if the class loader cannot locate the driver class
        catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
            return false;
            }       
        loggedIn = true;
        return true;
    }
    
    /**
     * Returns an instance of the database object.
     * @return 
     */
    public static DataBase getInstance() {
        return DataHolder.INSTANCE;
    }
    
    /**
     * Constructor for the database object.
     */
    private static class DataHolder {

        private static final DataBase INSTANCE = new DataBase();
    }
    
    
    /**
     * Executes the given query.
     * The result is put in a result, which can be gotten by 
     * calling the "getResultSet" method on the given database 
     * instance.
     * @param query 
     */
    public void query(String query)    {
    
    try{
    
    resultSet = statement.executeQuery(query);                
    
    }catch (SQLException sqlException) {
            sqlException.printStackTrace();            
            }    
    catch (Exception exception) {
    exception.printStackTrace();    
    }    
    }
    
    
    public void execute(String query)    {
    
    try{
    
    statement.execute(query);                
    
    }catch (SQLException sqlException) {
            sqlException.printStackTrace();            
            }    
    catch (Exception exception) {
    exception.printStackTrace();    
    }    
    }
    
    
    
    
    /**
     * Returns the resultset gotten from the last execution of query.
     * @return 
     */
    public ResultSet getResultSet(){
        return this.resultSet;
    }

    /**
 * Closes the connection to the database
 */
    private void closeConnection(){
    
    // ensure statement and connection are closed properly
        try {
            //Close the Statement & database Connection.
            //statement.close(); //the 
            connection.close();
    }
    catch (Exception exception) {
    exception.printStackTrace();
    
    }
    
}

    /**
 * Returns the state of the database connection. True for connected, false for
 * not connected.
 * @return 
 */
    public boolean getDatabaseConnectionState(){
    return this.loggedIn;
    }    

    /**
     * Returns true if the given teacher is free on the given 
     * day and slot. Returns false if the teacher is not free.
     * @param day
     * @param slot
     * @param teacherId
     * @return 
     */
    public boolean isTeacherFree(int day, int slot, int teacherId){
        
        Integer hold = 4;
        String queryString = "select count(*) from time_table t where t.day = '"+day+"' and t.slot = '"+slot+"' and t.teacher_id = '"+teacherId+"'";                        
                
        try{
        this.resultSet.next(); //Result set has only one elemen. =>
                               // there is no need to loop.
            
          hold = new Integer(this.resultSet.getString(1));                            
           
        }catch(SQLException e){
            e.printStackTrace();
        }    
        
        if(hold.intValue() == 0) return true;
        else return false;
    }

    /**
     * Returns true if the given course is free on the given day and 
     * period. Returns false otherwise.
     * @param day
     * @param slot
     * @param courseCode
     * @return 
     */
    public boolean isCourseFree(int day, int slot, String courseCode){
        return false;
    }
    
    /**
     * Returns true if the given lecture room is free on the given
     * day and period.
     * @param day
     * @param slot
     * @param lectureRoomId
     * @return 
     */
    public boolean isLectureRoomFree(int day, int slot, int lectureRoomId){
    return false;
    }
    
    /**
     * Returns true if there is a lecture room that can host the given 
     * course on the given day and time.
     * @param day
     * @param slot
     * @param courseSize
     * @return 
     */
    public boolean thereExistsFreeUsableLectureRomm(int day, int slot, int courseSize){
        
        return true;
    }
    
    /**
     * Queries the database and returns the size of the given course.
     * @param courseCode
     * @return 
     */
    public int getCourseSize(String courseCode){
        return 0;
    }
}
