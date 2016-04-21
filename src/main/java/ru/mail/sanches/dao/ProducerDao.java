package ru.mail.sanches.dao;


import org.hibernate.criterion.Criterion;
import ru.mail.sanches.entity.Producer;

import java.util.List;

public interface ProducerDao {

    Producer getBtId (Integer id);

    List<Producer> getAll();

    void save(Producer producer);

    void save(List<Producer> producers);

    List<Producer> getByCriterion(Criterion criterion);

}
