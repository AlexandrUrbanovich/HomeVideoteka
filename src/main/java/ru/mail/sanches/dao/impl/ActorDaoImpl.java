package ru.mail.sanches.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import ru.mail.sanches.HibernateUtil;
import ru.mail.sanches.dao.ActorDao;
import ru.mail.sanches.entity.Actor;

import java.util.List;

public class ActorDaoImpl implements ActorDao {

        @Override
        public Actor getById(Integer id) {
            Session session = getSession();
            Actor actor = (Actor) session.get(Actor.class, id);
            session.close();
            return actor;
        }

        @Override
        public List<Actor> getAll() {
            Session session = getSession();
            Criteria criteria = session.createCriteria(Actor.class);
            List<Actor> actors = criteria.list();
            session.close();
            return actors;
        }

        @Override
        public void save(Actor actor) {
            Session session = getSession();
            session.getTransaction().begin();
            session.saveOrUpdate(actor);
            session.getTransaction().commit();
            session.close();
        }

        @Override
        public void save(List<Actor> actors) {
            Session session = getSession();
            session.getTransaction().begin();
            for (Actor actor:actors) {
                session.saveOrUpdate(actor);
            }
            session.getTransaction().commit();
            session.close();
        }

        @Override
        public List<Actor> getByCriterion(Criterion criterion) {
            Session session = getSession();
            Criteria criteria = session.createCriteria(Actor.class);
            criteria.add(criterion);
            List<Actor> actors = criteria.list();
            session.close();
            return actors;
        }

        private Session getSession(){
            return  HibernateUtil.getSessionFactory().openSession();
        }

}
