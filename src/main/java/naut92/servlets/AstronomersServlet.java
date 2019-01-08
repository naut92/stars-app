package naut92.servlets;

import naut92.entities.StarsEntity;
import naut92.impl.AstronomersServiceImpl;
import naut92.impl.StarsServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@RunAs("special")
//@WebServlet(name = "AstronomersServlet", urlPatterns = {"/astronomers"})
//@DeclareRoles({"user","client"})
//@WebServlet(name = "astronomers", urlPatterns = "/astronomers")
public class AstronomersServlet extends HttpServlet {

    private SqlSessionFactory sqlSessionFactory;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StarsServiceImpl starsService = new StarsServiceImpl(sqlSessionFactory);
        AstronomersServiceImpl astronomersService = new AstronomersServiceImpl(sqlSessionFactory);

        // Convert numbers array into JSON string.
        Gson gson = new Gson();
        String serviceInJson =  "";
        for (StarsEntity s : starsService.getStars()){
            //serviceInJson += gson.toJson(astronomersService.getById(s.getAstronomer_id()));
        }
        //serviceInJson = serviceInJson.replaceAll("\\\\u003d", ":");
        //System.out.println(serviceInJson);
        //String serviceInJson = gson.toJson(starsService.getStars());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(serviceInJson);
    }
}