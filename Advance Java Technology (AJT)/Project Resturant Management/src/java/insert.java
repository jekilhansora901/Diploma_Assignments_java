/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jekil
 */
public class insert extends HttpServlet {

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
        String btn = request.getParameter("submit");
        try {
            /* TODO output your page here. You may use following sample code. */
            if(btn.equals("Back"))
            {
                response.sendRedirect("index.html");
            }
            else
            {
            int id= Integer.parseInt(request.getParameter("item_id"));
            String item_name = request.getParameter("name");
            int item_type = Integer.parseInt(request.getParameter("item_type"));
            int price = Integer.parseInt(request.getParameter("price"));
            String desc = request.getParameter("description");
            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://D:\\test\\restaurant_management.accdb");
            Statement st=cn.createStatement();
            int result = st.executeUpdate("insert into items (`item_id`,`item_name`,`item_type_id`,`item_price`,`item_description`) values ("+id+", '"+item_name+"', "+item_type+","+price+",'"+desc+"')");
            if(result>0)
                response.sendRedirect("insert_new_item");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insert</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insert at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            }
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
