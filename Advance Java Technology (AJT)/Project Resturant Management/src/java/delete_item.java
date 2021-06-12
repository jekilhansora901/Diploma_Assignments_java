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
public class delete_item extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String button = request.getParameter("operation");
            if(button.equals("Main Menu"))
            {
                response.sendRedirect("MainWindow");
            }
            else if(button.equals("Place Order"))
            {
                response.sendRedirect("order_placed");
            }
            else
            {
                int billno = Integer.parseInt(session.getAttribute("billno").toString());
                int item_id = Integer.parseInt(request.getParameter("id_item"));
                int item_qty = Integer.parseInt(request.getParameter("item_qty"));
                String table_id = request.getParameter("table_no");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Order_summary (Table No. "+table_id+")</title>");            
                out.println("</head>");
                out.println("<body>");
                Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
                Statement st=cn.createStatement();
                Statement st1=cn.createStatement();
                ResultSet rs = st1.executeQuery("select item_price from items where item_id = "+item_id);
                rs.next();
                int price = Integer.parseInt(rs.getString("item_price"));
                out.println("Price JEkil : "+price);
                int result;
                result = 0;
                if(item_qty==1 && button.equals("-"))
                {
                    button = "x";
                }
                if(button.equals("x"))
                {
                    result = st.executeUpdate("Delete from Bill where bill_id="+billno+" and item_qty="+item_qty+" and table_no='"+table_id+"' and item_id="+item_id);
                }
                else if(button.equals("+") || button.equals("%2B"))
                {
                    int total_price = price * (item_qty+1);
                    result = st.executeUpdate("update Bill set item_qty="+(item_qty+1)+" , total_bill_pitem="+total_price+" where bill_id="+billno+" and table_no='"+table_id+"' and item_id="+item_id+" and item_qty="+item_qty); 
                }
                else if(button.equals("-"))
                {
                    int total_price= price * (item_qty-1); 
                    result = st.executeUpdate("update Bill set item_qty="+(item_qty-1)+" , total_bill_pitem="+total_price+" where bill_id="+billno+" and table_no='"+table_id+"' and item_id="+item_id+" and item_qty="+item_qty); 
                }
                if(result>0)
                    response.sendRedirect("order_summary?table="+table_id);
                out.println("Hello</body></html>");
            }
        }
        catch(NumberFormatException e)
        {
            out.println(e.getMessage());
        } catch (SQLException e) {
            out.println(e.getMessage());
        } catch (IOException e) {
            out.println(e.getMessage());
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
