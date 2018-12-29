package naut92.servlets;

import naut92.impl.StarsServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@RunAs("special")
//@DeclareRoles({"user","client"})
//@WebServlet(name = "StarsServlet", urlPatterns = {"/stars"})
public class StarsServlet extends HttpServlet {

    private SqlSessionFactory sqlSessionFactory;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StarsServiceImpl service = new StarsServiceImpl(sqlSessionFactory);

        // Convert numbers array into JSON string.
        Gson gson = new Gson();
        String serviceInJson = gson.toJson(service.getStars());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(serviceInJson);
    }
}