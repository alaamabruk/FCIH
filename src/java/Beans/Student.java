/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Oscar
 */
public class Student {

    
    Course course = new Course();
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSpecific() {
        return Specific;
    }

    public void setSpecific(String Specific) {
        this.Specific = Specific;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int Level) {
        this.Level = Level;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
       

    private  String Name;
    private String Password;
    private String Specific;
    private int Level;
    private int Id;
    private float Gpa;

    public void setGpa(float Gpa) {
        this.Gpa = Gpa;
    }

    public float getGpa() {
        return Gpa;
    }
    
    
    
}
