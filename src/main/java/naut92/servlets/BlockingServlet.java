package naut92.servlets;

import naut92.impl.AstronomersServiceImpl;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlockingServlet extends HttpServlet {
    @Inject
    AstronomersServiceImpl service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        //response.getWriter().println("{ \"status\": \"ok\"}");
        response.getWriter().println(service.getAstronomers());
    }
}