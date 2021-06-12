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
public class sub_menu extends HttpServlet {

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
        int table_no = Integer.parseInt(request.getParameter("table"));
        HttpSession session=request.getSession(true);
        String type_name=request.getParameter("items");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select item_id,item_name,items.item_type_id,item_price,item_category.item_type_name from items,item_category where items.item_type_id=item_category.item_type_id and item_category.item_type_name='"+type_name+"'");
            //ResultSet rs=st.executeQuery("select * from item_category where item_type_name='"+type_name+"'");
            //ResultSet rs=st.executeQuery("select * from items ");
                    
            
            out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
                "<html xmlns='http://www.w3.org/1999/xhtml' lang='en' xml:lang='en'>\n" +
                "<head>\n" +
                "<title>"+type_name+" ( Table - "+table_no+" )</title>\n" +
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
            out.println("<h4><center>Welcome to our Restaurant<br>"+type_name+" ( Table - "+table_no+" )</center></h4>");
            out.println("<table>");
            int i=1;
            while(rs.next())
            {
                out.println("<form method='get' action='insert_item_order'>");
                out.println("<tr><td>"+rs.getString("item_id")+"</td>");
                out.println("<td>"+rs.getString(2)+"<td>");
                //out.println("<td><input type='checkbox' name='item_id' value='"+rs.getString(1)+"'></td>");
                out.println("<td><select name='qty'><option value=0>Qty</option><option value=1>1</option> <option value=2>2</option> <option value=3>3</option> <option value=4>4</option> </select></td>");
                out.println("<td><input type='text' name='Comment' size='5' placeholder='Comment'> </td>");
                out.println("<input type='hidden' name='id_item' value='"+rs.getString("item_id")+"'>");
                out.println("<input type='hidden' name='table_no' value='"+table_no+"'>");
                out.println("<input type='hidden' name='items' value='"+type_name+"'>");
                out.println("<td><input type='submit' name='add' value='Add'></td></tr>");
                out.println("</form>");
            
            }
            out.println("<form method='get' action='insert_item_order'>");
            out.println("<input type='hidden' name='table_no' value='"+table_no+"'>");
            out.println("<tr/><tr/><tr><td colspan='3'><input type='submit' name='add' value='Main Menu'> </td>");
            out.println("<td colspan='3'><input type='submit' name='add' value='Order Summary' </td></tr>");
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
        }
        catch(SQLException ed)
        {
            out.println(ed.toString());
        }
        catch(Exception e)
        {
            out.println(e.getMessage()+e.toString()+"jekil");
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
