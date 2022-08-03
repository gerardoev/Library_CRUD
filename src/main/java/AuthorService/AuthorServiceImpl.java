package AuthorService;

import GenreService.GenreModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.SessionUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuthorServiceImpl implements AuthorServiceInt{
    SessionFactory factory;

    public AuthorServiceImpl(){
        this.factory = SessionUtil.getSession();
    }

    @Override
    public long createAuthor(String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long author_id = null;
        try {
            tx = session.beginTransaction();
            AuthorModel author = new AuthorModel();
            author.setName(name);
            session.save(author);
            tx.commit();
            author_id = author.getId();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Sesion cerrada");
            session.close();
        }
        return author_id;
    }

    @Override
    public AuthorModel getAuthor(String name) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from AuthorModel m where m.name = ?");
            query.setParameter(0, name);
            AuthorModel author = (AuthorModel) query.uniqueResult();
            return author;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public AuthorModel updateAuthor(long id, String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            AuthorModel author = (AuthorModel) session.get(AuthorModel.class, id);
            author.setName(name);
            session.update(author);
            tx.commit();
            return author;
        }catch(HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean deleteAuthor(long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            AuthorModel author = (AuthorModel) session.get(AuthorModel.class, id);
            session.delete(author);
            tx.commit();
            return true;
        }catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<AuthorModel> getAllAuthors() {
        SessionFactory factory = SessionUtil.getSession();
        Session session = factory.openSession();
        try {
            String sql = "from AuthorModel";
            Query query = session.createQuery(sql);
            List authorsQuery = query.list();
            ArrayList<AuthorModel> authors = new ArrayList<>();
            for(Iterator<AuthorModel> iterator = authorsQuery.iterator(); iterator.hasNext();){
                AuthorModel author = iterator.next();
                authors.add(author);
            }
            return authors;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
