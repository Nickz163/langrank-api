package com.langrank.langrankapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class LangDataController {

    @Autowired
    LanguageDataCustomRepository languageDataCustomRepository;

    @RequestMapping(value = "/dataset", params = {"name", "source"})
    public Map<String, Double> getLanguageDataSet(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "source", required = false) String source) {
        return languageDataCustomRepository.getLanguageDataSet(name, source);
    }

    @RequestMapping
    public List<LanguageData> getLanguageData() {
        return languageDataCustomRepository.getLanguageData();
    }

    @RequestMapping(params = {"name"})
    public List<LanguageData> getLanguageDataByName(@RequestParam(value = "name", required = false) String name) {
        return languageDataCustomRepository.getLanguageDataByName(name);
    }

    @RequestMapping(params = {"source"})
    public List<LanguageData> getLanguageDataBySource(@RequestParam(value = "source", required = false) String source) {
        return languageDataCustomRepository.getLanguageDataBySource(source);
    }

    @RequestMapping(params = {"name", "source"})
    public List<LanguageData> getLanguageDataByNameAndSource(@RequestParam(value = "name", required = false) String name,
                                                             @RequestParam(value = "source", required = false) String source) {
        return languageDataCustomRepository.getLanguageDataByNameAndSource(name, source);
    }


}
