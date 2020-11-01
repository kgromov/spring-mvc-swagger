package guru.springframework.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by konstantin on 01.11.2020.
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    @Primary
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())   // packages could be configured here; could filter out others Spring configurations and e.g. MVC section in ui
//                .paths(PathSelectors.any())            // PathSelectors: e.g ant("/recipes/*")
                .apis(RequestHandlerSelectors.basePackage("guru.springframework.restcontrollers"))
                .paths(PathSelectors.ant("/recipes/*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot MVC with Swagger")
                .description("Demo project to demonstrate Swagger UI")
                .version("1.0")
                .build();
    }
}
