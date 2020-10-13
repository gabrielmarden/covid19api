package br.com.nedramdev.covid19api.config;

import br.com.nedramdev.covid19api.model.DiagnosisPk;
import br.com.nedramdev.covid19api.model.EvaluationExamPK;
import br.com.nedramdev.covid19api.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.nedramdev.covid19api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .ignoredParameterTypes(
                        new Class[]{EvaluationExamPK.class,
                                DiagnosisPk.class,
                                Role.class,
                                Page.class,
                                Sort.class
                                });

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("COVID 19 RESTful API")
                .description("\"The COVID19 RESTful API project uses a general-purpose code to focus on the management of patients with COVID 19. " +
                        "It helps the user to manage and monitor different stages that patients face in eventual hospitalizations.\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

