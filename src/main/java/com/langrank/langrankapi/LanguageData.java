package com.langrank.langrankapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedHashMap;
import java.util.Map;


@Document
public class LanguageData {

    @Id
    private String id;

    private String name;
    private String source;

    private Map<String, Double> data = new LinkedHashMap<>();

    public LanguageData() {
    }

    public LanguageData(String name, String sourceName) {
        this.name = name.toLowerCase();
        this.source = sourceName;
        id = (sourceName + name).toLowerCase(); // todo: temporary solution
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public Map<String, Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LanguageData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", data=" + data +
                '}';
    }


}
