/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jekil
 */
public class MainWindow extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        HttpSession session=request.getSession(true);
        try {
            /* TODO output your page here. You may use following sample code. */
            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select * from item_category");
            
                
            out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
                "<html xmlns='http://www.w3.org/1999/xhtml' lang='en' xml:lang='en'>\n" +
                "<head>\n" +
                "<title>Welcome</title>\n" +
                "<meta http-equiv='Content-type' content='text/html; charset=UTF-8' />\n" +
                "<style type='text/css' media='all'>\n" +
                "@import 'style.css';\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method='post' action='sub_menu'>"+
                "<div id='navcontainer'>\n" +
                "  <ul>\n" +
                "    <li><a href='first_page'>Home</a></li>\n" +
                "    <li><a href='about_us'>About Us</a></li>\n" +
                "    <li><a href='contact_us'>Contact Us</a></li>\n" +
                "    <li><a href='insert_new_item'>Add New Item</a></li>\n" +
                "  </ul>\n" +
                "</div>\n" +
                "<div id='horizon'>\n" +
                "  <div id='content'>\n" +
                "    <div id='maincontainer'>\n" +
                "      <div id='contentwrapper'>\n" +
                "        <div id='contentcolumn'>\n" +
                "          <div id='text'>");
            out.println("<h4><center>Welcome to our Restaurant</center></h4>");
            out.println("<h4>Bill No : "+session.getAttribute("billno").toString()+"</h4>");
            out.println("<table><tr><td></td><td>Date : "+dateFormat.format(cal.getTime())+"</td></tr>");
            out.println("<tr><td><b>Select Table Number : </b></td><td><select name='table'><option value=1>1</option> <option value=2>2</option> <option value=3>3</option> <option value=4>4</option> </select></td></tr>");
            int i=0;
            out.println("<tr><td colspan='2'><center><b>MENU</b></center></td></tr>");
            while(rs.next())
            {
                i++;
                if(i%2==0)
                    out.println("<td><input type='submit' name='items' value='"+rs.getString(3)+"'</td></tr>");             
                else 
                    out.println("<tr><td><input type='submit' name='items' value='"+rs.getString(3)+"'</td>");             
               
            }     
            out.println("</table>");
            out.println("</form>");
            out.println("</div>\n" +
"          <div id='copyright'> &copy; Jekil Hansora (130073107005)<br> &copy; Kuldeep Gadhavi (130073107003)</div>\n" +
"        </div>\n" +
"      </div>\n" +
"      <div id='leftcolumn'>\n" +
"        <div id='navleft'>		  <br><br>\n" +
"		  <h3>Z Restaurant</h3>\n" +
"		  <ul>\n" +
"			<b>Gujarati<br>\n" +
"			  Punjabi<br>\n" +
"			  Chineese<br>\n" +
"			  Italian<br>\n" +
"			Maxican<br></b>\n" +
"		  </ul>\n" +
"        </div>\n" +
"        <div id='notesleft'><h3><b> Z Restaurant</h3>Near B-Cube Hotel, <br> Price Society, <br> Bhuj-370001 <br> Gujarat </b></div>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>\n" +
"</body>\n" +
"</html>");
        }
        catch(SQLException ed )
        {
            out.println(ed.toString());
        }
        finally {
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
