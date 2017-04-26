package io.khasang.restaurant.config;

import io.khasang.restaurant.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Message message(){
        return new Message("hello bean!");
    }
}
