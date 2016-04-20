package ru.mail.sanches.dao;

import org.hibernate.criterion.Criterion;
import ru.mail.sanches.entity.Actor;

import java.util.List;

/**
 * Created by Александр on 19.04.2016.
 */
public interface ActorDao {

        Actor getById(Integer id);

        List<Actor> getAll();

        void save(Actor actor);

        void save(List<Actor> actors);

        List<Actor> getByCriterion(Criterion criterion);

}
