package util;

import AuthorService.AuthorModel;
import BookService.BookModel;
import GenreService.GenreModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.awt.print.Book;


public class SessionUtil {
    private static SessionUtil sessionUtil = null;
    private SessionFactory sessionFactory;

    private SessionUtil(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public static SessionFactory getSession() {

        if(sessionUtil == null){
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(GenreModel.class);
                configuration.addAnnotatedClass(AuthorModel.class);
                configuration.addAnnotatedClass(BookModel.class);
                ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                SessionUtil newSession = new SessionUtil(configuration.buildSessionFactory(registry));
                SessionUtil.sessionUtil = newSession;
                return newSession.sessionFactory;
            } catch(Throwable ex){
                System.out.println("Failed to create sessionFactory object." + ex);
                return null;
            }
        }
        return sessionUtil.sessionFactory;
    }
}
