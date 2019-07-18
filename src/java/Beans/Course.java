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
public class Course {

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }
    
    
   private String Name;

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getId() {
        return Id;
    }
   private String Id; 
}
