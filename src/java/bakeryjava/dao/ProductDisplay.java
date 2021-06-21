package bakeryjava.dao;

import bakeryjava.bean.Product;
import bakeryjava.helper.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;


public class ProductDisplay extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        PrintWriter out = response.getWriter();
        List<Product> product_list = new ArrayList<>();
        String select_query = "select * from product";
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try{
            out.println("Idhar error");
            conn = DBConn.getcon();
            out.println("Idhar theek");
            statement = conn.createStatement();
            rs = statement.executeQuery(select_query);
            while(rs.next()){
                Product product = new Product();
                product.setPid(rs.getInt(1));
                product.setPname(rs.getString(2));
                product.setDescrp(rs.getString(3));
                product.setPrice(rs.getBigDecimal(4).floatValue());
                product.setCategory(rs.getInt(5));
                product.setType(rs.getInt(6));
                product.setImg(rs.getString(7));
                //out.println(product);
                //out.println(product.getPname());
                product_list.add(product);
            }
            if(product_list == null){
                out.println("Khali");
            }
            else{
                HttpSession session = request.getSession();
                //request.setAttribute("products", product_list);
                request.setAttribute("products", product_list);
                RequestDispatcher dispatcher = null;
                if(session != null && session.getAttribute("admin") != null){
                    dispatcher = request.getRequestDispatcher("all_products.jsp");
                }
                else{
                    dispatcher = request.getRequestDispatcher("all_products_view.jsp");
                }
                //response.sendRedirect(request.getContextPath()+"/all_products.jsp?products="+product_list);
                dispatcher.forward(request, response);
            }
        }
        catch(Exception e){
            out.println("Exception occurs hmmm");
            out.println(e);
        }
        /*finally{
            try{
                rs.close();
                statement.close();
                conn.close();
            }
            catch(Exception e){
                out.println(e);
            }
        }*/        
    }
    
}
