package com.example.demo.wordMeaning;

import com.example.demo.wordMeaning.WordMeaning;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WordMeaningRepository extends CrudRepository<WordMeaning,Long> {
}
