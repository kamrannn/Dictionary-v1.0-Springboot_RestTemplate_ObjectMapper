package com.app.dictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meanings {
    public String partOfSpeech;
    public List<Definitions> definitions;
    public List<String> synonyms;
    public List<String> antonyms;
}
