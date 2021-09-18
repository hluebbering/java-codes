// Bubble Sort Class
// Method sorts the elements by linearly moving through the list
// After a pass, the largest value "bubbles" up the ArrayList
// Bubble sorting repeats for (n-1) passes


import java.util.ArrayList;

public class BubbleSort {

    // Used to count number of steps
    private static int Bcount = 0;

    // Getter
    public static int getBcount(){
        return Bcount;
    }

    // Setter
    public static void resetBcount(){
        Bcount = 0;
    }

    // Simple Bubble Sort -- O(n^2)
    // Requires isLessThan from interface Relateable
    // Uses a generic class T which extends Relateable
    public static <T extends Relateable> ArrayList<T> Bubble(ArrayList<T>  A){

        // Depth of split levels:
        // number of times n can be halved while value is greater than 1
        if (A.size() <= 1) return A;

        // Each pass of the bubbling phase performs n-1 comparisons and n-1 exchanges
        // After n-1 passes, the method terminates
        for(int passes = 0; passes < A.size()-1; passes++){

            for(int index = 0; index < A.size() - passes - 1; index++){

                Bcount++;
                if (A.get(index).isLessThan(A.get(index + 1))){
                    T temp = A.get(index + 1);
                    A.set(index + 1, A.get(index));
                    A.set(index, temp);
                }

            }
        }

        return A;
    }

}
