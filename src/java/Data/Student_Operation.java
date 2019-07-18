/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Beans.Admin;
import Beans.Course;
import Beans.Student;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.connector.Request;

/**
 *
 * @author Oscar
 */
public class Student_Operation {

    private Connection conn;
    public Student_Operation()  {
    
        try {
            conn = DataConnection.getconn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public  boolean registerStudent(Student e) {

        try {
            String sql = "insert into student values (?,?,?,?,?,?)";
            PreparedStatement pre = conn.prepareCall(sql);
          
            pre.setInt(1, e.getId());
            pre.setString(2, e.getPassword());
            pre.setString(3, e.getName());
            pre.setString(4, e.getSpecific());
            pre.setInt(5, e.getLevel());
            pre.setFloat(6, e.getGpa());
            
            pre.executeUpdate();
           return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
       return false;
        }

    }
     
  public boolean checkLogin(String name, String pwd){
     String dbUsername,dbPassword;
      boolean login=false;
      try {
            String sql = "select Name,Password from student where Password=? and Name=? ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, pwd);
            pre.setString(2, name);
            ResultSet rs = pre.executeQuery();
           
            while(rs.next()){
                dbUsername = rs.getString("Name");
                dbPassword = rs.getString("Password");

                if(dbUsername.equals(name)  && dbPassword.equals(pwd) ){
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
    

    
     public Student retriveStudent(String name, String pwd ){
       Student e =new Student();
       // String sql = "select *from student where Name='"+name+"' and Password ='"+pwd+"' ";
      try {
            String sql = "select * from student where Name =?  and Password=? ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, name);
            pre.setString(2, pwd);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
           
            e.setId(rs.getInt(1));
            e.setPassword(rs.getString(2));
            e.setName(rs.getString(3));
            e.setSpecific(rs.getString(4));
            e.setLevel(rs.getInt(5));
            e.setGpa(rs.getFloat(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
     return e;
     }
     
    public boolean RegCourse(int num,int id ,String name){
     try {
            String sql = "insert into registerCourse values (?,?,?) ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setInt(1, num);
            pre.setInt(2, id);
            pre.setString(3, name);
            
            pre.executeUpdate();
           return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
       return false;
        }
    }
    
    public List<Course> ShowCourse(int id ){
      List<Course> allCourse = new ArrayList();
        try {
            
            String sql = "select Name from registerCourse where Id = ? ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setInt(1, id);
          ResultSet rs =  pre.executeQuery();
            while(rs.next()){
            Course corse = new Course();
            corse.setName(rs.getString(1));
            allCourse.add(corse);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return allCourse ;   
    }
    
  public boolean deleteCourse(int id,String name){
  try {
            String sql = "delete * from registercourse where Name=? and Id = ?";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, name);
            pre.setInt(2, id);
            pre.executeUpdate();
           return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
       return false;
        }
  }
   
    public int maxNum(){
           int x = 0 ;
  try {
            String sql = "select max(num) from registerCourse ";
            PreparedStatement pre = conn.prepareCall(sql);
           ResultSet rs =  pre.executeQuery();
            while(rs.next()){
            
           x =rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
      
        }
   return ++x;
    }
  
    public int NumtoDelete(int id ,String name){
     String sql ="select Num from registercourse where Name =? and Id=?" ;  
     int x=0;
        try {
            PreparedStatement pre =conn.prepareCall(sql);
        pre.setString(1, name);
        pre.setInt(2, id);
        
        ResultSet rs = pre.executeQuery();
        while(rs.next()){
        x=rs.getInt(1);
        
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return x;
    }
    
   public boolean deleteCoursewithNum(int num){
   
   String sql ="delete from registercourse where Num=?";
        try {
            PreparedStatement pre = conn.prepareCall(sql);
       pre.setInt(1, num);
        pre.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
   return false;
   }
    
  public boolean checkExistCourse(int id ,String name){
  boolean check = true;
      String sql = "select Num from registercourse where Id =? and Name = ?";
      int x =0; 
      try {
      PreparedStatement pre = conn.prepareCall(sql);
     pre.setString(2, name);
     pre.setInt(1, id);
      ResultSet rs = pre.executeQuery();
            while(rs.next()){
            x = rs.getInt(1);
          if(x!=0){
                check = false;
          break;
          }}
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
   return check;
  }
  
  public boolean UpdateStudentInfo(Student std){
  
  String sql ="update student set Password=? , Name=? where Id=?";
  
        try {
             PreparedStatement pre= conn.prepareCall(sql);
             pre.setString(1, std.getPassword());
             pre.setString(2, std.getName());
             pre.setInt(3, std.getId());
             pre.executeUpdate();
       return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
  return false;
  }
    
  public boolean deleteOldStudent(int id){
  String sql ="delete from student where id =?";
        try {
            PreparedStatement pre = conn.prepareCall(sql);
       pre.setInt(1, id);
        pre.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
  return false;
  }

public int noOfCourse(int id){
int x=0,a=0;
int i=0;
String sql ="select Num from registercourse where Id =? ";
      try {
            PreparedStatement pre =conn.prepareCall(sql);
        pre.setInt(1, id);
       ResultSet rs= pre.executeQuery();
       while(rs.next()){
       a=rs.getInt(1);
       x++;
       }
       return x;
        } catch (SQLException ex) {
            Logger.getLogger(Student_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
      return x;
}
 
}
 