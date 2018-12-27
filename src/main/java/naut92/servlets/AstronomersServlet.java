package naut92.servlets;

import naut92.entities.AstronomersEntity;
import naut92.impl.AstronomersServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;

//import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AstronomersServlet extends HttpServlet {

    private SqlSessionFactory sqlSessionFactory;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AstronomersServiceImpl service = new AstronomersServiceImpl(sqlSessionFactory);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(service.getAstronomers());
        //response.getWriter().println("{ \"status\": \"ok\"}");
        //for (AstronomersEntity a : service.getAstronomers()){
        //response.getWriter().println("{\"astronomer name\":" + a.getAstronomer_name() + "}");
        //}

    }
}