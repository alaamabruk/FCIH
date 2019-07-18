/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Beans.Admin;
import Beans.Course;
import Beans.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar
 */
public class Admin_Operation {
    
    
    private Connection conn;
    public Admin_Operation()  {
    
        try {
            conn = DataConnection.getconn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    


 public List getallStudent() {
        List ldata = new ArrayList();
        try {
            String sql = "select * from student ";
            PreparedStatement pre = conn.prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
            Student std=new Student();
            
            
            std.setId(rs.getInt(1));
            std.setPassword(rs.getString(2));
            std.setName(rs.getString(3));
            std.setSpecific(rs.getString(4));
            std.setLevel(rs.getInt(5));
            ldata.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ldata;
    }
   
  public boolean checkAdmin(String name, String pwd){
     String dbAdmin,dbPassword;
      boolean login=false;
      try {
            String sql = "select Name,Password from admin where Password=? and Name=? ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, pwd);
            pre.setString(2, name);
            ResultSet rs = pre.executeQuery();
           
            while(rs.next()){
                dbAdmin = rs.getString("Name");
                dbPassword = rs.getString("Password");

                if(dbAdmin.equals(name)  && dbPassword.equals(pwd) ){
                    //System.out.println("OK");
                    login = true;
                break;
                }
           return login;
        }
      } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return login;
     }

  public Admin retriveAdmin(String name, String pwd ){
       Admin a =new Admin();
       // String sql = "select *from student where Name='"+name+"' and Password ='"+pwd+"' ";
      try {
            String sql = "select * from admin  where Name =?  and Password=? ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, name);
            pre.setString(2, pwd);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
           
            a.setId(rs.getInt(1));
            a.setName(rs.getString(2));
           // a.setPassword(rs.getString(3));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
     return a;
     }
     
  public boolean adminRegCourse(String id,String name){
     try {
            String sql = "insert into Course values (?,?) ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, id);
            pre.setString(2, name);
            
            pre.executeUpdate();
           return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
       return false;
        }
    }
  
  
  public List retriveCourse(){
        List colist = new ArrayList();
      try {
      String sql = "select Id ,Name from Course ";
            PreparedStatement pre = conn.prepareCall(sql);
           ResultSet rs =  pre.executeQuery();
            while(rs.next()){
           Course corse = new Course();
            corse.setId(rs.getString(1));
            corse.setName(rs.getString(2));
            colist.add(corse);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
      
        }
   return colist;
  }

  public boolean adminDeleteCourse(String name){
  
      String sql ="delete from course where Name = ?";
  
      PreparedStatement pre;
        try {
            pre = conn.prepareCall(sql);
            pre.setString(1, name);
            pre.executeUpdate();
           return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
     return false;
  
  }
  
  public boolean delCourse(int id){
  

  try {
            String sql = "delete from registercourse where  Id = ?";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
           return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
       return false;
        }
  }
public boolean DelStudentAdmin(int id){
      
   
  try {
            String sql = "delete from student where  Id = ?";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
           return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
       return false;
        }
  }
    
    
  public Student ShowStudent(int id){
       Student es =new Student();

      try {
            String sql = "select * from student where Id=? ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setInt(1, id);
            
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
           
            es.setId(rs.getInt(1));
            es.setPassword(rs.getString(2));
            es.setName(rs.getString(3));
            es.setSpecific(rs.getString(4));
            es.setLevel(rs.getInt(5));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
     return es;
     }

public boolean AdminUpdateStudentInfo(Student std,int oldID){

String sql ="update student set Id=? ,Dept=? Level=?, Gpa=? where Id=?";
  
        try {
             PreparedStatement pre= conn.prepareCall(sql);
             pre.setInt(1, std.getId());
             pre.setString(2, std.getSpecific());
             pre.setInt(3, std.getLevel());
             pre.setFloat(4, std.getGpa());
             pre.setInt(5, oldID);
             pre.executeUpdate();
       return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
  return false;
  }



}


