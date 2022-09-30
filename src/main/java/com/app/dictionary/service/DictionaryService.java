package com.app.dictionary.service;

import com.app.dictionary.model.Word;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DictionaryService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * In this service, we are using Rest template to make the rest call to the 3rd party API.
     * and then we are using Streams to map that object array to our DTO by using object mapper.
     *
     * @param word
     * @return
     */
    public List<Word> fetchTheWord(String word) {
        try {
            log.info("Doing the rest call to the 3rd Party API against word: {}", word);
            String api = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ResponseEntity<Object[]> responseEntity =
                    restTemplate.getForEntity(api, Object[].class);
            Object[] objects = responseEntity.getBody();

            log.info("Response from the rest call: {} ", objects);
            if (objects != null) {
                return Arrays.stream(objects)
                        .map(object -> objectMapper.convertValue(object, Word.class))
                        .collect(Collectors.toList());
            } else {
                throw new RuntimeException("This word doesn't exists in the dictionary");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
