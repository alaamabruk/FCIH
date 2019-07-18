/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servalet;
import Beans.Admin;
import Beans.Student;
import Data.DataConnection;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oscar
 */
@WebServlet(name = "CheckLogin", urlPatterns = {"/CheckLogin"})
public class CheckLogin extends HttpServlet {

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
        
        
       //DataConnection dat =new DataConnection();  
       StudentAction op =new StudentAction();
       AdminAction aop = new AdminAction();
       Student std = new Student();
       Admin adm = new Admin();
        
        
          HttpSession session = request.getSession();
        
        String url="";
        String errMsg="";
        boolean isValid=true;
        
         String userid = request.getParameter("uname");    
         String pwd = request.getParameter("pass");
         String isAdmin=request.getParameter("isAdmin");
        
         if(userid==null || userid.isEmpty()){
                isValid=false;
                errMsg="Please Insert the Name";
            }
         else if(pwd==null || pwd.isEmpty()){
         isValid = false;
         errMsg ="Please Insert the Password ";
         }
       
         
         
         
         if(isValid){
  if (isAdmin !=null ){
         if(aop.checkAdmin(userid,pwd)){
             url="adminPage.jsp"; 
             adm=aop.retriveAdmin(userid, pwd);
             session.setAttribute("currAdmin", adm);
                  }
         else
             url="index.jsp";
        }
  
  else{
             if(op.checkLogin(userid, pwd))  {      
                 url ="Home.jsp";
                 std=op.retriveStudent(userid, pwd);
                  session.setAttribute("currStudent", std);
                                             }
             else
                 url="index.jsp";
     
               }
         
  RequestDispatcher disp=request.getRequestDispatcher(url);                
                disp.forward(request, response); 
            
         }  
         
         
         
         else{
                out.println("<div style='color:black'>"+errMsg+"</div>");
                RequestDispatcher disp=request.getRequestDispatcher("index.jsp");
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
