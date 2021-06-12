

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            HttpSession session;
            session=request.getSession(true);
            session.setAttribute("user", null);
            session.invalidate();
            out.println("<!DOCTYPE html>");
            out.println("<html><script type='text/javascript'>  windows.location('index.html');  alert('Jekil'); </script>");
            out.println("<head>");
            out.println("<title>Servlet session</title>");            
            out.println("</head>");
            out.println("<body>");
            session=request.getSession(true);
                
            response.sendRedirect("index.html");
            out.println("</body>");
            out.println("</html>");
        }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
