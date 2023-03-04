package ifms.edu.br.lp2.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
class SwaggerConfig{

    @Bean
    public Docket api(){//Classe responsável por todas as funcionalidades do sistema de Documentação

        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title ("Api da Unidade <b> Curricular Linguagem de programação 2 </b>")
            .description ("Essa é a API de Avaliação de Estudantes")
            .license("https://www.apache.org.licenses/LICENSE-2.0")
            .termsOfServiceUrl("/service.html")
            .version("1.0.0")
            .contact(new Contact("Douglas","https://www.ifms.edu.br/","douglas.queiroz2@estudante.ifms.edu.br"))
            .build();
        //localhost:8080/swagger/ui.html#/


}
}
