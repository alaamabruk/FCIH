/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar
 */
public class DataConnection {

    
    
     public static Connection getconn() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/new_schema?user=root&password=3122");

        } catch (SQLException ex) {
           //Logger.getLogger(.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
     
     
     
     
     
     
    
    public boolean loginCheck(String username, String password){
        String query;
        String dbUsername, dbPassword;
        boolean login = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?user=root&password=admin");

            Statement stmt =  con.createStatement();
            query = "SELECT Name, Password FROM student;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                dbUsername = rs.getString("Name");
                dbPassword = rs.getString("Password");

                if(dbUsername.equals(username)  && dbPassword.equals(password) ){
                    //System.out.println("OK");
                    login = true;
                break;
                }
                //System.out.println(username + password + " " + dbUsername + dbPassword);
            }        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

//user,String pwd,String Specific,int level,int id
    public boolean Registerform(String user,String pwd,String Specific,int level,int id){
    boolean register=false;
  //  String query= "INSERT INTO student(Name, Password, Specific, Level,Id) VALUES ('"+user+"','"+pwd+"','"+Specific+"',"+level+","+id+")";
    String query= "INSERT INTO student VALUES ('"+user+"','"+pwd+"','"+Specific+"',"+level+","+id+")";     
    try { 
        
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new?user=root&password=admin");
        Statement stmt =  con.createStatement();
       // stmt.executeUpdate(query);
       con.prepareStatement("");
        stmt.executeUpdate(query);
        register= true;
       
        
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    
    return register;
    }
    


}

         