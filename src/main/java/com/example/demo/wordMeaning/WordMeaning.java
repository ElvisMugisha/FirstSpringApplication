package com.example.demo.wordMeaning;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name="wordtable")
public class WordMeaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @JsonProperty("word")
    private String word;

    @JsonProperty("meaning1")
    private String meaning1;

    @JsonProperty("meaning2")
    private String meaning2;

    @JsonProperty("rating")
    private long rating;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getWord() {

        return word;
    }

    public void setWord(String word) {

        this.word = word;
    }

    public String getMeaning1() {

        return meaning1;
    }

    public void setMeaning1(String meaning1) {

        this.meaning1 = meaning1;
    }

    public String getMeaning2() {

        return meaning2;
    }

    public void setMeaning2(String meaning2) {

        this.meaning2 = meaning2;
    }

    public long getRating() {

        return rating;
    }

    public void setRating(long rating) {

        this.rating = rating;
    }
}
