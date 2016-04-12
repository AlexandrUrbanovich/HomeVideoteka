package ru.mail.sanches;

import ru.mail.sanches.entity.Actor;
import ru.mail.sanches.entity.HibrUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        Actor actor = new Actor();
        actor.setFirstName("Alexandr");
        actor.setLastName("Urbanovich");
        actor.setDate(new Date());

        EntityManager em = HibrUtil.getManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(actor);
        em.flush();
        tx.commit();

        System.out.println(actor);

    }
}
