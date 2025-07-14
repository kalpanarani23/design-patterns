package bookmyshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    private void createBooking(City userCity, String movieName) {
        //1. search movie by location
        List<Movie> movies = movieController.getMoviesByCity(userCity);


        //2. select the movie you want to watch.
        Movie interestedMovie = null;

        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all the shows this movie.
        Map<Theatre, List<Show>> showTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested.
        Map.Entry<Theatre, List<Show>> entry = showTheatreWise.entrySet().iterator().next();
        List<Show> runningShow = entry.getValue();
        Show interestedShow = runningShow.get(0);

        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBooked();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);

            //start payment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            System.out.println("seat already booked, try again");
            return;
        }
        System.out.println("BOOKING SUCCESSFUL");
    }

    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createTheatre() {
        Movie movie1 = movieController.getMovieByName("AVENGERS");
        Movie movie2 = movieController.getMovieByName("ME-BEFORE-YOU");
        Theatre inox = new Theatre();
        inox.setTheatreId(1);
        inox.setScreens(createScreen());
        inox.setCity(City.BANGALORE);
        List<Show> shows = new ArrayList<>();
        Show inoxMorningSHow = createShow(1, inox.getScreens().get(0), movie1, 8);
        Show inoxEveningSHow = createShow(2, inox.getScreens().get(0), movie1, 16);
        shows.add(inoxEveningSHow);
        shows.add(inoxMorningSHow);
        inox.setShows(shows);

        Theatre pvr = new Theatre();
        pvr.setTheatreId(2);
        pvr.setScreens(createScreen());
        pvr.setCity(City.BANGALORE);
        List<Show> showss = new ArrayList<>();
        Show pvrMorningSHow = createShow(1, inox.getScreens().get(0), movie2, 8);
        Show pvrEveningSHow = createShow(2, inox.getScreens().get(0), movie2, 16);
        showss.add(pvrMorningSHow);
        showss.add(pvrEveningSHow);
        inox.setShows(showss);

        theatreController.addTheatre(inox, City.BANGALORE);
    }


    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        //1-40 :SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41-70 : GOLD
        for (int i = 41; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }
        return seats;
    }


    private Show createShow(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setShowStartTime(showStartTime);
        return show;
    }


    private void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDurationInMinutes(128);
        avengers.setLanguage(List.of("Hindi", "English"));


        Movie meBeforeYou = new Movie();
        meBeforeYou.setMovieId(2);
        meBeforeYou.setMovieName("ME-BEFORE-YOU");
        meBeforeYou.setMovieDurationInMinutes(110);
        meBeforeYou.setLanguage(List.of("Hindi", "English"));


        movieController.addMovies(avengers, City.DELHI);
        movieController.addMovies(avengers, City.BANGALORE);
        movieController.addMovies(meBeforeYou, City.DELHI);
        movieController.addMovies(meBeforeYou, City.BANGALORE);
    }


    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.BANGALORE, "ME-BEFORE-YOU");
        bookMyShow.createBooking(City.DELHI, "ME-BEFORE-YOU");
//        bookMyShow.createBooking(City.BANGALORE, "ME-BEFORE-YOU");
    }

}
