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
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        int pid = Integer.parseInt(req.getParameter("pid"));

        HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ConcurrentHashMap<Integer, Pair>());
        }

        Map<Integer, Pair> cart = (ConcurrentHashMap<Integer, Pair>) session.getAttribute("cart");

        if (cart.containsKey(pid)) {
            Pair<Product, Integer> inner = cart.get(pid);
            Product product = inner.getKey();
            int quantity = inner.getValue();
            quantity += 1;
            Pair<Product, Integer> new_inner = new Pair<>(product, quantity);
            cart.put(pid, new_inner);
        } else {
            String SQL_SELECT = "select pname, typeid, price, img from product where pid = ?";
            try {
                Connection conn = DBConn.getcon();
                PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
                ps.setInt(1, pid);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Product product = new Product();
                    product.setPid(pid);
                    product.setPname(rs.getString(1));
                    product.setType(rs.getInt(2));
                    product.setPrice(rs.getFloat(3));
                    product.setImg(rs.getString(4));
                    Pair<Product, Integer> cart_inner = new Pair<>(product, 1);
                    cart.put(pid, cart_inner);
                }
            } catch (Exception e) {
                out.println(e);
            }
        }
        /*Set<Map.Entry<Integer, Pair>> entries = cart.entrySet();
        for (Map.Entry<Integer, Pair> entry : entries) {
            out.println(entry.getKey() + " " + entry.getValue().getValue());
        }*/
        //out.println(session.getId());
        resp.sendRedirect(req.getContextPath() + "/product_display");
    }
}
