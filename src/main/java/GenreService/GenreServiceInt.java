package GenreService;

import java.util.List;

public interface GenreServiceInt {
    long createGenre(String name);
    GenreModel readGenre(String name);
    GenreModel updateGenre(long id, String name);
    boolean deleteGenre(long id);

    List<GenreModel> getAllGenres();
}
