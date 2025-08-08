package com.data.final_exam_javaweb.service;

import com.data.final_exam_javaweb.model.entity.Advertising_Strategy;

import java.util.List;

public interface IAdvertisingStrategyService {
    List<Advertising_Strategy> findAll();
    List<Advertising_Strategy> findByPage(int page, int size);
    int count();

    void save(Advertising_Strategy advertising_strategy);
    void update(Advertising_Strategy advertising_strategy);
    void delete(int id);
    Advertising_Strategy findById(int id);

    List<Advertising_Strategy> searchByName(String keyword);
}
