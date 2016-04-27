package ru.mail.sanches.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import ru.mail.sanches.HibernateUtil;
import ru.mail.sanches.dao.ProducerDao;
import ru.mail.sanches.entity.Actor;
import ru.mail.sanches.entity.Producer;

import java.util.List;

public class ProducerDaoImpl implements ProducerDao {


    @Override
    public Producer getBtId(Integer id) {
        Session session = getSession();
        Producer producer = (Producer) session.get(Producer.class, id);
        session.close();
        return producer;
    }


    @Override
    public List<Producer> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Producer.class);
        List<Producer> producers = criteria.list();
        session.close();
        return producers;
    }

    @Override
    public void save(Producer producer) {
        Session session = getSession();
        session.getTransaction().begin();
        session.saveOrUpdate(producer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void save(List<Producer> producers) {
        Session session = getSession();
        session.getTransaction().begin();
        for (Producer producer:producers) {
            session.saveOrUpdate(producer);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Producer> getByCriterion(Criterion criterion) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Producer.class);
        criteria.add(criterion);
        List<Producer> producers = criteria.list();
        session.close();
        return producers;
    }

    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
