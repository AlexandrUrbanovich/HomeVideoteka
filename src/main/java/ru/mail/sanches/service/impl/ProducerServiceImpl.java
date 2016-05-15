package ru.mail.sanches.service.impl;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ru.mail.sanches.dao.ProducerDao;
import ru.mail.sanches.dao.impl.ProducerDaoImpl;
import ru.mail.sanches.entity.Producer;
import ru.mail.sanches.service.ProducerService;
import java.util.List;

public class ProducerServiceImpl implements ProducerService {

    private ProducerDao dao = new ProducerDaoImpl();

    @Override
    public List<Producer> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(List<Producer> data) {
        dao.save(data);
    }

    @Override
    public List<Producer> getByParameter(String key, String value) {
        Criterion criterion = Restrictions.eq(key, value);
        return dao.getByCriterion(criterion);
    }
}
