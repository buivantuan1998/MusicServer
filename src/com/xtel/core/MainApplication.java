package com.xtel.core;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication {

   public static void main(String[] args) throws Exception{

       ApplicationContext applicationContext = new ApplicationContext();
       applicationContext.configure();

       Server server = new Server(8080);
       ServletContextHandler ctx =
               new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

       ctx.setContextPath("/");
       server.setHandler(ctx);
       ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/api/*");
       serHol.setInitParameter("jersey.config.server.provider.packages",
               MainApplication.class.getPackage().getName());

       try {
           server.start();
           server.join();
       } catch (Exception ex) {
           Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, ex);
       } finally {

           server.destroy();
       }
   }

}
