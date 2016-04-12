package ru.mail.sanches.entity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibrUtil {
    private static EntityManager manager;

    static{
        manager = Persistence.createEntityManagerFactory("simple").createEntityManager();
    }
    private HibrUtil(){}

    public static EntityManager getManager(){
        return manager;
    }
}
