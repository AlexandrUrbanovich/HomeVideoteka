package ru.mail.sanches;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import ru.mail.sanches.entity.Actor;
import ru.mail.sanches.entity.Film;
import ru.mail.sanches.entity.Producer;

public class HibernateUtil {
        private static final SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = new AnnotationConfiguration().addPackage("ru.mail.sanches.entity")
                        .addAnnotatedClass(Actor.class)
                        .addAnnotatedClass(Film.class)
                        .addAnnotatedClass(Producer.class)
                        .configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public static void close(){
            sessionFactory.close();
        }

}
