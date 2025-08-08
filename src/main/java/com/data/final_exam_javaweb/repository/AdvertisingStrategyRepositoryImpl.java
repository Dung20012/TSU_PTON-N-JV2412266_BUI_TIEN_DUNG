package com.data.final_exam_javaweb.repository;

import com.data.final_exam_javaweb.model.entity.Advertising_Strategy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AdvertisingStrategyRepositoryImpl implements IAdvertisingStrategyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Advertising_Strategy> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Advertising_Strategy", Advertising_Strategy.class)
                .getResultList();
    }


    @Override
    public List<Advertising_Strategy> findByPage(int offset, int limit) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Advertising_Strategy ", Advertising_Strategy.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public int count() {
        String hql = "select count(*) from Advertising_Strategy";
        Long count = (Long) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .uniqueResult();
        return count.intValue();
    }

    @Override
    public void save(Advertising_Strategy advertising_strategy) {
        sessionFactory.getCurrentSession().save(advertising_strategy);
    }

    @Override
    public void update(Advertising_Strategy advertising_strategy) {
        sessionFactory.getCurrentSession().update(advertising_strategy);
    }

    @Override
    public void deleteById(int id) {
        Advertising_Strategy adv = findById(id);
        if (adv != null) {
            sessionFactory.getCurrentSession().delete(adv);
        }
    }

    @Override
    public Advertising_Strategy findById(int id) {
        return sessionFactory.getCurrentSession()
                .get(Advertising_Strategy.class, id);
    }

    @Override
    public List<Advertising_Strategy> searchByName(String keyword) {
        Session session =  sessionFactory.getCurrentSession();
        String hql = "from Advertising_Strategy as adv where adv.managerName like :keyword";
        return session.createQuery(hql, Advertising_Strategy.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }
}
