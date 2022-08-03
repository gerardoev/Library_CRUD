package BookService;

import AuthorService.AuthorModel;
import GenreService.GenreModel;

import java.util.List;

public interface BookServiceInt {
    long createBook(String name, String genre_name, String author_name);
    List<BookModel> gettAllBooks();
    BookModel getBook(long id);
    BookModel updateBook(long id, String name, String genre_name, String author_name);
    void deleteBook(long id);
}
