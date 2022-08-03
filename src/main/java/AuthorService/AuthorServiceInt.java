package AuthorService;

import java.util.List;

public interface AuthorServiceInt {
    long createAuthor(String name);
    AuthorModel getAuthor(String name);
    AuthorModel updateAuthor(long id, String name);
    boolean deleteAuthor(long id);
    List<AuthorModel> getAllAuthors();
}
