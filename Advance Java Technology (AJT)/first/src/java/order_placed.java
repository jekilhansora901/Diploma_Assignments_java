/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
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
public class order_placed extends HttpServlet {

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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select item_name,item_qty,item_price,table_no,total_bill_pitem,Comment from items,bill where bill.item_id=items.item_id and bill.bill_id="+bill_no);
            out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
                "<html xmlns='http://www.w3.org/1999/xhtml' lang='en' xml:lang='en'>\n" +
                "<head>\n" +
                "<title>(Bill No-"+bill_no+")</title>\n" +
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
            out.println("<h3><center>Z Restaurant</h3><h4>Bill No - "+bill_no+"</center></h4>");
            out.println("<table>");
            out.println("<tr><td colspan='5' align='right'>Date : "+dateFormat.format(cal.getTime())+"</td></tr>");
            out.println("<tr>");
                out.println("<th>Sr.<br>No</th>");
                out.println("<th>Item Name</th>");
                out.println("<th>Qty</th>");
                out.println("<th>Price</th>");
                out.println("<th>Total</th>");
            out.println("</tr>");
            int i,gtotal,tax;
            i=1;
            gtotal = 0;
            tax=8;
            String order;
            order = "";
            while(rs.next())
            {
                if(i==1)
                    order = "For Table No : "+rs.getString("table_no") + "\n";
                out.println("<tr>");
                order = order + " "+ i +"\t";
                    out.println("<td>"+i+"</td>");
                    i++;
                    order = order + rs.getString("item_name") + " \t";
                    out.println("<td>"+rs.getString("item_name")+"</td>");
                    order = order + rs.getString("item_qty");
                    out.println("<td align='center'>"+rs.getString("item_qty")+"</td>");
                    out.println("<td align='center'>"+rs.getString("item_price")+"</td>");
                    out.println("<td align='right'>"+rs.getString("total_bill_pitem")+"</td>");
                    order = order + rs.getString("Comment") + "\n";
                out.println("</tr>");
                gtotal = gtotal + Integer.parseInt(rs.getString("total_bill_pitem"));
            }
            out.println("<tr>");
                out.println("<td> </td>");
                out.println("<td> </td>");
                out.println("<td colspan='2'>Total</td>");
                out.println("<td align='right'>"+gtotal+"</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td> </td>");
                out.println("<td> </td>");
                out.println("<td colspan='2'>Service Tax("+tax+"%)</td>");
                out.println("<td align='right'>"+((gtotal*tax)/100)+"</td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td> </td>");
                out.println("<td> </td>");
                out.println("<td colspan='2'><b> Grand Total</b></td>");
                out.println("<td align='right'><b>"+(((gtotal*tax)/100)+gtotal)+"</b></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<h4><center>Thank you For Visiting <br><br> <font size='10' color='yellow'>&#9787</font> </center></h4>");
            out.println("<form action='session_out' method='get'>");
            out.println("<center/><input type='submit' value='Add New Order'>");
            out.println("</form>");
            /*Client c = new Client();
                ServerSocket ss = new ServerSocket(777);
                Socket s = ss.accept();
                OutputStream os = s.getOutputStream();
                PrintStream ps = new PrintStream(os);
                ps.println(order);
            */
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
