package bakeryjava.dao;

import bakeryjava.bean.Address;
import bakeryjava.bean.Customer;
import bakeryjava.bean.Order;
import bakeryjava.bean.Product;
import bakeryjava.helper.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sana
 */
public class PlaceOrder extends HttpServlet {

    public Connection conn;
    Map<Integer, Pair> cart;
    List<Pair<Integer, Integer>> pid_qty;
    PrintWriter out;

    public int addCustomer(Customer customer) throws Exception, SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into customer(fname, lname, email, phone) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, customer.getFname());
        ps.setString(2, customer.getLname());
        ps.setString(3, customer.getEmail());
        ps.setString(4, customer.getPhone());
        int rows = ps.executeUpdate();
        if (rows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
        throw new Exception("customer id mismatch");
    }

    public int addAddress(Address address) throws Exception, SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into address(line1, line2, zipcode, cid) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, address.getLine1());
        ps.setString(2, address.getLine2());
        ps.setString(3, address.getZipcode());
        ps.setInt(4, address.getCid());
        int rows = ps.executeUpdate();
        if (rows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
        throw new Exception("address id mismatch");
    }

    public int addOrder(Order order, int diff) throws Exception, SQLException {
        //PreparedStatement ps = conn.prepareStatement("insert into orders(status, cid, total, createdate, shipdate) values(?,?,?,NOW(), DATE_ADD(NOW(), INTERVAL ? HOUR))", Statement.RETURN_GENERATED_KEYS);
        PreparedStatement ps = conn.prepareStatement("insert into orders(status, cid, total, createdate) values(?,?,?,NOW())", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, order.getStatus());
        ps.setInt(2, order.getCid());
        ps.setFloat(3, order.getTotal());
        //ps.setInt(4, diff);
        int rows = ps.executeUpdate();
        if (rows == 1) {
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            ps = conn.prepareStatement("update orders set shipdate = DATE_ADD(NOW(), INTERVAL ? HOUR) where oid = ?");
            ps.setInt(1, diff);
            ps.setInt(2, rs.getInt(1));
            ps.executeUpdate();
            return rs.getInt(1);
        }
        throw new Exception("order id mismatch");
    }

    public boolean mapOrderProduct(int oid) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into order_details(oid, pid, quantity) values(?,?,?)");
        int rows = 0;
        for (int i = 0; i < pid_qty.size(); i++) {
            ps.setInt(1, oid);
            ps.setInt(2, pid_qty.get(i).getKey());
            ps.setInt(3, pid_qty.get(i).getValue());
            rows += ps.executeUpdate();
        }
        return rows == pid_qty.size();
    }

    public float extractCart(Map<Integer, Pair> cart) throws Exception {
        float total = 0.0f;
        if (cart == null || cart.entrySet() == null) {
            throw new Exception("cart is empty. abort checkout");
        }
        pid_qty = new ArrayList<>();
        Set<Map.Entry<Integer, Pair>> entries = cart.entrySet();
        for (Map.Entry<Integer, Pair> entry : entries) {
            int pid = entry.getKey();
            Pair<Product, Integer> p_qty = new Pair<Product, Integer>((Product) entry.getValue().getKey(), (Integer) entry.getValue().getValue());
            pid_qty.add(new Pair<Integer, Integer>(pid, p_qty.getValue()));
            total += p_qty.getKey().getPrice() * p_qty.getValue();
        }
        return total;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String delivery = request.getParameter("deliverytime");
        int delivery_time = 0;
        if(delivery == null){
            delivery_time = 2;
        }
        else{
            delivery_time = Integer.valueOf(delivery);
        }
        HttpSession session = request.getSession();
        Map<Integer, Pair> cart = (ConcurrentHashMap<Integer, Pair>) session.getAttribute("cart");
        if (cart == null) {
            //out.println("cart is null");
            response.sendRedirect(request.getContextPath() + "/product_display");
        }
        try {
            conn = DBConn.getcon();
            Customer customer = new Customer(request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email"), request.getParameter("phone"));
            int cid = addCustomer(customer);
            //out.println(cid);
            Address address = new Address(request.getParameter("line1"), request.getParameter("line2"), request.getParameter("zipcode"), cid);
            int aid = addAddress(address);
            //out.println(aid);
            float total = extractCart(cart);
            //out.println(total);
            Order order = new Order(cid, 1, total); 
            int oid = addOrder(order, delivery_time);
            //out.println(oid);
            boolean isMapped = mapOrderProduct(oid);
            if (isMapped) {
                session.removeAttribute("cart");
                response.sendRedirect(request.getContextPath() + "/last_landing.jsp?msg=SUCCESS");
            } else {
                response.sendRedirect(request.getContextPath() + "/last_landing.jsp?msg=FAILED");
            }
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/last_landing.jsp?msg=FAILED");
            //out.println(e);
        }
    }
}
