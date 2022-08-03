package BookService;

import AuthorService.AuthorModel;
import AuthorService.AuthorServiceImpl;
import GenreService.GenreModel;
import GenreService.GenreServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.SessionUtil;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookServiceImpl implements BookServiceInt{
    SessionFactory factory;

    public BookServiceImpl(){
        this.factory = SessionUtil.getSession();
    }


    @Override
    public long createBook(String name, String genre_name, String author_name) {
        Session session = factory.openSession();
        Transaction tx = null;
        Long book_id = null;
        try {
            tx = session.beginTransaction();
            BookModel book= new BookModel();
            book.setName(name);

            AuthorServiceImpl authorService = new AuthorServiceImpl();
            GenreServiceImpl genreService = new GenreServiceImpl();

            AuthorModel author = authorService.getAuthor(author_name);
            GenreModel genre = genreService.readGenre(genre_name);

            book.setAuthor(author);
            book.setGenre(genre);

            session.save(book);
            tx.commit();
            book_id = book.getId();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Sesion cerrada");
            session.close();
        }
        return book_id;
    }

    @Override
    public List<BookModel> gettAllBooks() {
        SessionFactory factory = SessionUtil.getSession();
        Session session = factory.openSession();
        try {
            String sql = "from BookModel";
            Query query = session.createQuery(sql);
            List booksQuery = query.list();
            ArrayList<BookModel> books = new ArrayList<>();
            for(Iterator<BookModel> iterator = booksQuery.iterator(); iterator.hasNext();){
                BookModel book = iterator.next();
                books.add(book);
            }
            return books;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public BookModel getBook(long id) {
        Session session = factory.openSession();
        try{
            BookModel book = (BookModel) session.get(BookModel.class, id);
            return book;
        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public BookModel updateBook(long id, String name, String genre_name, String author_name) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            BookModel book = (BookModel) session.get(BookModel.class, id);
            book.setName(name);
            AuthorServiceImpl authorService = new AuthorServiceImpl();
            GenreServiceImpl genreService = new GenreServiceImpl();
            book.setGenre(genreService.readGenre(genre_name));
            book.setAuthor(authorService.getAuthor(author_name));
            session.update(book);
            tx.commit();
            return book;
        }catch(HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deleteBook(long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            BookModel book = (BookModel) session.get(BookModel.class, id);
            System.out.println(book);
            session.delete(book);
            tx.commit();
        }catch(HibernateException e){
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<BookModel> getAuhtorBooks(String author){
        SessionFactory factory = SessionUtil.getSession();
        Session session = factory.openSession();
        try {
            String sql = "from BookModel b INNER JOIN b.author a WHERE a.name = ?";
            Query query = session.createQuery(sql);
            query.setParameter(0, author);
            List<Object[]> booksQuery = query.getResultList();
            ArrayList books = new ArrayList<>();
            for(Iterator iterator = booksQuery.iterator(); iterator.hasNext();){
                Object[] object = (Object[]) iterator.next();
                BookModel book = (BookModel)object[0];
                books.add(book);
            }
            return books;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<BookModel> getGenreBooks(String genre){
        SessionFactory factory = SessionUtil.getSession();
        Session session = factory.openSession();
        try {
            String sql = "from BookModel b INNER JOIN b.genre g WHERE g.name = ?";
            Query query = session.createQuery(sql);
            query.setParameter(0, genre);
            List<Object[]> booksQuery = query.getResultList();
            ArrayList books = new ArrayList<>();
            for(Iterator iterator = booksQuery.iterator(); iterator.hasNext();){
                Object[] object = (Object[]) iterator.next();
                BookModel book = (BookModel)object[0];
                books.add(book);
            }
            return books;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<BookModel> getNameBooks(String name){
        SessionFactory factory = SessionUtil.getSession();
        Session session = factory.openSession();
        try {
            String sql = "from BookModel b WHERE b.name = ?";
            Query query = session.createQuery(sql);
            query.setParameter(0, name);
            List booksQuery = query.getResultList();
            ArrayList books = new ArrayList<>();
            for(Iterator iterator = booksQuery.iterator(); iterator.hasNext();){
                BookModel book = (BookModel) iterator.next();
                books.add(book);
            }
            return books;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
