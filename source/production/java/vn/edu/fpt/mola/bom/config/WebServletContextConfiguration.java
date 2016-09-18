package vn.edu.fpt.mola.bom.config;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.edu.fpt.mola.bom.config.annotation.WebController;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = "vn.edu.fpt.mola.bom.site",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(WebController.class)
)
public class WebServletContextConfiguration extends WebMvcConfigurerAdapter
{
    @Inject ObjectMapper objectMapper;
    @Inject Marshaller marshaller;
    @Inject Unmarshaller unmarshaller;

    /**
     * Configuring Message Converters
     */
    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
    	
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new FormHttpMessageConverter());
        converters.add(new SourceHttpMessageConverter<>());

        MarshallingHttpMessageConverter xmlConverter =
                new MarshallingHttpMessageConverter();
        xmlConverter.setSupportedMediaTypes(Arrays.asList(
                new MediaType("application", "xml"),
                new MediaType("text", "xml")
        ));
        xmlConverter.setMarshaller(this.marshaller);
        xmlConverter.setUnmarshaller(this.unmarshaller);
        converters.add(xmlConverter);

        MappingJackson2HttpMessageConverter jsonConverter =
                new MappingJackson2HttpMessageConverter();
        jsonConverter.setSupportedMediaTypes(Arrays.asList(
                new MediaType("application", "json"),
                new MediaType("text", "json")
        ));
        jsonConverter.setObjectMapper(this.objectMapper);
        converters.add(jsonConverter);
    }

    /**
     * Configuring Content Negotiation
     */
    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer)
    {
        configurer.favorPathExtension(true)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useJaf(false)
                .defaultContentType(MediaType.APPLICATION_XML)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }
    
    /**
     * Configuring View Resolution
     * @return
     */
    @Bean
    public ViewResolver viewResolver()
    {
        /*  The InternalResourceView and JstlView implement traditional JSP and 
            JSTL-enhanced-JSP views, respectively. They take care of translating model attributes to 
            request attributes and forwarding the request on to the proper JSP. */
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * Configuring View Name Translation
     * @return
     */
    @Bean
    public RequestToViewNameTranslator viewNameTranslator()
    {
    	/*  Strips off the web application context URL and any file extension
    	    at the end of the URL. What remains of the URL becomes the view name.
    	    For example, the URL http://localhost:8080/mvc/foo turns into the view name foo,
    	    whereas the URL http://localhost:8080/mvc/foo/bar.html turns into 
            the view name foo/bar. */
        return new DefaultRequestToViewNameTranslator();
    }
}
