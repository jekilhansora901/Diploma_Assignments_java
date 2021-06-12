/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jekil
 */
public class contact_us extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
                "<html xmlns='http://www.w3.org/1999/xhtml' lang='en' xml:lang='en'>\n" +
                "<head>\n" +
                "<title>About Us)</title>\n" +
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
            out.println("<h3><center>Z Restaurant</h3></center>");
            out.println("<h4>Jekil Hansora</h4>");
            out.println("<b>Bachelor of Engineering <br>(Computer Engineering)</b>");
            out.println("<br>130073107005");
            out.println("<br>Email : jekilhansora901@gmail.com");
            out.println("<br>Contact No : (+91)8866248620");
            out.println("<h4>Kuldeep Gadhavi</h4>");
            out.println("<b>Bachelor of Engineering <br>(Computer Engineering)</b>");
            out.println("<br>130073107003");
            out.println("<br>Email : kggadhavi@gmail.com");
            out.println("<br>Contact No : (+91)9558757574");
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
        } finally {
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
