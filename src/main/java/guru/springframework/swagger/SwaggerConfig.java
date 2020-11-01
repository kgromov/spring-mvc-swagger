package guru.springframework.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by konstantin on 01.11.2020.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())   // packages could be configured here; could filter out others Spring configurations and e.g. MVC section in ui
                .paths(PathSelectors.any())            // PathSelectors: e.g ant("/recipes/*")
                .build()
                .apiInfo(customInfo());
    }

    // String title, String description, String version,
    // String termsOfServiceUrl, Contact contact, String license,
    // String licenseUrl, Collection<VendorExtension> vendorExtensions
    private ApiInfo customInfo() {
        Contact contact = new Contact("Gromov Konstantin", "https://github.com/kgromov/spring-mvc-swagger", "");
        return new ApiInfo("Spring Boot MVC with Swagger",
                "Demo project to demonstrate Swagger UI",
                "1.0",
                "",
                contact,
                "Terms of use",
                "https://github.com/kgromov/spring-mvc-swagger",
                Collections.emptyList());
    }
}
