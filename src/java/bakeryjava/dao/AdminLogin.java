/*
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.addHeader("Cache-Control", "post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0);
 */

package bakeryjava.dao;

import bakeryjava.helper.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sana
 */
public class AdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection con = null;
        try {
            con = DBConn.getcon();
            PreparedStatement ps = con.prepareStatement("select password from admin where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            //out.println(rs.getString(1));
            //out.println(password);
            if (rs.next() && rs.getString(1).equals(password)) {
                //out.println(rs.getString(1));
                HttpSession currentSession = request.getSession(true);
                currentSession.setAttribute("admin", "true");
                response.sendRedirect(request.getContextPath() + "/add_product.jsp");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Entry denied!');");
                out.println("location='admin_login.jsp';");
                out.println("</script>");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

}
