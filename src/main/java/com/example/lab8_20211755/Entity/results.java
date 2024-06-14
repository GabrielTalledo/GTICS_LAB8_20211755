package com.example.lab8_20211755.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class results {
    String original_title;
    String overview;
    Float popularity;
    String release_date;
    String title;
}
