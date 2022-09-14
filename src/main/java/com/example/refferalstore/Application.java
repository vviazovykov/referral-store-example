package com.example.refferalstore;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.apache.catalina.connector.Connector;

@SpringBootApplication
@EnableWebMvc
public class Application {

    private final int httpPort;

    @Autowired
    public Application(
        @Value("${http.port}") int httpPort
    ) {
        this.httpPort = httpPort;
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        var serverFactory = new TomcatServletWebServerFactory();
        serverFactory.addAdditionalTomcatConnectors(createStandardConnector());
        return serverFactory;
    }

    private Connector createStandardConnector() {
        var connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(httpPort);
        return connector;
    }
}