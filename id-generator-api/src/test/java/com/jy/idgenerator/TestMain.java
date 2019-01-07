package com.jy.idgenerator;

import com.jy.idgenerator.generator.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ivaneye on 17-2-26.
 */
@SpringBootApplication
@Configuration
@ComponentScan({"com.jy.idgenerator.*"})
public class TestMain {

    @Value("${synapse.id.generator.workerId}")
    private long workerId;

    @Value("${synapse.id.generator.dataCenterId}")
    private long dataCenterId;

    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }

    @Bean
    public SnowflakeIdGenerator snowflakeIdGenerator() {
        return new SnowflakeIdGenerator(workerId, dataCenterId);
    }

}
