// Must be an ArrayList of the genre associated with a Movie
// Each String in the ArrayList must only contain lower case letters.
// The Genre class must contain the methods:
// String toString();
// boolean isGenre(String category);


import java.util.ArrayList;
import java.util.Scanner;

public class GenreClass {
    private ArrayList<String> genre;


    // copy constructor
    // SCANNER to read through genre ArrayList
    public GenreClass(GenreClass Genre) {
        this.genre = Genre.genre;
    }
    public GenreClass(String xxx) {
        genre = new ArrayList<String> ();
        Scanner myParser = new Scanner (xxx);
        myParser.useDelimiter(",");
        while (myParser.hasNext()) {
            genre.add(myParser.next().toLowerCase());
        }
    }


    // String toString();
    // Method toString() returns a String version of the information stored in the class
    @Override
    public String toString() {
        String myAnswer = "";
        for (String xxx: genre) {
            myAnswer += xxx;
        } return myAnswer;
    }


    // boolean isGenre(String category);
    // method isGenre() returns true if and if only category belongs to the ArrayList

    public boolean isGenre(String category) {
        for (String xxx: genre) {
            if (xxx.equals(category.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    // GETTER
    public ArrayList<String> getGenre() {
        return genre;
    }
}


