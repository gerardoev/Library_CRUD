import AuthorService.AuthorServiceImpl;
import BookService.BookModel;
import BookService.BookServiceImpl;
import Controller.Controller;
import GenreService.GenreModel;
import GenreService.GenreServiceImpl;
import org.hibernate.SessionFactory;
import util.SessionUtil;

import javax.naming.ldap.Control;
import java.awt.print.Book;

public class HibernateTrainingMain {
    public static void main(String[] args) {
        SessionFactory sf = SessionUtil.getSession();
        if(sf != null) {
            System.out.println("Sesion establecida!");
            GenreServiceImpl genreService = new GenreServiceImpl();
            //GenreModel ngenre = new GenreModel();
            //ngenre.setName("Comedia");
            //System.out.println(genreService.createGenre(ngenre));
            //System.out.println(genreService.updateGenre(21, ngenre));
            //genreService.readGenre("Terror");
            //System.out.println(genreService.deleteGenre(21));
            //genreService.readGenres();

            AuthorServiceImpl authorService = new AuthorServiceImpl();
            //authorService.createAuthor("Sergio Villa");
            //authorService.getAuthor("Gerardo Erick");
            //AuthorModel newAuthor = new AuthorModel();
            //newAuthor.setName("Gerardo Villa");
            //authorService.updateAuthor(1, newAuthor);
            //authorService.deleteAuthor(1);

            BookServiceImpl bookService = new BookServiceImpl();
            //BookModel nbook = new BookModel();
            //nbook.setName("El proceso");
            //nbook.setGenre(genreService.readGenre("Comedia"));
            //nbook.setAuthor(authorService.getAuthor("Sergio Villa"));
            //bookService.createBook(nbook);

        }

    }
}
