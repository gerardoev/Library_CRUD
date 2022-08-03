package GenreService;

import BookService.BookModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Genre")
public class GenreModel implements Serializable {

    @Id
    @Column(name="genre_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE_GENRE")
    @SequenceGenerator(name="SEQUENCE_GENRE", sequenceName="SEQUENCE_GENRE", allocationSize=1)
    private long id;

    @Column(name="genre_name")
    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<BookModel> books;

    public GenreModel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenreModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
