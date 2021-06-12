                                                                                                                                       import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
                                                                                                                                       
                                                                                                                                       

public class first_page extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session;
        String struname=request.getParameter("uname");
        String strpass =request.getParameter("pass");
        PrintWriter out = response.getWriter();
            try
            {
            session=request.getSession(true);
            if(session.getAttribute("user")!=null)
            {
                int b = Integer.parseInt(session.getAttribute("billno").toString());
                b++;
                session.setAttribute("billno", b);
                response.sendRedirect("MainWindow");
            }
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection cn=DriverManager.getConnection("jdbc:odbc:restaurant");
            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
            Statement st=cn.createStatement();
            Statement st1=cn.createStatement();
            ResultSet rs=st.executeQuery("select * from users where username='"+struname+"' and password='"+strpass+"'");
            ResultSet rs1=st1.executeQuery("SELECT bill_id FROM Bill ORDER BY bill_id");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Detail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='POST' action='session'>");
            out.println("<div style=\"margin-top:200px;\"");
            if(rs.next())
            {    
               // session=request.getSession(true);
                if(session.getAttribute("user")==null)
                {
                    session.setAttribute("user",rs.getString(1));
                    int bill_no=0;
                    while(rs1.next())
                    {
                        bill_no = Integer.parseInt(rs1.getString("bill_id"));
                    }
                    bill_no = bill_no+2;
                    session.setAttribute("billno", bill_no);
                    response.sendRedirect("MainWindow");
                }
            }
            /*if(session.getAttribute("user")!=null || rs.next())
            {
                response.sendRedirect("MainWindow");
                out.println("<table align='center'>");
                out.println("<tr><td><font color=\"green\">Log In Success</font></td><td></td></tr>");
                out.println("<tr>   <td>    <br>Welcome, "+session.getAttribute("user"));
                out.println("</tr>  </td>");
                out.println("<tr>   <td>    </td>   <td><input type='submit' name='submit' value='LogOut'>");
            }*/
            else
            {
                out.println("<table align='center'>");
                out.println("<tr><td><font color=\"red\">Sorry, You have entered an invalied user name or password</font></td></tr>");
                out.println("<tr><td><font color=\"red\"><br>Please Try Again</font></td></tr>");
                out.println("</table");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            }
            catch (SQLException e) {
                out.println("Error Message for Database : "+e.toString());
        }
            catch(Exception d)
            {
                out.println("Message from server : "+d.toString());
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
        HttpSession session = request.getSession(true);
        Date creatTime = new Date(session.getCreationTime());
        
        
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