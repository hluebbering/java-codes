// Lab #5 – CSC112
// use provided method to read from dataset and fill an ArrayList with lilly objects,
// generate simple test cases
// develop three sorting algorithms for an array of objects:
// (i.) merge sort, (ii.) bubble sort, and (iii.) insertion sort
// incorporate an interface

// Hannah Luebbering
// December 9, 2020


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    // declaration of ArrayList
    private static ArrayList<Lilly> Flowers;

    public static void main(String[] args) {

        // How many data points do you want
        // formatted input from FileReader using Scanner
        System.out.print("How large of an array do you want to sort? ");
        Scanner keyboard = new Scanner(System.in);
        int FileSize = keyboard.nextInt();

        // create data set
        Flowers = CreateData(FileSize);

        // sort data set
        ArrayList<Lilly> MFlowers = MergeSort.MergeSort(Flowers); // Merge Sort
        ArrayList<Lilly> NFlowers = BubbleSort.Bubble(Flowers); // Bubble Sort
        ArrayList<Lilly> IFlowers = InsertionSort.InsertionSort(Flowers); // Insertion Sort

        System.out.println();
        System.out.println("For list size of " + Flowers.size());
        System.out.println("     Bubble sort number of steps: " + BubbleSort.getBcount());
        System.out.println("     Merge sort number  of steps: " + MergeSort.getMcount());
        System.out.println("     Insertion sort number of steps:  " + InsertionSort.getICount());
    }

    // **************
    // Utility for debugging
    public static void Dump(ArrayList<Lilly> tFlowers){
        for( Lilly XXX : tFlowers){
            System.out.println(XXX.toString());
        }
    }

    // ******************
    // Provided method to read from dataset and fill an ArrayList with lilly objects
    // Read from the dataset fisherIris.csv
    // Randomly chooses n samples from dataset
    // such that n is the user defined number of data points
    private static ArrayList<Lilly> CreateData(int testSize){

        ArrayList<Lilly> FisherData = ReadFromFile("fisherIris.csv");
        System.out.println();
        System.out.print("Fisher data file loaded ...");
        return GenerateTestSet(FisherData, testSize);
    }

    // *******************
    // Generate simple test cases:
    // Create the test file of size tsize from the Fisher Iris data set
    private static ArrayList<Lilly> GenerateTestSet(ArrayList<Lilly> fisher, int tsize){

        ArrayList<Lilly> testSet = new ArrayList<Lilly>();
        for (int i=0; i< tsize; i++){

            // correct way to generate random number in range [0, fisher.size()-1]  in Java
            int randfisher = ThreadLocalRandom.current().nextInt(0,fisher.size());

            testSet.add( fisher.get(randfisher) );
        }

        System.out.println(" test file of size " + tsize + " created.");
        return testSet;
    }

    // ****************
    // Provided method to read from dataset and fill an ArrayList with lilly objects
    // Open external input file to be read with Scanner class
    private static ArrayList<Lilly> ReadFromFile(String fname){

        // Arraylist that will hold Fisher Iris data set
        // this data set will be read in from the comma separated file fname
        ArrayList<Lilly> basefile = new ArrayList<Lilly>();

        Scanner DataFile;
        try{
            DataFile = new Scanner(new FileReader(fname));
            DataFile.useDelimiter(",");

            // throw away first line
            DataFile.nextLine();

        } catch(Exception e){
            System.out.println("Something is horribly wrong with input file");
            System.exit(22);
            return null;
        }

        double sl, sw, pl, pw;
        String category;

        // Opened file for input on Scanner DataFile
        while (DataFile.hasNext()) {
            try {
                sl = DataFile.nextDouble();
                sw = DataFile.nextDouble();
                pl = DataFile.nextDouble();
                pw = DataFile.nextDouble();
                category = DataFile.nextLine();
            } catch (Exception e) {
                System.out.println("Fisher data is corrupted");
                System.exit(33);
                return null;
            }

            basefile.add(new Lilly(sl, sw, pl, pw, category));
        }

        DataFile.close();

        return basefile;

    }

}
