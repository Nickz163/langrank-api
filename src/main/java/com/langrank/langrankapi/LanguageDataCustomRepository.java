package com.langrank.langrankapi;

import java.util.Map;


public interface LanguageDataCustomRepository {
    Map<String,Double> getLanguageData(String name, String source);
}
