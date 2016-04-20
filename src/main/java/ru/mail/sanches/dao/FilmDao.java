package ru.mail.sanches.dao;

import org.hibernate.criterion.Criterion;
import ru.mail.sanches.entity.Film;

import java.util.List;

public interface FilmDao {

    Film getBtId (Integer id);

    List<Film> getAll();

    void save (Film film);

    void save (List<Film> films);

    List<Film> getByCriterion(Criterion criterion);

}
