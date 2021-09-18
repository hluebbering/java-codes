// Insertion Sort
// a sorting method where the sorted values locate to the low end of the array,
// and the unsorted values locate to the high end
// expected running time is O(n^2) compares and data movements
// best case is O(n): occurs for no movements of data within the array
//
// Hannah Luebbering
// December 2020

import java.util.LinkedList;
import java.util.ListIterator;

import java.util.ArrayList;

public class InsertionSort {

    // define insertion count
    private static int ICount;

    public static int getICount(){
        return ICount;
    }

    // method to Insertion Sort a generic type  (that extends the interface Relateable)
    public static <T extends Relateable> ArrayList<T> InsertionSort(ArrayList<T> myAL){

        // create a LL
        LinkedList<T> mylist = new LinkedList<T>();

        // initialize ICount
        ICount = 0;

        // walk down the myAL and insert each element into the sorted LL
        for(T XXX: myAL){
            insert(mylist, XXX);
        }

        // repackage AL from the LL and return it
        return myAL;

    }

    // method to insert a new element myobj into a sorted linked list "mylist"
    // need to place new element into its proper place within the sorted subarray
    public static  <T extends Relateable> void insert(LinkedList<T> mylist, T myobj) {

        //if myList is empty just add myobj and return
        if (mylist.isEmpty()) {
            ICount++;
            mylist.add(myobj);
            return;
        }

        // use a loop to traverse the LL
        // start at the beginning of the LL (at the smallest T) and
        // find where myObj should go
        ListIterator current = mylist.listIterator();
        while(current.hasNext()){
            ICount++;

            // get the value and advance the iterator
            T temp = (T)(current.next());

            // figure out out when to add the new element
            // shifting all of the elements to the right
            // -- until we encounter the first element we don't have to shift
            if (temp.isLessThan(myobj)){
                continue;
            } else{
                current.add(myobj); // add on the list iterator but where?
                return;
            }
        }

        // if I get here, then I should add myobj at the end of the list
        ICount++;
        mylist.addLast(myobj);
        return;
    }

    // method to dump out what is in the LL
    // debugging tool
    private static <T> void dump (LinkedList<T> mylist){
        ListIterator<T> current = mylist.listIterator();
        for(int i=0; i< Math.min(15, mylist.size()); i++){

            System.out.println((T)(current.next()).toString());
        }
    }
}