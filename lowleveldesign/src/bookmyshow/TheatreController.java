package bookmyshow;

import java.util.*;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatres;

    public TheatreController() {
        this.cityVsTheatre = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {
        allTheatres.add(theatre);
        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }


    Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatre.get(city);

        for (Theatre theatre : theatres) {
            List<Show> givenShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for (Show show : shows) {
                if (show.movie.getMovieId() == movie.getMovieId()) {
                    givenShows.add(show);
                }
            }
            if (!givenShows.isEmpty()) {
                theatreVsShows.put(theatre, givenShows);
            }
        }
        return theatreVsShows;
    }
}
