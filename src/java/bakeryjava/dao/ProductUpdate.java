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

public class ProductUpdate extends HttpServlet{

    private String PRODUCT_UPDATE = "update product set pname = ?, descrp = ?, catid = ?, typeid = ?, price = ? where pid = ?";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        try{
            Connection conn = DBConn.getcon();
            PreparedStatement ps = conn.prepareStatement(PRODUCT_UPDATE);
            ps.setString(1, request.getParameter("product_name"));
            ps.setString(2, request.getParameter("product_descrp"));
            ps.setInt(3, Integer.parseInt(request.getParameter("product_category")));
            ps.setInt(4, Integer.parseInt(request.getParameter("product_type")));
            ps.setFloat(5, Float.parseFloat(request.getParameter("product_price")));
            ps.setInt(6, Integer.parseInt(request.getParameter("product_id")));
            ps.executeUpdate();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Product updated.');");
            out.println("location='ProductDisplay';");
            out.println("</script>");
        }
        catch(Exception e){
            out.println(e);
        }
    }
    
    
    
}
