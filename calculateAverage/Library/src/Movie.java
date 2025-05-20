public class Movie extends LibraryItem{
    private String director;
    private int duration;
    private static int movieCount = 0;

    public Movie(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
        movieCount++;
    }

    @Override
    public String toString() {
        return "Film: " + title + " | Reżyser: " + director + " | Czas trwania: " + duration + " min \n";
    }
    public static int getMovieCount() {
        return movieCount;
    }
}
