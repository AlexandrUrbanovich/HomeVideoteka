package ru.mail.sanches.service.impl;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ru.mail.sanches.dao.FilmDao;
import ru.mail.sanches.dao.impl.FilmDaoImpl;
import ru.mail.sanches.entity.Film;
import ru.mail.sanches.service.FilmService;
import java.util.List;

public class FilmServiceImpl implements FilmService {

    private FilmDao dao = new FilmDaoImpl();


    @Override
    public List<Film> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(List<Film> data) {
        dao.save(data);
    }

    @Override
    public List<Film> getByParameter(String key, String value) {
        Criterion criterion = Restrictions.eq(key, value);
        return dao.getByCriterion(criterion);
    }
}
