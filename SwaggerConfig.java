//package_name                                                                    //package_name

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.ApiInfo;

//-------------------------------------------------------------------------URL
//http://localhost:8080/swagger-ui.html
//http://localhost:8080/swagger-ui/#

//-------------------------------------------------------------------------dependency
/* Add to pom.xml this dependencies
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-boot-starter</artifactId>
			<version>3.0.0</version>
		</dependency>
*/
//-------------------------------------------------------------------------application.yml
/* Add to application.yml
spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
*/
//-------------------------------------------------------------------------Codes
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("main_package_name")) //main_package_name
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }
	
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot Swagger")                //subject
                .description("User Api Documentation")
                .contact(new Contact("Mustafa KARAKAŞ", "", ""))                //your_name
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.12.3")
                .build();
    }
}
