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
public class Definitions {
    public String definition;
    public List<String> synonyms;
    public List<String> antonyms;
    public String example;
}
