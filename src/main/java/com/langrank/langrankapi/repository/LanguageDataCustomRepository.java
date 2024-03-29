package com.langrank.langrankapi.repository;

import com.langrank.langrankapi.model.LanguageData;

import java.util.List;
import java.util.Map;


public interface LanguageDataCustomRepository {
    Map<String,Double> getLanguageDataSet(String name, String source);
    List<LanguageData> getLanguageData();
    List<LanguageData> getLanguageDataByName(String name);
    List<LanguageData> getLanguageDataBySource(String source);
    List<LanguageData> getLanguageDataByNameAndSource(String name, String source);
}
