package org.elec5619.peerhelping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     *  allow cross origin
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // allow any requests
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("http://localhost:8080") // allow url cors
                .allowCredentials(true)
                .exposedHeaders(HttpHeaders.SET_COOKIE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
