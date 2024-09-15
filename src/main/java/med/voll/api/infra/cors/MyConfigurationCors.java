package med.voll.api.infra.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class MyCorsconfigurations {

    // Inyecta el valor de la variable desde application.yml
//    @Value("${CORS_ALLOWED_ORIGINS}")
  //  private String allowedOrigins;


 //   @Bean
   // public WebMvcConfigurer corsConfigurer () {
     //   return new WebMvcConfigurer() {

       //     @Override
         //   public void addCorsMappings(CorsRegistry registry) {
           //     registry.addMapping("/**")
             //           .allowedOrigins("${CORS_ALLOWED_ORIGINS}")
               //         .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATH", "OPTIONS")
                 //       .allowedHeaders("*")
                   //     .allowCredentials(true);
   //         }
     //   };
//    }
//}
@Configuration
public class MyConfigurationCors {


           @Bean
           public WebMvcConfigurer corsConfigurer () {
               return new WebMvcConfigurer() {

                   @Override
                   public void addCorsMappings(CorsRegistry registry) {
                       registry.addMapping("/**")
                               .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATH");
                   }
               };
           }
       }