package zw.co.lws.livestockwebservice;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

    public SwaggerConfiguration() {
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Livestock Web Service",
                "The Livestock Web Service Rest provides end-points for livestock application  ",
                "1.0",
                "Terms of service",
                new Contact("Shelton", "", "sheltshamu@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
}