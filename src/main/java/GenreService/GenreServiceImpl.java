package GenreService;

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

public class GenreServiceImpl implements GenreServiceInt{
    SessionFactory factory;
    public GenreServiceImpl(){
        this.factory = SessionUtil.getSession();
    }
    @Override
    public long createGenre(String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long genre_id = null;
        try {
            tx = session.beginTransaction();
            GenreModel genre = new GenreModel();
            genre.setName(name);
            session.save(genre);
            tx.commit();
            genre_id = genre.getId();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Sesion cerrada");
            session.close();
        }
        return genre_id;
    }

    @Override
    public GenreModel readGenre(String name) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from GenreModel g where g.name = ?");
            query.setParameter(0, name);
            GenreModel genre = (GenreModel) query.uniqueResult();
            return genre;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public GenreModel updateGenre(long id, String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            GenreModel genre = (GenreModel) session.get(GenreModel.class, id);
            genre.setName(name);
            session.update(genre);
            tx.commit();
            return genre;
        }catch(HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean deleteGenre(long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            GenreModel genre = (GenreModel) session.get(GenreModel.class, id);
            session.delete(genre);
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

    public List<GenreModel> getAllGenres(){
        SessionFactory factory = SessionUtil.getSession();
        Session session = factory.openSession();
        try {
            String sql = "from GenreModel";
            Query query = session.createQuery(sql);
            List genresQuery = query.list();
            ArrayList<GenreModel> genres = new ArrayList<>();
            for(Iterator<GenreModel> iterator = genresQuery.iterator(); iterator.hasNext();){
               GenreModel genre = iterator.next();
               genres.add(genre);
            }
            return genres;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
