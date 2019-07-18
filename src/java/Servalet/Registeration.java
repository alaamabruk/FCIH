/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servalet;
import Beans.Student;
import Data.DataConnection;
import Data.Student_Operation;
import HelperBeans.AdminAction;
import HelperBeans.StudentAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
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
@WebServlet(name = "Registeration", urlPatterns = {"/Registeration"})
public class Registeration extends HttpServlet {

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
          PrintWriter out =response.getWriter();
       
          boolean isValid=true;
          String errMsg="";
          String url ="";
          Student s1 = new Student();
         AdminAction aop = new AdminAction();
        StudentAction op =new StudentAction();
         Student std =new Student();
                int level,id;
       float Gpa; 
        
       String user = request.getParameter("fname");
       String pwd = request.getParameter("pass");
       String Specific = request.getParameter("Specific");
       
       try{
       Gpa = Float.parseFloat(request.getParameter("gpa"));
       }catch (NumberFormatException ex){
       Gpa =-1;
       }
       
       
       try{
           level =Integer.parseInt(request.getParameter("level")) ;
            }catch(NumberFormatException ex){
                level=-1;
            }
       try{
          id = Integer.parseInt(request.getParameter("id"));
        }catch(NumberFormatException ex){
                id=-1;
            }
             
       
       if(user==null || user.isEmpty()){
                isValid=false;
                errMsg="Please insert the Name";
            }
        else if(pwd==null || pwd.isEmpty()){
        isValid = false;
        errMsg="Please insert the PassWord";
        }
       
        else if(Specific==null || Specific.isEmpty()){
        isValid= false;
        errMsg="Please insert the Specification";
        }
      else if(level<=0){
                isValid=false;
                errMsg="Please enter a legal Level";
            } 
      else if(id<=0){
                isValid=false;
                errMsg="Please enter a legal Id";
            }
      else if(Gpa <= 0){
      isValid =false;
      errMsg ="Please Enter Legal Gpa !";
      }
       
       
       if(isValid){
       s1.setName(user);
       s1.setPassword(pwd);
       s1.setSpecific(Specific);
       s1.setLevel(level);
       s1.setId(id);
       s1.setGpa(Gpa);
     if(op.registerStudent(s1)){
         errMsg="Your Register is Completed .Can Login Now ";
           out.println("<div style='color:black'>"+errMsg+"</div>");
         url="index.jsp";}
    else
         url="Registeration.jsp";
    }
      else{
           url="Registeration.jsp";
                out.println("<div style='color:red'>"+errMsg+"</div>");
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
