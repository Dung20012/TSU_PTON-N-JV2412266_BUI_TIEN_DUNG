package com.data.final_exam_javaweb.service;

import com.data.final_exam_javaweb.model.entity.Advertising_Strategy;
import com.data.final_exam_javaweb.repository.IAdvertisingStrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdvertisingStrategyServiceImpl implements IAdvertisingStrategyService {
    @Autowired
    private IAdvertisingStrategyRepository advertisingStrategyRepository;

    @Override
    public List<Advertising_Strategy> findAll() {
        return advertisingStrategyRepository.findAll();
    }

    @Override
    public List<Advertising_Strategy> findByPage(int page, int size) {
        int offset = (page - 1) * size;
        return advertisingStrategyRepository.findByPage(offset, size);
    }

    @Override
    public int count() {
        return advertisingStrategyRepository.count();
    }

    @Override
    public void save(Advertising_Strategy advertising_strategy) {
        advertisingStrategyRepository.save(advertising_strategy);
    }

    @Override
    public void update(Advertising_Strategy advertising_strategy) {
        advertisingStrategyRepository.update(advertising_strategy);
    }

    @Override
    public void delete(int id) {
        advertisingStrategyRepository.deleteById(id);
    }

    @Override
    public Advertising_Strategy findById(int id) {
        return advertisingStrategyRepository.findById(id);
    }

    @Override
    public List<Advertising_Strategy> searchByName(String keyword) {
        return advertisingStrategyRepository.searchByName(keyword);
    }
}
