/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jekil
 */
public class order_summary extends HttpServlet {

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
        HttpSession session=request.getSession(true);
        String bill_no = session.getAttribute("billno").toString();
        String table_id = request.getParameter("table");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select item_name,item_qty,item_id from items,bill where bill.item_id=items.item_id and bill.bill_id="+bill_no);
            
            out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
                "<html xmlns='http://www.w3.org/1999/xhtml' lang='en' xml:lang='en'>\n" +
                "<head>\n" +
                "<title>(Table-"+table_id+")</title>\n" +
                "<meta http-equiv='Content-type' content='text/html; charset=UTF-8' />\n" +
                "<style type='text/css' media='all'>\n" +
                "@import 'style.css';\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id='navcontainer'>\n" +
                "  <ul>\n" +
                "    <li><a href='first_page'>Home</a></li>\n" +
                "    <li><a href='about_us'>About Us</a></li>\n" +
                "    <li><a href='contact_us'>Contact Us</a></li>\n" +
                "  </ul>\n" +
                "</div>\n" +
                "<div id='horizon'>\n" +
                "  <div id='content'>\n" +
                "    <div id='maincontainer'>\n" +
                "      <div id='contentwrapper'>\n" +
                "        <div id='contentcolumn'>\n" +
                "          <div id='text'>");
            out.println("<h4><center>Welcome to our Restaurant<br>Order Summary<br>( Table - "+table_id+" )</center></h4>");
            
            out.println("<table>");
            out.println("<center><tr><td colspan='2'><b>Bill No : "+bill_no+" </b></td>");
            out.println("<td colspan='4'><b>Table No : "+table_id+" </b></td></tr>");
            out.println("</center><tr><th>Sr<br>No.</th><th>Items</th><th colspan='1'>Quantity</th></tr>");
            int i;
            i=1;
            while(rs.next())
            {
                out.println("<form action='delete_item' method='get'>");
                out.println("<input type='hidden' name='table_no' value='"+table_id+"'>");
                out.println("<input type='hidden' name='id_item' value='"+rs.getString("item_id")+"'>");
                out.println("<input type='hidden' name='item_qty' value='"+rs.getString("item_qty")+"'>");
                //out.println("<input type='hidden' name='bill_no' value='"+bill_no+"'>");
                out.println("<tr><td>"+i+"</td>");
                out.println("<td>"+rs.getString("item_name")+"</td>");
                out.println("<td colspan='2'>");
                out.println("<input type='submit' name='operation' value='+'> "+rs.getString("item_qty")+" <input type='submit' name='operation' value='-'>");
                //out.println("</td>");
                out.println("<input type='submit' name='operation' value='x'></td></tr>");
                out.println("</form>");
                i++;
            }
            out.println("<form action='delete_item' method='get'>");
            out.println("<tr> <td colspan='3'><input type='submit' name='operation' value='Main Menu'></td>");
            out.println("<td colspan='3'><input type='submit' name='operation' value='Place Order'></td> </tr>");
            out.println("</form>");
            out.println("</table>");

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
            }        catch(SQLException ed )
            {
                out.println(ed.toString()+"\n"+ed.getMessage()+"\n"+ed.getSQLState());
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
