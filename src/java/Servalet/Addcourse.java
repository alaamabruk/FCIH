/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servalet;

import Beans.Student;
import Data.Student_Operation;
import HelperBeans.AdminAction;
import HelperBeans.StudentAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 3laa Mabruk
 */
public class Addcourse extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
String err ="";
           String url ="";
           StudentAction op =new StudentAction();
       AdminAction aop = new AdminAction();
       Student std =new Student();
        
          HttpSession session = request.getSession();
          std = (Student) session.getAttribute("currStudent");
          
            /* TODO output your page here. You may use following sample code. */
            String []a=request.getParameterValues("co");
          
              
            
            if(a != null){
                
                  if(std.getGpa()<2 && (a.length)+(op.noOfCourse(std.getId())) > 4){
                err="select Only 4 Subject";
                    
                url="addCourse.jsp";
                
                }
            
               else if (std.getGpa()>2 && (a.length)+(op.noOfCourse(std.getId())) >6){
                err="select Only 6 Subject";
                url="addCourse.jsp";
                }
                
                else{    
                  for (String a1 : a){
                      if(op.checkExistCourse(std.getId(), a1))
                 op.RegCourse(op.maxNum(), std.getId(), a1);  //if(op.checkExistCourse(std.getId(), a1))
                      else
                         out.println("Course : "+ a1 +"   Already Exist  \n"); 
                  }
                      url ="ShowCourse.jsp";
                } 
            }
          
        else{
           err="EnTer Course";
           out.println("No OF Courses : "+op.noOfCourse(std.getId()));
          url="addCourse.jsp";
           }
              
            
        
             out.println("<div style='color:black'>"+err+"</div>");
            RequestDispatcher ob=request.getRequestDispatcher(url);
            ob.include(request, response);
        }         finally {
            out.close();
        }
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
