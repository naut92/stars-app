package naut92.servlets;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AsyncServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            final AsyncContext ctxt = req.startAsync();
            ctxt.start(new Runnable() {
                @Override
                public void run() {
                    System.err.println("In AsyncContext / Start / Runnable / run");
                    ctxt.complete();
                }
            });
        }
}