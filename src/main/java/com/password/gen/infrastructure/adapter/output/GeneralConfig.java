package com.password.gen.infrastructure.adapter.output;

import com.password.gen.domain.service.PasswordGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {
    @Bean
    public PasswordGeneratorService passwordGeneratorService(){
        return new PasswordGeneratorService();
    }
}
