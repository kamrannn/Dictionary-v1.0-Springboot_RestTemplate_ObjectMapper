package com.app.dictionary.controller;

import com.app.dictionary.model.Word;
import com.app.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    /**
     * This is the API that will be receiving a word from the user and will return you the WORD object.
     * http://localhost:8080/api/get/{word}
     * here you will replace the word by your own specific word. i.e
     * http://localhost:8080/api/get/help
     *
     * @param word
     * @return
     */
    @GetMapping("/get/{word}")
    public List<Word> getWord(@PathVariable(name = "word") String word) {
        return dictionaryService.fetchTheWord(word);
    }
}
