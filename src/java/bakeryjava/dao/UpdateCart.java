/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakeryjava.dao;

import bakeryjava.bean.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        int pid = Integer.parseInt(req.getParameter("pid"));
        int qty = Integer.parseInt(req.getParameter("qty"));
        
        HttpSession session = req.getSession();
        
        Map<Integer, Pair> cart = (ConcurrentHashMap<Integer, Pair>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(pid)) {
            cart.put(pid, new Pair<Product, Integer>((Product)cart.get(pid).getKey(), qty));
        }
        if (cart.isEmpty()){
            resp.sendRedirect(req.getContextPath() + "/ProductDisplay");
        }
        /*out.println("Haa remove kar diya");
        Set<Map.Entry<Integer, Pair>> entries = cart.entrySet();
        for (Map.Entry<Integer, Pair> entry : entries) {
            out.println(entry.getKey() + " " + entry.getValue().getValue());
        }*/
        //req.getRequestDispatcher("ViewCart").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/ViewCart");
    }
}
