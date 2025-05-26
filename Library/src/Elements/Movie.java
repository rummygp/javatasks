package Elements;

public class Movie extends LibraryItem {
    private final String director;
    private final int duration;
    private static int movieCount = 0;

    public Movie(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
        movieCount++;
    }

    @Override
    public String toString() {
        return "Film: " + getTitle() + " | Reżyser: " + director + " | Czas trwania: " + duration + " min \n";
    }
    public static int getMovieCount() {
        return movieCount;
    }
}
