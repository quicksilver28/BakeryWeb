package bakeryjava.dao;

import bakeryjava.helper.DBConn;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ProductDelete extends HttpServlet{
    private String SQL_DELETE = "delete from product where pid = ?";
    private String IMG_SELECT = "select img from product where pid = ?";
    private String DIR_PATH = "G:/MCA/4th/WebJava/Project/bakeryweb/web/ProductImages";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int pid = Integer.parseInt(request.getParameter("pid"));
        String filename = null;
        try{
            Connection conn = DBConn.getcon();
            PreparedStatement ps = null;
            ps = conn.prepareStatement(IMG_SELECT);
            ps.setInt(1, pid);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
                filename = rs.getString(1);
            }
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, pid);
            int row = ps.executeUpdate();
            if(row == 1){
                deleteImageFile(filename);
            }
            response.sendRedirect(request.getContextPath() + "/product_display");
        }
        catch(Exception e){
            out.println(e);
        }
    }

    private void deleteImageFile(String filename) throws IOException{
        if(filename == null)
            return;
        Files.delete(Paths.get(DIR_PATH+'/'+filename));
    }
    
}
