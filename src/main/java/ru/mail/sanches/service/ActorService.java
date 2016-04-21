package ru.mail.sanches.service;

import ru.mail.sanches.entity.Actor;
import java.util.List;

public interface  ActorService {

    List<Actor> getAll();

    void save(List<Actor> data);

    List<Actor> getByParameter(String key, String value);

}
