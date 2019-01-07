package com.jy.idgenerator.service;

import com.jy.idgenerator.generator.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdGeneratorService {

    @Autowired
    private SnowflakeIdGenerator generator;

    public long generate() {
        return generator.nextId();
    }

}