package naut92;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyServerAsync{

    private static final Logger log = LoggerFactory.getLogger(JettyServerAsync.class);

    public static void main(String[] args) throws Exception {
        //new JettyServerAsync().start();
        Server server = new Server(8090);

        ServletContextHandler ctx =
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/api/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages",
                "naut92.res");

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            log.error("Error occurred while starting Jetty", ex);
            System.exit(1);
        } finally {
            server.destroy();
        }
    }
}