package com.langrank.langrankapi.repository;

import com.langrank.langrankapi.model.LanguageData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "languages", path = "languages")
public interface LanguageDataRepository extends MongoRepository<LanguageData,String> {
    List<LanguageData> findAllBySource(@Param("source") String source);
    List<LanguageData> findAllByName(@Param("name") String name);
    List<LanguageData> findByNameAndSource(@Param("name") String name, @Param("source") String source);


//    @Query(value="{}", fields="{data : 1, _id : 0}")
//    List<LanguageData>getAllDataByNameAndSource(@Param("name") String name, @Param("source") String source);
}
