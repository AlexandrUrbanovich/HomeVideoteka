package ru.mail.sanches.dao.impl;

import org.hibernate.criterion.Criterion;
import ru.mail.sanches.dao.FilmDao;
import ru.mail.sanches.entity.Film;

import java.util.List;

public class FilmDaoImpl implements FilmDao{
    @Override
    public Film getBtId(Integer id) {
        return null;
    }

    @Override
    public List<Film> getAll() {
        return null;
    }

    @Override
    public void save(Film film) {

    }

    @Override
    public void save(List<Film> films) {

    }

    @Override
    public List<Film> getByCriterion(Criterion criterion) {
        return null;
    }
}
