package AuthorService;

import BookService.BookModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Author")
public class AuthorModel implements Serializable {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE_AUTHOR")
    @SequenceGenerator(name="SEQUENCE_AUTHOR", sequenceName="SEQUENCE_AUTHOR", allocationSize=1)
    private long id;
    @Column(name = "author_name")
    private String name;
    @OneToMany(mappedBy = "author")
    private Set<BookModel> books;

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
        return "AuthorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
