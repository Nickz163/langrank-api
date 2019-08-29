package com.langrank.langrankapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LanguageDataCustomRepositoryImpl implements LanguageDataCustomRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Map<String, Double> getLanguageData(String name, String source) {
        Query query = new Query(Criteria.where("name").is(name).and("source").is(source));
//        query.fields().include("data");
        List<LanguageData> result = mongoTemplate.find(query, LanguageData.class);
        return result.stream()
                .flatMap(languageData -> languageData.getData().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
}
