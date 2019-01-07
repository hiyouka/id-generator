package com.jy.idgenerator.controller;

import com.jy.idgenerator.service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ivaneye on 17-3-16.
 */
@RestController("/generate")
public class IdGeneratorController {

    @Autowired
    private IdGeneratorService idGeneratorService;

    @RequestMapping("/")
    public long generateCommon() {
        return idGeneratorService.generate();
    }

    @RequestMapping("/{prefix}")
    public String generateWithPrefix(@PathVariable("prefix") String prefix) {
        return prefix + idGeneratorService.generate();
    }

    @RequestMapping("/{prefix}/{suffix}")
    public String generateWithPrefixAndSuffix(@PathVariable("prefix") String prefix, @PathVariable("suffix") String suffix) {
        return prefix + idGeneratorService.generate() + suffix;
    }

}
