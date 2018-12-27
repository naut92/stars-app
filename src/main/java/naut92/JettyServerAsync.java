package naut92;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import naut92.servlets.BlockingServlet;


public class JettyServerAsync{
    private Server server;
    //private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws Exception {
        new JettyServerAsync().start();
        //AstronomersServiceImpl service = new AstronomersServiceImpl(sqlSessionFactory);
        //System.out.println(service.getAstronomers().get(0).getAstronomer_name());
    }

    void start() throws Exception {
        //async cerver:
        /*server = new Server(8090);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        ServletHolder asyncHolder = context.addServlet(AsyncServlet.class,"/async");
        asyncHolder.setAsyncSupported(true);
        server.setHandler(context);
        server.start();
        server.join();*/

        //blocked server:
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[] {connector});

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(BlockingServlet.class, "/astronomers");
        //servletHandler.addServletWithMapping(AsyncServlet.class, "/heavy/async");


        server.start();
    }

    void stop() throws Exception {
        server.stop();
    }
}