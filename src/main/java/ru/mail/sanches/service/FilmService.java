package ru.mail.sanches.service;

import ru.mail.sanches.entity.Film;
import java.util.List;

public interface FilmService {

    List<Film> getAll();

    void save(List<Film> data);

    List<Film> getByParameter(String key, String value);
}
