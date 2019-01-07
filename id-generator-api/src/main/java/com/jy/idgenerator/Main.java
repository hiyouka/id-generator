package com.jy.idgenerator;

import com.jy.idgenerator.generator.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableEurekaClient
public class Main {

    @Value("${synapse.id.generator.workerId}")
    private long workerId;

    @Value("${synapse.id.generator.dataCenterId}")
    private long dataCenterId;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public SnowflakeIdGenerator snowflakeIdGenerator() {
        return new SnowflakeIdGenerator(workerId, dataCenterId);
    }
}
