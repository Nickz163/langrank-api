package com.langrank.langrankapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LanguageDataCustomRepositoryImpl implements LanguageDataCustomRepository {

    final MongoTemplate mongoTemplate;

    @Autowired
    public LanguageDataCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    /**
     * Method that provides all languages data
     * @return List of the LanguageData for all languages from all source.
     * LanguageData contains source name, language name
     * and popularity data (Map of the &lt;date(in string): popularity value(in double))&gt;)
     */

    @Override
    public List<LanguageData> getLanguageData() {
        Query query = new Query();
        return mongoTemplate.find(query, LanguageData.class);
    }

    /**
     * Method that provides data from all source for one language
     * @param name language name
     * @return  List of the LanguageData for specified language from all source.
     * LanguageData contains source name, language name
     * and popularity data (Map of the &lt;date(in string): popularity value(in double))&gt;)
     */
    @Override
    public List<LanguageData> getLanguageDataByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.find(query,LanguageData.class);
    }

    /**
     * Method that provides data of all languages from one source
     * @param source name of language popularity source
     * @return List of the LanguageData from specified source.
     * LanguageData contains source name, language name
     * and popularity data (Map of the &lt;date(in string): popularity value(in double))&gt;)
     */
    @Override
    public List<LanguageData> getLanguageDataBySource(String source) {
        Query query = new Query(Criteria.where("source").is(source));
        return mongoTemplate.find(query,LanguageData.class);
    }

    /**
     * Method that provides data of one languages from one source
     * @param name language name
     * @param source name of language popularity source
     * @return List of the LanguageData which contains one language from specified source.
     * LanguageData contains source name, language name
     * and popularity data (Map of the &lt;date(in string): popularity value(in double))&gt;)
     */
    @Override
    public List<LanguageData> getLanguageDataByNameAndSource(String name, String source) {
        Query query = new Query(Criteria.where("source").is(source));
        return mongoTemplate.find(query,LanguageData.class);
    }

    /**
     * Method that provides dataset of one language from one source.
     * This method returns only date-value mapping.
     *
     * @param name language name
     * @param source name of language popularity source
     * @return Popularity data (Map of the &lt;date(in string): popularity value(in double))&gt;)
     */
    @Override
    public Map<String, Double> getLanguageDataSet(String name, String source) {
        Query query = new Query(Criteria.where("name").is(name).and("source").is(source));
        List<LanguageData> result = mongoTemplate.find(query, LanguageData.class);
        return result.stream()
                .flatMap(languageData -> languageData.getData().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

}
