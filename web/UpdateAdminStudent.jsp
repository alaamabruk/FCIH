
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adminUpdate Student Profile Page</title>
    </head>
    <body>
            <center>
                 <table border="1" align="center" >
            <caption> Student Information</caption>
            <tr>

               
                <th>Id</th>
                
              
            </tr>
            <tr>
                <%        for (Student s : lc) {


                %>
               
                <td><%=s.getId()%></td>
                
                </td>
                <td><a
                        href="adminUpdateStudentProfile.jsp?Id=<%=s.getId()%>">Update</a>
                        </td>
              
            </tr>
            <%
                }
            %>
        </table>

                
                    </tbody>
            </table>
            </center>
        </body>
</html>