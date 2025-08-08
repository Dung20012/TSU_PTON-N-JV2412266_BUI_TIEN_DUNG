package com.data.final_exam_javaweb.repository;

import com.data.final_exam_javaweb.model.entity.Advertising_Strategy;

import java.util.List;

public interface IAdvertisingStrategyRepository {
    List<Advertising_Strategy> findAll();
    List<Advertising_Strategy> findByPage(int offset, int limit);
    int count();

    void save(Advertising_Strategy advertising_strategy);
    void update(Advertising_Strategy advertising_strategy);
    void deleteById(int id);
    Advertising_Strategy findById(int id);

    List<Advertising_Strategy> searchByName(String keyword);
}
