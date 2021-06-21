package bakeryjava.dao;

import bakeryjava.bean.Product;
import bakeryjava.helper.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javafx.util.Pair;

public class ViewCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        
        //retrieved list of <pid, quantity>
        Map<Integer, Pair> cart = (ConcurrentHashMap<Integer, Pair>) session.getAttribute("cart");
        if (cart == null)
            resp.sendRedirect(req.getContextPath() + "/ProductDisplay");
        else if(cart.entrySet() == null)
            resp.sendRedirect(req.getContextPath() + "/ProductDisplay");
        session.setAttribute("cart", cart);
        resp.sendRedirect(req.getContextPath() + "/view_cart.jsp");
    }
}

