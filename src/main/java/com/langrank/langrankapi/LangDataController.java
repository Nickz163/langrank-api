package com.langrank.langrankapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LangDataController {

    @Autowired
    LanguageDataCustomRepository languageDataCustomRepository;

    @RequestMapping("/data")
    public Map<String, Double> greeting(@RequestParam(value = "name", defaultValue = "java") String name,
                                        @RequestParam(value = "source", defaultValue = "TIOBE") String source) {
        System.out.println("HERE");
        return languageDataCustomRepository.getLanguageData(name,source);
    }
}
