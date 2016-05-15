package ru.mail.sanches.service.impl;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ru.mail.sanches.dao.ActorDao;
import ru.mail.sanches.dao.impl.ActorDaoImpl;
import ru.mail.sanches.entity.Actor;
import ru.mail.sanches.service.ActorService;
import java.util.List;

public class ActorServiceImpl implements ActorService {

        private ActorDao dao = new ActorDaoImpl();

        @Override
        public List<Actor> getAll() {
            return dao.getAll();
        }

        @Override
        public void save(List<Actor> data) {
            dao.save(data);
        }

        @Override
        public List<Actor> getByParameter(String key, String value) {
            Criterion criterion = Restrictions.eq(key, value);
            return dao.getByCriterion(criterion);
        }



}
