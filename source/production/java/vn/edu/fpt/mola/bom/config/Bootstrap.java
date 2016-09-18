package vn.edu.fpt.mola.bom.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class Bootstrap implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext container) throws ServletException
    {

        container.getServletRegistration("default").addMapping("/resource/*");

        // Root Context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class);
        container.addListener(new ContextLoaderListener(rootContext));

        // Web Context
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebServletContextConfiguration.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "springWebDispatcher", new DispatcherServlet(webContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        // Rest Context
        AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
        restContext.register(RestServletContextConfiguration.class);
        DispatcherServlet servlet = new DispatcherServlet(restContext);
        servlet.setDispatchOptionsRequest(true);
        dispatcher = container.addServlet(
                "springRestDispatcher", servlet);
        dispatcher.setLoadOnStartup(2);
        dispatcher.addMapping("/rest/*");
    }
}
