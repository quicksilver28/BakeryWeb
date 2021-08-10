/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryjava.dao;

import bakeryjava.bean.Order;
import bakeryjava.helper.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sana
 */
public class OrderDisplay extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Order> order_list = new ArrayList<>();
        String select_query = "select * from orders";
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            out.println("Idhar error");
            conn = DBConn.getcon();
            out.println("Idhar theek");
            statement = conn.createStatement();
            rs = statement.executeQuery(select_query);
            while (rs.next()) {
                out.println("ya???");
                Order order = new Order();
                order.setOid(rs.getInt(1));
                order.setCreateDate(rs.getDate(2));
                order.setShipDate(rs.getDate(3));
                order.setStatus(rs.getInt(4));
                order.setCid(rs.getInt(5));
                order.setTotal(rs.getFloat(6));
                //out.println(order);
                //out.println(product.getPname());
                order_list.add(order);
            }
            if (order_list == null) {
                out.println("Khali");
            } else {
                HttpSession session = request.getSession();
                //request.setAttribute("products", product_list);
                request.setAttribute("orders", order_list);
                RequestDispatcher dispatcher = null;
                if (session != null && session.getAttribute("admin") != null) {
                    dispatcher = request.getRequestDispatcher("all_orders.jsp");
                } else {
                    dispatcher = request.getRequestDispatcher("add_product.jsp");
                }
                //response.sendRedirect(request.getContextPath()+"/all_products.jsp?products="+product_list);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            out.println("Exception occurs hmmm");
            out.println(e);
        }
    }

}
