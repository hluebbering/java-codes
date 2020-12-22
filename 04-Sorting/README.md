Lab 5. Sorting Algorithms 
================

[![Badge](https://79e2hdgqbf59.runkit.sh)](https://git.io/gradientbadge)
[![Badge](https://pcylahiqejai.runkit.sh)](https://git.io/gradientbadge)
[![Badge](https://u7qa58vvcots.runkit.sh)](https://git.io/gradientbadge)

## Insertion Sort :zap:

### Background

**Definition.** a Java sorting method where the sorted values locate to
the low end of the array, and the unsorted values locate to the high
end. There are
![formula](https://render.githubusercontent.com/render/math?math=n-1)
passes over the array, with a new unsorted value inserted each time

  - ![\#FFFACD](https://placehold.it/15/FFFACD?text=+) expected running
    time is
    ![formula](https://render.githubusercontent.com/render/math?math=O\(n%5E2\))
    compares and data movements –most compares will lead to movement of
    a data value

  - ![\#FFBBFF](https://placehold.it/15/FFBBFF?text=+) best case running
    time performance is
    ![formula](https://render.githubusercontent.com/render/math?math=O\(n\))
    comparisons –occurs for no movements of data within the array

  - ![\#458B74](https://placehold.it/15/458B74?text=+) therefore, it’s
    best to implement insertion sort on data that is nearly ordered

 

#### Show how Insertion Sort acts on the following List:

``` java
list X: 7 5 4 6 8 2
```

  - Iterate through the array
  - Shifting all of the elements to the right until we encounter the
    first element we don’t have to shift
  - Place the new element into its proper place within the sorted
    subarray
    

![](equation.svg)

 

### Java Methods

#### Method to Insertion Sort a generic type that extends the interface Relateable

1.  create a LinkedList
2.  initialize ICount
3.  walk down ArrayList and insert each element into sorted LinkedList
4.  repackage and return ArrayList
5.  method to insert a new element myObj into a sorted LinkedList
      - use a loop to traverse LinkedList
      - begin with first element (smallest T) and find where myObj
        should go
6.  debugging tool and method to dump out content in LinkedList

 

### Code Output

#### Execution Times

At the worst case scenario for the algorithm, the whole array is
descending. This is because in each iteration, we’ll have to move the
whole sorted list by 1, which is
![formula](https://render.githubusercontent.com/render/math?math=O\(n\)).
We have to do this for each element in every array, which means it’s
going to be bounded by
![formula](https://render.githubusercontent.com/render/math?math=O\(n%5E2\)).

-----

## Bubble Sort :thought_balloon:

### Background

**Definition.** Bubble sort checks and rechecks the relation between
each component of the list. The method sorts the
![formula](https://render.githubusercontent.com/render/math?math=n)
elements by linearly moving through the list

  - ![\#C1CDC1](https://placehold.it/15/C1CDC1?text=+) where each pass
    completes
    ![formula](https://render.githubusercontent.com/render/math?math=n-1)
    comparisons and
    ![formula](https://render.githubusercontent.com/render/math?math=n-1)
    exchanges.

  - ![\#8470FF](https://placehold.it/15/8470FF?text=+) After one pass,
    the largest integer-value should “bubble” up to the ArrayList’s
    high-indexed side –the operation repeats.

  - ![\#EEE0E5](https://placehold.it/15/EEE0E5?text=+) After
    ![formula](https://render.githubusercontent.com/render/math?math=n-1)
    passes, the bubble sorting terminates.

 

### Java Methods

#### Bubble Sort Class

1.  Method sorts the elements by linearly moving through the list
2.  After a pass, the largest value “bubbles” up the ArrayList
3.  Bubble sorting repeats for (n-1) passes

 

### Code Output

#### Execution Times

From the above execution times and graph, we can see that as the number
of data points
![formula](https://render.githubusercontent.com/render/math?math=n)
increases, the number of steps it takes to complete the bubble sort
increases **exponentially**. In **big-O notation**, the Simple Bubble
Sort Method for sorting
![formula](https://render.githubusercontent.com/render/math?math=n)
elements of an array is
![formula](https://render.githubusercontent.com/render/math?math=O\(n%5E2\));
hence, the algorithm has a run time that grows quadratically as the
input (data points) size grows.

-----

## Merge Sort :collision:

### Background

**Definition.** MergeSort is a recursive sorting technique that
recursively splits, sorts, and reconstructs the data. This method
recursively

  - ![\#E6E6FA](https://placehold.it/15/E6E6FA?text=+) divides the data
    into two unsorted lists,

  - ![\#778899](https://placehold.it/15/778899?text=+) sorts the two
    lists,

  - ![\#AEEEEE](https://placehold.it/15/AEEEEE?text=+) and then merges
    the two sorted lists.

 

### Java Methods

#### Merge Sort Algorithm

1.  Break the whole array down into two subarrays
2.  Sort the left half of the array (recursively)
3.  Sort the right half of the array (recursively)
4.  Merge the solutions

 

### Code Output

#### Execution Times

Each value
![formula](https://render.githubusercontent.com/render/math?math=n) in
the data set must be sorted into a temporary array, allotted once before
every single merge; therefore, we have
![formula](https://render.githubusercontent.com/render/math?math=n)
compares over all the merges. From the above execution times and graph,
we can see that as the number of data points
![formula](https://render.githubusercontent.com/render/math?math=n)
increases, the number of steps it takes to complete the bubble sort
increases **logarithmically**.

In **big-O notation**, since there are
![formula](https://render.githubusercontent.com/render/math?math=log%202n)
split levels, we have a time execution of
![formula](https://render.githubusercontent.com/render/math?math=O\(nlog%7Bn%7D\));
hence, the search algorithm has a run time that grows logarithmically as
the input size grows.

-----


## Summary

### Sorting Techniques:

From the graph below, we can see that the number of steps to execute the
Merge Sort method is significantly lower than the number of steps to
execute the Bubble Sort method; hence, the Merge Sort is faster and more
efficient than the Bubble Sort.

<img src="plot.jpg" width="600" style="display: block; margin: auto;" />

-----

