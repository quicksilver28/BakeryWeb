package bakeryjava.dao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("YEs we logging out");
        HttpSession session = request.getSession();
        if(session!=null && session.getAttribute("admin").equals("true")){
            session.removeAttribute("admin");
            session.invalidate();
            session = request.getSession();
        }
        response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
    }

}
