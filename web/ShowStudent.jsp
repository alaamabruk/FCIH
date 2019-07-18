<%-- 
    Document   : index
    Created on : May 9, 2015, 6:23:18 PM
    Author     : 3laa Mabruk
--%>
<%@page import="Beans.Admin"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FCIH </title>
<meta name="keywords" content="free css template, Production Template, XHTML CSS Layout, Web Design XHTML, CSS" />
<meta name="description" content="Production Template is a free XHTML CSS Layout from TemplateMo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
    <body>
	<div class="templatemo_container">
		<div id="templatemo_header">
        	<div id="templatemo_menu"> 
				<ul>
                                    <li><a href="<%= response.encodeURL("adminPage.jsp")%>">Home</a></li>        
					
					<li><a href="<%= response.encodeURL("servics.jsp")%>">Services</a></li>	
                		        <li><a href="<%= response.encodeURL("logout")%>">Log out</a></li>
                   
            	</ul>
                                        
                                                                    <table align="right">
       
                                       <tr><td>                         
             
                                               <h3>    Welcome  </h3>   </td>           
  
    <td>   
<%
    
Admin adm = new Admin();
    adm = (Admin)session.getAttribute("currAdmin");
    if(adm==null){
   Student std =new Student();
    std=(Student)session.getAttribute("currStudent");
    
    out.println(std.getName());
    out.println();
    out.println(std.getSpecific());
    }
    else {
    
    out.println(adm.getName());
    }

%>
</td></tr>
</table>
			</div>
            
        	<div id="templatemo_logo_area">
				<div id="templatemo_logo">
                	<h5>FCIH<font size="5">Site</font></h5>
                </div>
                
                <div id="templatemo_slogan">
                	
                </div>
            </div>
 
		</div>
        
        <div class="templatemo_one_col">

        	<h1>Welcome to our FCIH site</h1>
            <p>A vocabulary and set of grammatical rules for instructing a computer to perform specific tasks. The term programming language usually refers to high-level languages, such as BASIC, C, C++, COBOL, FORTRAN, Ada, and Pascal. Each language has a unique set of keywords (words that it understands) and a special syntax for organizing program instructions.
High-level programming languages, while simple compared to human languages, are more complex than the languages the computer actually understands, called machine languages. Each different type of CPUhas its own unique machine language.
Lying between machine languages and high-level languages are languages called assembly languages. Assembly languages are similar to machine languages, but they are much easier to program in because they allow a programmer to substitute namesfor numbers. Machine languages consist of numbers only. </p>  

<%@page import="java.util.List"%>
<%@page import="Data.Admin_Operation"%>
<%@page import="Beans.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <%
 Student std =new Student();
    Admin_Operation op = new Admin_Operation();
  
    //std =(Student)session.getAttribute("currStudent");
   // out.print(std.getId());
    List<Student> lc = op.getallStudent();

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AllStudent Page</title>
    </head>
      <table border="1" align="left" >
          <caption> <h3>Student Information</h3></caption>
            <tr>

                <th>First Name</th>
                <th>Password</th>
                <th>Id</th>
                <th>Specific</th>
                <th>Level</th>
                <th>Action</th>
               
              
            </tr>
            <tr>
                <%        for (Student s : lc) {


                %>
                <td><%=s.getName()%></td>
                <td><%=s.getPassword()%></td>
                <td><%=s.getId()%></td>
                <td><%=s.getSpecific()%></td>
                <td><%=s.getLevel()%>
                </td>
                <td>
                    <a  href="<%= response.encodeURL("ViewStudentCourse.jsp")%>?Id=<%=s.getId()%>">View</a>
                        <a
                        href="<%= response.encodeURL("appcontroller?action=delete")%>&Id=<%=s.getId()%>">Delete</a>
                </td></tr>
                
              
           
            <%
                }
            %>
          
        </table>
            
           
        
    
    
   
</html>






                
                <div id="templatemo_right">
                	<div class="templatemo_section_2">
                    	<div class="templatemo_title">
                      <font size="3"> programming languages</font>
                        </div>
                        <ul class="templatemo_list">
                        	<li><a href="#">c</a></li>
                            <li><a href="#">c++</a></li>
                            <li><a href="#">java</a></li>
                            <li><a href="#">c#</a></li>
                            <li><a href="#">vb.net</a></li>
						</ul>
                    </div>
                    
                    <div class="templatemo_section_2">
                    	<div class="templatemo_title">
                        	About Us
                        </div>
                        <ul class="templatemo_list">
                        	<li><a href="#">our achievements</a></li>
                            <li><a href="#">our gools</a></li>
                           
						</ul>
                    </div>
                    
                    <div class="templatemo_section_2">
                    	<div class="templatemo_title">
                        	Contact Us
                        </div>
                        <ul class="templatemo_list">
                        	<li><a href="#">afcih@yahoo.com</a></li>
                            <li><a href="#">00287554987345</a></li>
                           
						</ul>
                    </div>
                </div><!-- End Of right -->
                
                <div class="cleaner"></div>
            </div><!-- End Of Container -->
        <div id="templatemo_footer">
        	Copyright © 2024 <a href="http://www.templatemo.com/page/1" target="_parent">Your Company Name</a> | 
            Designed by <a href="http://www.templatemo.com/page/1" target="_parent">Free CSS Templates</a> |
            Validate <a href="http://validator.w3.org/check?uri=referer">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> 
        </div>        
    </div><!-- End Of Content area-->
<!--  Free CSS Templates by TemplateMo.com  -->
</body>
</html>







