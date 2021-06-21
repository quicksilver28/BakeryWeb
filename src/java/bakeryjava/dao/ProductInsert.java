package bakeryjava.dao;

/**
 *
 * @author Sana
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import bakeryjava.helper.DBConn;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class ProductInsert extends HttpServlet {

    private static final String SAVE_DIR = "ProductImages";
    String PRODUCT_INSERT = "insert into product (pname, descrp, price, catid, typeid, img) values(?, ?, ?, ?, ?, ?)";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pname = request.getParameter("product_name");
        String descrp = request.getParameter("product_descrp");
        float price = Float.parseFloat(request.getParameter("product_price"));
        int category = Integer.parseInt(request.getParameter("product_category"));
        int type = Integer.parseInt(request.getParameter("product_type"));
        String image = null;

        PrintWriter out = response.getWriter();
        String savePath = "G:/MCA/4th/WebJava/Project/bakeryweb/web/" + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        Part part = request.getPart("product_image");
        String fileName = extractFileName(part);
        part.write(savePath + "/" + fileName);
        //image = savePath + "/" + fileName;
        image = fileName;
        try {
            Connection conn = DBConn.getcon();
            PreparedStatement ps = conn.prepareStatement(PRODUCT_INSERT);
            ps.setString(1, pname);
            ps.setString(2, descrp);
            ps.setFloat(3, price);
            ps.setInt(4, category);
            ps.setInt(5, type);
            ps.setString(6, image);
            int rows = ps.executeUpdate();
            //out.println(request.getContextPath());
            if (rows == 1) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Product inserted.');");
                out.println("location='add_product.jsp';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Something went wrong.');");
                out.println("location='add_product.jsp';");
                out.println("</script>");
            }
            //response.sendRedirect(request.getContextPath() + "/add_products.jsp");
        } catch (Exception e) {
            out.println(e);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
