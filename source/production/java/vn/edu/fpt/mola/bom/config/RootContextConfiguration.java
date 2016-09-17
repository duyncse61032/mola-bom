package vn.edu.fpt.mola.bom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = "vn.edu.fpt.mola.bom.site",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootContextConfiguration
{
}
