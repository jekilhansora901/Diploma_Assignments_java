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
public class insert_item_order extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        HttpSession session=request.getSession(true);
        //int item_id_final = Integer.parseInt(request.getParameter("itemid"));
        String btn = request.getParameter("add");
        String table_id = request.getParameter("table_no");
        
        if(btn.equals("Add"))
        {
        try {
            
        int billno = Integer.parseInt(session.getAttribute("billno").toString());
        //String billno = session.getAttribute("billno").toString();
        int item_id = Integer.parseInt(request.getParameter("id_item"));
        //String item_id = request.getParameter("id_item");
        int qty = Integer.parseInt(request.getParameter("qty"));
        String items = request.getParameter("items");
        String comment = request.getParameter("Comment");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insert_item_order</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("BIll no : "+billno+" Qty : "+qty+" Item_id : "+item_id+" Comment : "+comment);
            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select item_price from items where item_id = "+item_id);
            rs.next();
            out.println("Price : "+(Double.parseDouble(rs.getString("item_price")) * qty));
            double total = Double.parseDouble(rs.getString("item_price")) * qty;
            out.println("Total Value is : "+total);
            int result = st.executeUpdate("insert into Bill (`bill_id`,`table_no`,`item_id`,`Comment`,`item_qty`,`date`,`total_bill_pitem`) values ('"+billno+"',"+table_id+",'"+item_id+"','"+comment+"',"+qty+",'"+dateFormat.format(cal.getTime())+"',"+total+")");
            out.println("Result Value : "+result);
            out.println("jekil hansora : "+table_id+" : "+items);
            if(result>0)
                response.sendRedirect("sub_menu?table="+table_id+"&items="+items);
//            out.println("<tr><td></td><td>"+dateFormat.format(cal.getTime())+"</td></tr>");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("</body>");
            out.println("</html>");
        }
        catch(SQLException ed )
        {
            out.println(ed.toString()+"\n"+ed.getMessage()+"\n"+ed.getSQLState());
        }
        catch(Exception s)
        {
            out.println(s.toString()+s.getMessage());
        }
        finally {
            out.close();
        }
        }
        else if(btn.equals("Main Menu"))
        {
            response.sendRedirect("MainWindow");
        }
        else if(btn.equals("Order Summary"))
        {
            response.sendRedirect("order_summary?table="+table_id);
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
