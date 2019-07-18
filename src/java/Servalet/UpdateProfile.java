/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servalet;

import Beans.Student;
import Data.Student_Operation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oscar
 */
@WebServlet(name = "UpdateProfile", urlPatterns = {"/UpdateProfile"})
public class UpdateProfile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter(); 
        
        
        boolean isValid=true;
          String errMsg="";
          String url ="";
          Student s1 = new Student();
        Student_Operation std_op =new Student_Operation();
   HttpSession session = request.getSession();
   Student std = new Student();      
   std =(Student)session.getAttribute("currStudent");
        
        int level,id;
        
        
       String user = request.getParameter("fname");
       String pwd = request.getParameter("pass");
      
       
             
       
       if(user==null || user.isEmpty()){
                isValid=false;
                errMsg="Please insert the Name";
            }
        else if(pwd==null || pwd.isEmpty()){
        isValid = false;
        errMsg="Please insert the PassWord";
        }
       
       
       
       
       if(isValid){
       s1.setName(user);
       s1.setPassword(pwd);
        s1.setId(std.getId());
//std_op.deleteOldStudent(std.getId());
     if(std_op.UpdateStudentInfo(s1)){
         errMsg="Your Register is Completed . YY Can Login Now ";
          // out.println("<div style='color:red'>"+errMsg+"</div>");
         url="index.jsp";}
    else
         url="updateProfile.jsp";
    }
      else{
           url="updateProfile.jsp";
        //        out.println("<div style='color:red'>"+errMsg+"</div>");
                }
            RequestDispatcher disp=request.getRequestDispatcher(url);
                disp.include(request, response);
        
        
   
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
