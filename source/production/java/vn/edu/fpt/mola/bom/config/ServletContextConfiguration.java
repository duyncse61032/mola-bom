package vn.edu.fpt.mola.bom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = "vn.edu.fpt.mola.bom.site",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(Controller.class)
)
public class ServletContextConfiguration
{
}
