package med.voll.api.infra.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyCorsconfigurations {
    @Bean
    public WebMvcConfigurer corsConfigurer () {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://deploy-nocountry.vercel.app/")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATH")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
