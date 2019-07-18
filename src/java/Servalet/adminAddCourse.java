/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servalet;

import Data.Student_Operation;
import HelperBeans.AdminAction;
import HelperBeans.StudentAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oscar
 */
@WebServlet(name = "adminAddCourse", urlPatterns = {"/adminAddCourse"})
public class adminAddCourse extends HttpServlet {

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
        
StudentAction op =new StudentAction();
       AdminAction aop = new AdminAction();
               
        boolean isValid=true;
        String mess="";
        
        String id = request.getParameter("courseid");
        String name =request.getParameter("coursename");
        
        if (name==null||name.isEmpty()){
        isValid =false;
        mess= "Please Insert Name of Course";
        }
        
        if(id==null || id.isEmpty()){
        isValid =false;
        mess= "Please Insert ID";}
       String Url="";
        
        
        if(isValid){
       
            if(aop.adminRegCourse(id, name))
            {
            out.println("Course Is Added Success !");
            Url="adminPage.jsp";
            }
        else 
            {
            out.println("This Course Is Registered  Before!");
            Url="adminPage.jsp";
            }
             
       RequestDispatcher disp=request.getRequestDispatcher(Url);
        disp.include(request, response);
        }
        else{
            Url="adminAddCourse.jsp";
         out.println("<div style='color:black'>"+mess+"</div>");
                RequestDispatcher disp=request.getRequestDispatcher(Url);
                disp.include(request, response);
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
