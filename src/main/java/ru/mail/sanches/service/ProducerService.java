package ru.mail.sanches.service;

import ru.mail.sanches.entity.Producer;
import java.util.List;

public interface ProducerService {

    List<Producer> getAll();

    void save(List<Producer> data);

    List<Producer> getByParameter(String key, String value);
}
