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
public class Word {
    public String word;
    public List<Phonetics> phonetics;
    public List<Meanings> meanings;
    public List<String> sourceUrls;
    public License license;
}
