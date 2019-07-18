/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperBeans;

import Beans.Admin;
import Beans.Course;
import Beans.Student;
import Data.Admin_Operation;
import java.util.List;

/**
 *
 * @author Oscar
 */
public class AdminAction {
    
    Admin_Operation op = new Admin_Operation();
     public boolean checkAdmin(String name, String pwd){
      return op.checkAdmin(name,pwd);  
    
     }
      public boolean adminRegCourse(String id,String name){
  return op.adminRegCourse(id, name);
  }
     
      public boolean delCourse(int id){
     return op.delCourse(id);
     }
       public boolean DelStudentAdmin(int id){
       return op.DelStudentAdmin(id);
       }
      
       public List retriveCourse(){
   return op.retriveCourse();
  }
 
  public boolean adminDeleteCourse(String name){
  
     return op.adminDeleteCourse(name);
  
  }
  
 
 
   
   
     public Student ShowStudent(int id){
       
     return op.ShowStudent(id);
     }
     
      public Admin retriveAdmin(String name, String pwd ){
      return op.retriveAdmin(name, pwd);
      }
public boolean AdminUpdateStudentInfo( Student s1,int oldID){

return AdminUpdateStudentInfo(s1,oldID);
}


}
