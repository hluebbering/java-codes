// Java program that works with the dataset called moviesDataset
// moviesDataset contains information about 600 movies from IMDb website
// The class called Movie stores the information about each movie in the given dataset
// New concepts: toString(), copy constructor, comparable, and Collections.sort()
// A Genre object must now be included in as a Movie member
// A new function must be added to the program in addition to the current file outputs,


// Hannah Luebbering
// September 2020



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static PrintWriter myOutPutFile;
    private static FileWriter XXX;
    private static ArrayList<MovieClass> movieList;
    private static Scanner keyboard;
    private static Scanner movieInput;

    // Creating separate lists grouping database's titles, Movies2005-2020, Documentary, Title-Year
    // private static String[] Titles = MovieClass.primaryTitle;;


    public static void main(String[] args) {

        // instantiate moviesList
        movieList = new ArrayList<MovieClass>();
        MovieClass XXX = new MovieClass("tt0492500", "movie", "Wide Awake", "Wide Awake", 2006, 79, "Documentary");
        movieList.add(XXX);


        // formatted input from FileReader using Scanner
        // get file name from command line

        String myfilename;
        if (args.length > 0) {
            myfilename = args[0];
        } else {
            // instantiate keyboard, prompt and read file name
            keyboard = new Scanner(System.in);
            System.out.print("Please enter the correct name of the file: ");
            myfilename = keyboard.next();
        }

        // open external input file to be read with Scanner class
        // opened file for input on Scanner movieInput

        try
        {
            movieInput = new Scanner(new FileReader(myfilename));
            movieInput.useDelimiter(",");
        } catch (FileNotFoundException e)
        {
            System.out.println("File not Found: " + myfilename);
            System.exit(2);
        } catch (Exception e)
        {
            System.out.println("Something weird happened:");
            System.exit(3);
        }

        while (movieInput.hasNext())
        {
            String myId = movieInput.next();
            String myType = movieInput.next();
            String myPtitle = movieInput.next();
            String myWtitle = movieInput.next();
            String myRdate = movieInput.next();
            int RDate;
            try{
                RDate= Integer.parseInt(myRdate);
            } catch(Exception e) {
                RDate=0;
            }
            String myMinutes = movieInput.next();
            int RMinutes;
            try{
                RMinutes=Integer.parseInt(myMinutes);

            } catch (Exception e) {
                RMinutes = 0;
            }


            String myGenre = movieInput.nextLine();

            // System.out.println(myId);

            movieList.add(new MovieClass(myId, myType, myPtitle, myWtitle,RDate,RMinutes, myGenre));



        }
        movieInput.close();


        // new file, must contain the all the movie information
        // but now printed in a sorted order as specified by the Movie comparator
        System.out.println("\n\nSorted list of movies:\n");
        // dumpyMovies();

        // sorts specified list according to the order induced by the specified comparator
        // Collections.sort(movieList, MovieClass.movieCompareStartYear);
        Collections.sort(movieList, MovieClass.movieCompareDate);



        // write text to an output file
        // TITLES
        String myFileName = "Titles.txt";
        try {
            myOutPutFile = new PrintWriter(new FileWriter(myFileName));
        } catch (IOException e) {
            System.out.println("Open error on output file <"+myFileName+">");
            System.exit(2);
        }
        // dump all the titles to the output file
        for (MovieClass xxx:movieList) {
            myOutPutFile.println(xxx.getPrimaryTitle() + ", "
                    + xxx.getOriginalTitle());
        }
        // close output file
        myOutPutFile.close();


        // MOVIES2005-2020
        myFileName = "Movies2005-2020.txt";
        try {
            myOutPutFile = new PrintWriter(new FileWriter(myFileName));
        } catch (IOException e) {
            System.out.println("Open error on output file <"+myFileName+">");
            System.exit(2);
        }
        // dump all the titles to the output file
        for (MovieClass xxx:movieList) {
            if (xxx.getStartYear() == (2005)) {
                myOutPutFile.println(xxx.gettConst() + ", "
                        + xxx.getTitleType() + ", "
                        + xxx.getPrimaryTitle() + ", "
                        + xxx.getOriginalTitle() + ", "
                        + xxx.getStartYear() + ", "
                        + xxx.getRuntimeMinutes() + ", "
                        + xxx.getGenres());
            }
        }
        // close output file
        myOutPutFile.close();



        // DOCUMENTARIES

        // sorts specified list according to the order induced by the specified comparator
        Collections.sort(movieList, MovieClass.movieCompareDate);

        myFileName = "Documentary.txt";
        try {
            myOutPutFile = new PrintWriter(new FileWriter(myFileName));
        } catch (IOException e) {
            System.out.println("Open error on output file <"+myFileName+">");
            System.exit(2);
        }
        // dump all the titles to the output file
        for (MovieClass xxx:movieList) {
            if (xxx.isGenre("Documentary"))
            {
                myOutPutFile.println(xxx.gettConst() + ", "
                        + xxx.getTitleType() + ", "
                        + xxx.getPrimaryTitle() + ", "
                        + xxx.getOriginalTitle() + ", "
                        + xxx.getStartYear() + ", "
                        + xxx.getRuntimeMinutes() + ", "
                        + xxx.getGenres());
            }
        }
        // close output file
        myOutPutFile.close();


        // TITLE-YEAR

        // sorts specified list according to the order induced by the specified comparator
        Collections.sort(movieList, MovieClass.movieCompareDate);

        myFileName = "Title-Year.txt";
        try {
            myOutPutFile = new PrintWriter(new FileWriter(myFileName));
        } catch (IOException e) {
            System.out.println("Open error on output file <"+myFileName+">");
            System.exit(2);
        }
        // dump all the titles to the output file
        for (MovieClass xxx:movieList) {
            myOutPutFile.println(xxx.getStartYear() + ", "
                    + xxx.getPrimaryTitle());
        }
        // close output file
        myOutPutFile.close();





    }
    private static void dumpyMovies() {
        for (Object xxx : movieList) {
            System.out.println(xxx.toString());
        }
    }


}