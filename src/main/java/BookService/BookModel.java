package BookService;

import AuthorService.AuthorModel;
import GenreService.GenreModel;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Book")
public class BookModel implements Serializable {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE_BOOK")
    @SequenceGenerator(name="SEQUENCE_BOOK", sequenceName="SEQUENCE_BOOK", allocationSize=1)
    private Long id;
    @Column(name = "book_name")
    private String name;
    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private AuthorModel author;

    @ManyToOne
    @JoinColumn(name="genre_id", nullable = false)
    private GenreModel genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public GenreModel getGenre() {
        return genre;
    }

    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
