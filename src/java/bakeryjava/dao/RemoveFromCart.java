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
public class RemoveFromCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        int pid = Integer.parseInt(req.getParameter("pid"));
        
        HttpSession session = req.getSession();
        
        Map<Integer, Pair> cart = (ConcurrentHashMap<Integer, Pair>) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.remove(pid);
        }
        /*out.println("Haa remove kar diya");
        Set<Map.Entry<Integer, Pair>> entries = cart.entrySet();
        for (Map.Entry<Integer, Pair> entry : entries) {
            out.println(entry.getKey() + " " + entry.getValue().getValue());
        }*/
        //req.getRequestDispatcher("ViewCart").forward(req, resp);
        if(cart.isEmpty()){
            session.removeAttribute("cart");
            resp.sendRedirect(req.getContextPath() + "/product_display");
        }
        else
            resp.sendRedirect(req.getContextPath() + "/ViewCart");
    }
}
