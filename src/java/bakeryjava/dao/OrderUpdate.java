/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryjava.dao;

import bakeryjava.helper.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sana
 */
public class OrderUpdate extends HttpServlet {

    private String ORDER_UPDATE = "update orders set status = 0 where oid = ?";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String order_id = request.getParameter("oid");
        if (order_id != null) {
            try {
                int oid = Integer.parseInt(order_id);
                Connection conn = DBConn.getcon();
                PreparedStatement ps = conn.prepareStatement(ORDER_UPDATE);
                ps.setInt(1, oid);
                ps.executeUpdate();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Order shipped!');");
                out.println("location='order_display';");
                out.println("</script>");
            } catch (Exception e) {
                out.println(e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
