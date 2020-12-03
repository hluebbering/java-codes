// Merge Sort Algorithm
//
// Tasks regarding the merge sort:
// 1. Write MergeSort method using the specified signature,
// 2. Write a recursive RMergeSort method using the specified signature,
// 3. Write the Merge method.

import java.util.ArrayList;

public class MergeSort {

    private static int Mcount = 0;

    // Getter
    public static int getMcount(){
        return Mcount;
    }

    // Merge Sort --  O(nlog2(n))
    // Requires isLessthan from interface Relateable
    // Uses a generic T which extends Relateable

    // Public signature
    // This nonrecursive part takes care of small lists
    public static <T extends Relateable> ArrayList<T> MergeSort(ArrayList<T> A){
        Mcount++;
        if (A.size() <= 1) {return A;}
        return RMergeSort(A);
    }

    // Recursive RMergeSort method--
    // Private signature for the recursive part
    // Requires isLessthan from interface Relateable
    // Uses a generic T which extends Relateable
    private static <T extends Relateable> ArrayList<T> RMergeSort(ArrayList<T> A){

        // Middle index to divide the ArrayList into two halves
        int mid = A.size() / 2;

        // Create two temporary arrays:
        ArrayList<T> B = new ArrayList<>(); // first half
        ArrayList<T> C = new ArrayList<>(); // second half

        for(int i = 0; i < mid; i++) {
            B.add(A.get(i));
        }
        for(int i = mid; i < A.size(); i++) {
            C.add(A.get(i));
        }

        // Call mergeSort for first half:
        B = MergeSort(B);

        // Call mergeSort for second half:
        C = MergeSort(C);

        // Merge the two halves sorted:
        return Merge(B,C);
    }

    // Merge method-- merge A and B routine
    // Requires isLessthan from interface Relateable
    // Uses a generic T which extends Relateable
    private static <T extends Relateable> ArrayList<T> Merge(ArrayList<T> A, ArrayList<T> B){
        ArrayList<T> C = new ArrayList<>();
        int j = 0;
        int k = 0;

        // Compares the elements of both sub-arrays one by one
        while(j < A.size() && k < B.size()) {
            if (A.get(j).isLessThan(B.get(k))) {
                C.add(A.get(j));
                j++;
            }
            else{
                C.add(B.get(k));
                k++;
            }
        }
        while(j < A.size()) {
            C.add(A.get(j));
            j++;
        }
        while(k < B.size()) {
            C.add(B.get(k));
            k++;
        }

        return C; // sorted array
    }

}