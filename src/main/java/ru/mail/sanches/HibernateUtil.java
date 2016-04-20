package ru.mail.sanches;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import ru.mail.sanches.entity.Actor;

public class HibernateUtil {
        private static final SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = new AnnotationConfiguration().addPackage("ru.mail.sanches.entity").addAnnotatedClass(Actor.class)
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
