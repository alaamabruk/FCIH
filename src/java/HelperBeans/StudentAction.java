/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperBeans;

import Beans.Course;
import Beans.Student;
import Data.Student_Operation;
import java.util.List;
/**
 *
 * @author Oscar
 */
public class StudentAction {
    
      Student_Operation op = new Student_Operation();
    
     public  boolean registerStudent(Student e) {

         return op.registerStudent(e);
        }

    
     


    public boolean checkLogin(String name, String pwd){     
     
     return op.checkLogin(name,pwd);}     
     
     
    
   
     
    public boolean RegCourse(int num,int id ,String name){
       return op.RegCourse(num, id, name);
        }
    
    
    
    
    
    
    public List<Course> ShowCourse(int id ){
     return op.ShowCourse(id) ;   
    }
    
  public boolean deleteCourse(int id,String name){
       return op.deleteCourse(id,name);
        }
  
   
    public int maxNum(){
   return op.maxNum();
    }
  
    public int NumtoDelete(int id ,String name){
    return op.NumtoDelete(id, name);
    }
    
   public boolean deleteCoursewithNum(int num){
   return op.deleteCoursewithNum(num);
   }
    
    
 
    
  
  public boolean checkExistCourse(int id ,String name){
   return op.checkExistCourse(id, name);
  }
  
  
 
  
 public boolean UpdateStudentInfo(Student std){
return op.UpdateStudentInfo(std);
 }
    
  public boolean deleteOldStudent(int id){
  return op.deleteOldStudent(id);
  }

public Student retriveStudent(String name, String pwd ){

return op.retriveStudent(name, pwd);
}

  
    
    
 public int noOfCourse(int id){

      return op.noOfCourse(id);
}
 

}
