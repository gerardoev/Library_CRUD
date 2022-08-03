package Controller;

import AuthorService.AuthorModel;
import AuthorService.AuthorServiceImpl;
import BookService.BookModel;
import BookService.BookServiceImpl;
import GenreService.GenreModel;
import GenreService.GenreServiceImpl;
import View.BasicAbstractUI;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller {
    private BasicAbstractUI view;
    private AuthorServiceImpl authorService;
    private GenreServiceImpl genreService;
    private BookServiceImpl bookService;

    public Controller(BasicAbstractUI view, AuthorServiceImpl authorService, GenreServiceImpl genreService, BookServiceImpl bookService){
        this.authorService = authorService;
        this.genreService = genreService;
        this.bookService = bookService;
        this.view = view;
    }

    public void getAuthorAllItems(){
        ArrayList<AuthorModel> authors = (ArrayList<AuthorModel>) authorService.getAllAuthors();
        int rowSize = authors.size();
        String[][] authorAllItems = new String[rowSize][2];
        int i = 0;
        for(Iterator<AuthorModel> iterator = authors.iterator(); iterator.hasNext();){
            AuthorModel author = iterator.next();
            authorAllItems[i][0] = String.valueOf(author.getId());
            authorAllItems[i][1] = author.getName();
            i++;
        }
        view.setTable(authorAllItems);
    }

    public void createAuthor(String name){
        authorService.createAuthor(name);
    }

    public void updateAuthor(long id, String name){
        authorService.updateAuthor(id, name);
    }

    public void deleteAuthor(long id){
        authorService.deleteAuthor(id);
    }

    public void getGenreAllItems(){
        ArrayList<GenreModel> genres = (ArrayList<GenreModel>) genreService.getAllGenres();
        int rowSize = genres.size();
        String[][] genreAllItems = new String[rowSize][2];
        int i = 0;
        for(Iterator<GenreModel> iterator = genres.iterator(); iterator.hasNext();){
            GenreModel genre = iterator.next();
            genreAllItems[i][0] = String.valueOf(genre.getId());
            genreAllItems[i][1] = genre.getName();
            i++;
        }
        view.setTable(genreAllItems);
    }

    public void createGenre(String name){
        this.genreService.createGenre(name);
    }

    public void updateGenre(long id, String name) {
        genreService.updateGenre(id, name);
    }
    public void deleteGenre(long id){
        genreService.deleteGenre(id);
    }

    public void getBooksAllItems() {
        ArrayList<BookModel> books = (ArrayList<BookModel>) bookService.gettAllBooks();
        int rowSize = books.size();
        String[][] bookAllItems = new String[rowSize][4];
        int i = 0;
        for(Iterator<BookModel> iterator = books.iterator(); iterator.hasNext();){
            BookModel book = iterator.next();
            bookAllItems[i][0] = String.valueOf(book.getId());
            bookAllItems[i][1] = book.getName();
            AuthorModel author = book.getAuthor();
            GenreModel genre = book.getGenre();
            if(author != null){
                bookAllItems[i][2] = book.getAuthor().getName();
            }
            if(genre != null){
                bookAllItems[i][3] = book.getGenre().getName();
            }
            i++;
        }
        view.setTable(bookAllItems);
    }

    public void createBook(String name, String genre, String author) {
        bookService.createBook(name, genre, author);
    }

    public BookModel getBook(long id){
        return bookService.getBook(id);
    }

    public void updateBook(long id, String name, String genre_name, String author_name){
        bookService.updateBook(id, name, genre_name, author_name);
    }

    public void deletebook(long id){
        bookService.deleteBook(id);
    }

    public void searchBookByAuthor(String author){
        ArrayList<BookModel> books = (ArrayList<BookModel>) bookService.getAuhtorBooks(author);
        int rowSize = books.size();
        String[][] booksRow = new String[rowSize][4];
        int i = 0;
        for(Iterator<BookModel> iterator = books.iterator(); iterator.hasNext();){
            BookModel book = iterator.next();
            booksRow[i][0] = String.valueOf(book.getId());
            booksRow[i][1] = book.getName();
            AuthorModel authorM = book.getAuthor();
            GenreModel genreM = book.getGenre();
            if(authorM != null){
                booksRow[i][2] = book.getAuthor().getName();
            }
            if(genreM != null){
                booksRow[i][3] = book.getGenre().getName();
            }
            i++;
        }
        view.setTable(booksRow);
    }

    public void searchBookByGenre(String genre){
        ArrayList<BookModel> books = (ArrayList<BookModel>) bookService.getGenreBooks(genre);
        int rowSize = books.size();
        String[][] booksRow = new String[rowSize][4];
        int i = 0;
        for(Iterator<BookModel> iterator = books.iterator(); iterator.hasNext();){
            BookModel book = iterator.next();
            booksRow[i][0] = String.valueOf(book.getId());
            booksRow[i][1] = book.getName();
            AuthorModel authorM = book.getAuthor();
            GenreModel genreM = book.getGenre();
            if(authorM != null){
                booksRow[i][2] = book.getAuthor().getName();
            }
            if(genreM != null){
                booksRow[i][3] = book.getGenre().getName();
            }
            i++;
        }
        view.setTable(booksRow);
    }

    public void searchBookByName(String name){
        ArrayList<BookModel> books = (ArrayList<BookModel>) bookService.getNameBooks(name);
        int rowSize = books.size();
        String[][] booksRow = new String[rowSize][4];
        int i = 0;
        for(Iterator<BookModel> iterator = books.iterator(); iterator.hasNext();){
            BookModel book = iterator.next();
            booksRow[i][0] = String.valueOf(book.getId());
            booksRow[i][1] = book.getName();
            AuthorModel authorM = book.getAuthor();
            GenreModel genreM = book.getGenre();
            if(authorM != null){
                booksRow[i][2] = book.getAuthor().getName();
            }
            if(genreM != null){
                booksRow[i][3] = book.getGenre().getName();
            }
            i++;
        }
        view.setTable(booksRow);
    }
}
