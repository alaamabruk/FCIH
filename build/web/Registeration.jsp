<%-- 
    Document   : index
    Created on : May 9, 2015, 6:23:18 PM
    Author     : 3laa Mabruk
--%>
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
       <li ><a href="<%= response.encodeURL("index.jsp")%>">Home</a></li>        
					<li><a href="<%= response.encodeURL("Registeration.jsp")%>">Register</a></li>
					
                		  
                   
            	</ul>
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

                
                
                <form method="post"    action="<%= response.encodeURL("Registeration")%>">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                   
                        </tr>
                    <tr>
                        <td>Specific</td>
                        <td><input type="text" name="Specific" value="" /></td>
                    </tr>
                    <tr>
                        <td>Level </td>
                        <td><input type="text" name="level" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="id" value="" /></td>
                    
                        </tr>
                    <tr>
                        <td>Gpa</td>
                        <td><input type="text" name="gpa" value="" /></td>
                    
                        </tr>
                    
                    
                    
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="<%= response.encodeURL("index.jsp")%>">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>

   <br>
       <a href="<%= response.encodeURL("Registeration.jsp")%>"><img src="images/url.gif"></a>










                
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
        	Copyright � 2024 <a href="http://www.templatemo.com/page/1" target="_parent">Your Company Name</a> | 
            Designed by <a href="http://www.templatemo.com/page/1" target="_parent">Free CSS Templates</a> |
            Validate <a href="http://validator.w3.org/check?uri=referer">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> 
        </div>        
    </div><!-- End Of Content area-->
<!--  Free CSS Templates by TemplateMo.com  -->
</body>
</html>







