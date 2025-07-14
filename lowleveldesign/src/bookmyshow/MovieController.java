package bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    Map<City, List<Movie>> cityVsMovies = new HashMap<>();
    List<Movie> allMovies = new ArrayList<>();


    void addMovies(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    Movie getMovieByName(String movieName) {
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        System.out.println("Movie not found");
        return null;
    }


    List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.get(city);
    }
}
