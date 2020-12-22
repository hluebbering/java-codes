// Class to store the information about each movie in the given dataset
// A Genre object must now be included in as a Movie member
// A comparable must be included in the Movie class

// Hannah Luebbering
// September 2020

import java.util.Comparator;
public class MovieClass {

    // class members
    private String tConst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private int startYear;
    private int runtimeMinutes;
    private GenreClass genres;


    // copy constructor
    public MovieClass(MovieClass Movie) {
        this.tConst = Movie.tConst;
        this.titleType = Movie.titleType;
        this.primaryTitle = Movie.primaryTitle;
        this.originalTitle = Movie.originalTitle;
        this.startYear = Movie.startYear;
        this.runtimeMinutes = Movie.runtimeMinutes;
        this.genres = Movie.genres;
    }

    public MovieClass(String tConst, String titleType, String primaryTitle, String originalTitle,
                      int startYear, int runtimeMinutes, String genres) {
        this.tConst=tConst;
        this.titleType=titleType;
        this.primaryTitle=primaryTitle;
        this.originalTitle=originalTitle;
        this.startYear=startYear;
        this.runtimeMinutes=runtimeMinutes;
        this.genres=new GenreClass(genres);
    }


    // standard toString method to help with debugging
    @Override
    public String toString() {
        return this.tConst + "; " + this.titleType + "; " + this.primaryTitle +
                "; " + this.originalTitle + "; " + this.startYear + "; " +
                this.runtimeMinutes + "; " + this.genres.toString();
    }

    // various getters and setters
    public String gettConst() {
        return tConst; }
    public void settConst(String tConst) {
        this.tConst = tConst; }


    public String getPrimaryTitle() {
        return primaryTitle; }
    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle; }

    public String getGenres() {
        return genres.toString(); }

    public boolean isGenre(String xxx) {
        return genres.isGenre(xxx);
    }

    public int getStartYear() {
        return startYear;
    }

    public String getTitleType() {
        return titleType;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }


    // implementation of (interface) Comparator for MovieClass where the
    // comparison is based on the logic:
    // if the release date of MovieA preceeds the release date of MovieB then MovieA < MovieB
    // if the release date of MovieA equals the release date of MovieB then MovieA < MovieB
    // if and only if the title of MovieA preceeds the the title of MovieB alphabetically.
    // otherwise, we have MovieB > MovieB.


    // instantiate movieCompareDate constructor and define compare()
    public static Comparator<MovieClass> movieCompareDate  = new Comparator<MovieClass>() {
        @Override
        public int compare(MovieClass movie1, MovieClass movie2) {
            return movie2.startYear - movie1.startYear;
        }
    };

}