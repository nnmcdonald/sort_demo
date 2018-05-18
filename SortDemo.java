//
// I've commented out the spots where I used the displayWordList method so that I could more easily 
// read the results of the swaps and comparisons.
//
import java.util.*;
import java.io.*;

public class SortDemo
{
  private static int comparisons = 0;
  private static int swaps = 0;
  
   public static void main(String[] args)
   {          
     Scanner inputStream = null;
     Scanner inputStream25 = null;
     Scanner inputStream50 = null;
     Scanner inputStream75 = null;

     //Array to hold unsorted list 
     String[] wordList = new String[5000];
     //Array to 25% sorted list
     String[] wordList25 = new String[5000];
     //Array to hold 50% sorted list
     String[] wordList50 = new String[5000];
     //Array to hold 75% sorted list
     String[] wordList75 = new String[5000];
     
     try
     {
       inputStream = new Scanner(new File("wordList.txt"));
       inputStream25 = new Scanner(new File("wordList25%Sorted.txt"));
       inputStream50 = new Scanner(new File("wordList50%Sorted.txt"));
       inputStream75 = new Scanner(new File("wordList75%Sorted.txt"));
     }
     catch (FileNotFoundException e)
     {
       System.out.println("File not found. Please enter another file name:");
     }
      
     //SelectionSort test for 5000 words
     for (int i = 0; i < 5000; i++)
     {
       String word = inputStream.nextLine();
       wordList[i] = word;
     }     
     //System.out.println("Original Word List:");
     //displayWordList(wordList, 5000);
     String[] secondList = copyList(wordList, 5000);
     //System.out.println("Copied word list:");
     //displayWordList(secondList, 5000);
     selectionSort(secondList, 5000);
     System.out.println("5000 Word List");
     System.out.println("Unsorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     selectionSort(secondList, 5000);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //SelectionSort 25% Sorted Array
     for (int i = 0; i < 5000; i++)
     {
       String word = inputStream25.nextLine();
       wordList25[i] = word;
     }
     secondList = copyList(wordList25, 5000);
     selectionSort(secondList, 5000);
     System.out.println("25% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     selectionSort(secondList, 5000);
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //SelectionSort 50% Sorted Array
     for (int i = 0; i < 5000; i++)
     {
       String word = inputStream50.nextLine();
       wordList50[i] = word;
     }
     secondList = copyList(wordList50, 5000);
     selectionSort(secondList, 5000);
     System.out.println("50% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     selectionSort(secondList, 5000);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
      //SelectionSort 75% Sorted Array
     for (int i = 0; i < 5000; i++)
     {
       String word = inputStream75.nextLine();
       wordList75[i] = word;
     }
     secondList = copyList(wordList75, 5000);
     selectionSort(secondList, 5000);
     System.out.println("75% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     selectionSort(secondList, 5000);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //InsertionSort test for 5000 words
     secondList = copyList(wordList, 5000);
     insertionSort(secondList, 5000);
     System.out.println("Unsorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     insertionSort(secondList, 5000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //InsertionSort 25% Sorted Array
     secondList = copyList(wordList25, 5000);
     insertionSort(secondList, 5000);
     System.out.println("25% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     insertionSort(secondList, 5000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //InsertionSort 50% Sorted Array
     secondList = copyList(wordList50, 5000);
     insertionSort(secondList, 5000);
     System.out.println("50% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     insertionSort(secondList, 5000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //InsertionSort 75% Sorted Array
     secondList = copyList(wordList75, 5000);
     insertionSort(secondList, 5000);
     System.out.println("75% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     insertionSort(secondList, 5000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //MergeSort test for 5000 words
     System.out.println("Unsorted List:");
     secondList = copyList(wordList, 5000);
     mergeSort(secondList, 0, 4999);
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     mergeSort(secondList, 0, 4999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //MergeSort 25% Sorted Array
     secondList = copyList(wordList25, 5000);
     mergeSort(secondList, 0, 4999);
     System.out.println("25% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     mergeSort(secondList, 0, 4999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //MergeSort 50% Sorted Array
     secondList = copyList(wordList50, 5000);
     mergeSort(secondList, 0, 4999);
     System.out.println("50% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     mergeSort(secondList, 0, 4999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //MergeSort 75% Sorted Array
     secondList = copyList(wordList75, 5000);
     mergeSort(secondList, 0, 4999);
     System.out.println("75% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     mergeSort(secondList, 0, 4999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     
     //QuickSort Test for 5000 words
     //I was unable to get my quick sort to sort the already sorted list, I kept getting stack overflow
     secondList = copyList(wordList, 5000);
     quickSort(secondList, 0, 5000);
     System.out.println("Unsorted List Results:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     //quickSort(secondList, 0, 5000);
     //System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     //System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     //resetCounts();
     
     //QuickSort 25% Sorted Array
     secondList = copyList(wordList25, 5000);
     quickSort(secondList, 0, 5000);
     System.out.println("25% Sorted Array:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     //quickSort(secondList, 0, 5000);
     //System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     //System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //resetCounts();
     
     //QuickSort 50% Sorted Array
     secondList = copyList(wordList50, 5000);
     quickSort(secondList, 0, 5000);
     System.out.println("50% Sorted List: ");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     //quickSort(secondList, 0, 5000);
     //System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     //System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //resetCounts();
     
     //QuickSort 75% Sorted Array
     secondList = copyList(wordList75, 5000);
     quickSort(secondList, 0, 5000);
     System.out.println("75% Sorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 5000);
     resetCounts();
     //quickSort(secondList, 0, 5000);
     //System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     //System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //resetCounts();
     
     //Selection Sort test for 1000 words
     try
     {
       inputStream = new Scanner(new File("1000wordList.txt"));
       inputStream25 = new Scanner(new File("1000wordList25%Sorted.txt"));
       inputStream50 = new Scanner(new File("1000wordList50%Sorted.txt"));
       inputStream75 = new Scanner(new File("1000wordList75%Sorted.txt"));
     }
     catch (FileNotFoundException e)
     {
       System.out.println("File not found. Please enter another file name:");
     }
     for (int i = 0; i < 1000; i++)
     {
       String word = inputStream.nextLine();
       wordList[i] = word;
     }
     secondList = copyList(wordList, 1000);
     //displayWordList(secondList, 1000);
     selectionSort(secondList, 1000);
     System.out.println("\n1000 Word List");
     System.out.println("Unsorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     selectionSort(secondList, 1000);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //SelectionSort 25% Sorted Array of 1000 words
     for (int i = 0; i < 1000; i++)
     {
       String word = inputStream25.nextLine();
       wordList25[i] = word;
     }
     secondList = copyList(wordList25, 1000);
     //displayWordList(secondList, 1000);
     selectionSort(secondList, 1000);
     System.out.println("25% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     selectionSort(secondList, 1000);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //SelectionSort 50% Sorted Array of 1000 words
     for (int i = 0; i < 1000; i++)
     {
       String word = inputStream50.nextLine();
       wordList50[i] = word;
     }
     secondList = copyList(wordList50, 1000);
     //displayWordList(secondList, 1000);
     selectionSort(secondList, 1000);
     System.out.println("50% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     selectionSort(secondList, 1000);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //SelectionSort 75% Sorted Array of 1000 words
     for (int i = 0; i < 1000; i++)
     {
       String word = inputStream75.nextLine();
       wordList75[i] = word;
     }
     secondList = copyList(wordList75, 1000);
     //displayWordList(secondList, 1000);
     selectionSort(secondList, 1000);
     System.out.println("75% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     selectionSort(secondList, 1000);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //InsertionSort test array of 1000
     secondList = copyList(wordList, 1000);
     insertionSort(secondList, 1000);
     System.out.println("Unsorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     insertionSort(secondList, 1000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //InsertionSort 25% Sorted Array of 1000
     secondList = copyList(wordList25, 1000);
     insertionSort(secondList, 1000);
     System.out.println("25% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     insertionSort(secondList, 1000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //InsertionSort 50% Sorted Array of 1000
     secondList = copyList(wordList50, 1000);
     insertionSort(secondList, 1000);
     System.out.println("50% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     insertionSort(secondList, 1000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //InsertionSort 75% Sorted Array of 1000
     secondList = copyList(wordList75, 1000);
     insertionSort(secondList, 1000);
     System.out.println("75% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     insertionSort(secondList, 1000);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //MergeSort test Array of 1000
     System.out.println("Unsorted List:");
     secondList = copyList(wordList, 1000);
     mergeSort(secondList, 0, 999);
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     mergeSort(secondList, 0, 999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //MergeSort 25% Sorted Array of 1000
     secondList = copyList(wordList25, 1000);
     mergeSort(secondList, 0, 999);
     System.out.println("25% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     mergeSort(secondList, 0, 999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //MergeSort 50% Sorted Array of 1000
     secondList = copyList(wordList50, 1000);
     mergeSort(secondList, 0, 999);
     System.out.println("50% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     mergeSort(secondList, 0, 999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //MergeSort 75% Sorted Array of 1000
     secondList = copyList(wordList75, 1000);
     mergeSort(secondList, 0, 999);
     System.out.println("75% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     mergeSort(secondList, 0, 999);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //QuickSort Test array of 1000
     secondList = copyList(wordList, 1000);
     quickSort(secondList, 0, 1000);
     System.out.println("Unsorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     quickSort(secondList, 0, 1000);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //QuickSort 25% Sorted Array of 1000
     secondList = copyList(wordList25, 1000);
     quickSort(secondList, 0, 1000);
     System.out.println("25% Sorted Array:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     quickSort(secondList, 0, 1000);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //QuickSort 50% Sorted Array of 1000
     secondList = copyList(wordList50, 1000);
     quickSort(secondList, 0, 1000);
     System.out.println("50% Sorted List: ");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     quickSort(secondList, 0, 1000);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //QuickSort 75% Sorted Array of 1000
     secondList = copyList(wordList75, 1000);
     quickSort(secondList, 0, 1000);
     System.out.println("75% Sorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     quickSort(secondList, 0, 1000);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 1000);
     resetCounts();
     
     //Selection Sort test array of 100 words
     try
     {
       inputStream = new Scanner(new File("100wordList.txt"));
       inputStream25 = new Scanner(new File("100wordList25%Sorted.txt"));
       inputStream50 = new Scanner(new File("100wordList50%Sorted.txt"));
       inputStream75 = new Scanner(new File("100wordList75%Sorted.txt"));
     }
     catch (FileNotFoundException e)
     {
       System.out.println("File not found. Please enter another file name:");
     }
     for (int i = 0; i < 100; i++)
     {
       String word = inputStream.nextLine();
       wordList[i] = word;
     }
     secondList = copyList(wordList, 100);
     //displayWordList(secondList, 100);
     selectionSort(secondList, 100);
     System.out.println("\n100 Word List");
     System.out.println("Unsorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     selectionSort(secondList, 100);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //SelectionSort 25% Sorted Array of 100 words
     for (int i = 0; i < 100; i++)
     {
       String word = inputStream25.nextLine();
       wordList25[i] = word;
     }
     secondList = copyList(wordList25, 100);
     //displayWordList(secondList, 100);
     selectionSort(secondList, 100);
     System.out.println("25% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     selectionSort(secondList, 100);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //SelectionSort 50% Sorted Array of 100 words
     for (int i = 0; i < 100; i++)
     {
       String word = inputStream50.nextLine();
       wordList50[i] = word;
     }
     secondList = copyList(wordList50, 100);
     //displayWordList(secondList, 100);
     selectionSort(secondList, 100);
     System.out.println("50% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     selectionSort(secondList, 100);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //SelectionSort 75% Sorted Array of 100 words
     for (int i = 0; i < 100; i++)
     {
       String word = inputStream75.nextLine();
       wordList75[i] = word;
     }
     secondList = copyList(wordList75, 100);
     selectionSort(secondList, 100);
     System.out.println("75% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     selectionSort(secondList, 100);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //InsertionSort test array of 100
     secondList = copyList(wordList, 100);
     insertionSort(secondList, 100);
     System.out.println("Unsorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     insertionSort(secondList, 100);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //InsertionSort 25% Sorted Array of 100
     secondList = copyList(wordList25, 100);
     insertionSort(secondList, 100);
     System.out.println("25% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     insertionSort(secondList, 100);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //InsertionSort 50% Sorted Array of 100
     secondList = copyList(wordList50, 100);
     insertionSort(secondList, 100);
     System.out.println("50% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     insertionSort(secondList, 100);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //InsertionSort 75% Sorted Array of 100
     secondList = copyList(wordList75, 100);
     insertionSort(secondList, 100);
     System.out.println("75% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     insertionSort(secondList, 100);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //MergeSort test Array of 100
     System.out.println("Unsorted List:");
     secondList = copyList(wordList, 100);
     mergeSort(secondList, 0, 99);
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     mergeSort(secondList, 0, 99);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //MergeSort 25% Sorted Array of 100
     secondList = copyList(wordList25, 100);
     mergeSort(secondList, 0, 99);
     System.out.println("25% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     mergeSort(secondList, 0, 99);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //MergeSort 50% Sorted Array of 100
     secondList = copyList(wordList50, 100);
     mergeSort(secondList, 0, 99);
     System.out.println("50% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     mergeSort(secondList, 0, 99);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //MergeSort 75% Sorted Array of 100
     secondList = copyList(wordList75, 100);
     mergeSort(secondList, 0, 99);
     System.out.println("75% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     mergeSort(secondList, 0, 99);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //QuickSort Test array of 100
     secondList = copyList(wordList, 100);
     quickSort(secondList, 0, 100);
     System.out.println("Unsorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     quickSort(secondList, 0, 100);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //QuickSort 25% Sorted Array of 100
     secondList = copyList(wordList25, 100);
     quickSort(secondList, 0, 100);
     System.out.println("25% Sorted Array:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     quickSort(secondList, 0, 100);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //QuickSort 50% Sorted Array of 100
     secondList = copyList(wordList50, 100);
     quickSort(secondList, 0, 100);
     System.out.println("50% Sorted List: ");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     quickSort(secondList, 0, 100);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 100);
     resetCounts();
     
     //QuickSort 75% Sorted Array of 100
     secondList = copyList(wordList75, 100);
     quickSort(secondList, 0, 100);
     System.out.println("75% Sorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     resetCounts();
     quickSort(secondList, 0, 100);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     resetCounts();
     
     //Selection Sort test for 50 words
     try
     {
       inputStream = new Scanner(new File("50wordList.txt"));
       inputStream25 = new Scanner(new File("50wordList25%Sorted.txt"));
       inputStream50 = new Scanner(new File("50wordList50%Sorted.txt"));
       inputStream75 = new Scanner(new File("50wordList75%Sorted.txt"));
     }
     catch (FileNotFoundException e)
     {
       System.out.println("File not found. Please enter another file name:");
     }
     for (int i = 0; i < 50; i++)
     {
       String word = inputStream.nextLine();
       wordList[i] = word;
     }
     secondList = copyList(wordList, 50);
     //displayWordList(secondList, 50);
     selectionSort(secondList, 50);
     System.out.println("\n50 Word List");
     System.out.println("Unsorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     selectionSort(secondList, 50);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //SelectionSort 25% Sorted Array of 50 words
     for (int i = 0; i < 50; i++)
     {
       String word = inputStream25.nextLine();
       wordList25[i] = word;
     }
     secondList = copyList(wordList25, 50); 
     //displayWordList(secondList, 50);
     selectionSort(secondList, 50);
     System.out.println("25% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     selectionSort(secondList, 50);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //SelectionSort 50% Sorted Array of 50 words
     for (int i = 0; i < 50; i++)
     {
       String word = inputStream50.nextLine();
       wordList50[i] = word;
     }
     secondList = copyList(wordList50, 50);
     //displayWordList(secondList, 50);
     selectionSort(secondList, 50);
     System.out.println("50% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     selectionSort(secondList, 50);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //SelectionSort 75% Sorted Array of 50 words
     for (int i = 0; i < 50; i++)
     {
       String word = inputStream75.nextLine();
       wordList75[i] = word;
     }
     secondList = copyList(wordList75, 50);
     selectionSort(secondList, 50);
     System.out.println("75% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     selectionSort(secondList, 50);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //InsertionSort test array of 50
     secondList = copyList(wordList, 50);
     insertionSort(secondList, 50);
     System.out.println("Unsorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     insertionSort(secondList, 50);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //InsertionSort 25% Sorted Array of 50
     secondList = copyList(wordList25, 50);
     insertionSort(secondList, 50);
     System.out.println("25% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     insertionSort(secondList, 50);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //InsertionSort 50% Sorted Array of 50
     secondList = copyList(wordList50, 50);
     insertionSort(secondList, 50);
     System.out.println("50% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     insertionSort(secondList, 50);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //InsertionSort 75% Sorted Array of 50
     secondList = copyList(wordList75, 50);
     insertionSort(secondList, 50);
     System.out.println("75% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     insertionSort(secondList, 50);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //MergeSort test Array of 50
     System.out.println("Unsorted List:");
     secondList = copyList(wordList, 50);
     mergeSort(secondList, 0, 49);
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     mergeSort(secondList, 0, 49);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //MergeSort 25% Sorted Array of 50
     secondList = copyList(wordList25, 50);
     mergeSort(secondList, 0, 49);
     System.out.println("25% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     mergeSort(secondList, 0, 49);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //MergeSort 50% Sorted Array of 50
     secondList = copyList(wordList50, 50);
     mergeSort(secondList, 0, 49);
     System.out.println("50% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     mergeSort(secondList, 0, 49);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //MergeSort 75% Sorted Array of 50
     secondList = copyList(wordList75, 50);
     mergeSort(secondList, 0, 49);
     System.out.println("75% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     mergeSort(secondList, 0, 49);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //QuickSort Test array of 50
     secondList = copyList(wordList, 50);
     quickSort(secondList, 0, 50);
     System.out.println("Unsorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     quickSort(secondList, 0, 50);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //QuickSort 25% Sorted Array of 50
     secondList = copyList(wordList25, 50);
     quickSort(secondList, 0, 50);
     System.out.println("25% Sorted Array:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     quickSort(secondList, 0, 50);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //QuickSort 50% Sorted Array of 50
     secondList = copyList(wordList50, 50);
     quickSort(secondList, 0, 50);
     System.out.println("50% Sorted List: ");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     quickSort(secondList, 0, 50);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //QuickSort 75% Sorted Array of 50
     secondList = copyList(wordList75, 50);
     quickSort(secondList, 0, 50);
     System.out.println("75% Sorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     quickSort(secondList, 0, 50);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 50);
     resetCounts();
     
     //SelectionSort test for array of 10
     try
     {
       inputStream = new Scanner(new File("10wordList.txt"));
       inputStream25 = new Scanner(new File("10wordList25%Sorted.txt"));
       inputStream50 = new Scanner(new File("10wordList50%Sorted.txt"));
       inputStream75 = new Scanner(new File("10wordList75%Sorted.txt"));
     }
     catch (FileNotFoundException e)
     {
       System.out.println("File not found. Please enter another file name:");
     }
     for (int i = 0; i < 10; i++)
     {
       String word = inputStream.nextLine();
       wordList[i] = word;
     }
     secondList = copyList(wordList, 10);
     //displayWordList(secondList, 10);
     selectionSort(secondList, 10);
     System.out.println("\n10 Word List");
     System.out.println("Unsorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     selectionSort(secondList, 10);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //SelectionSort 25% Sorted Array of 10 words
     for (int i = 0; i < 10; i++)
     {
       String word = inputStream25.nextLine();
       wordList25[i] = word;
     }
     secondList = copyList(wordList25, 10);
     //displayWordList(secondList, 10);
     selectionSort(secondList, 10);
     System.out.println("25% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     selectionSort(secondList, 10);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //SelectionSort 50% Sorted Array of 10 words
     for (int i = 0; i < 10; i++)
     {
       String word = inputStream50.nextLine();
       wordList50[i] = word;
     }
     secondList = copyList(wordList50, 10);
     //displayWordList(secondList, 10);
     selectionSort(secondList, 10);
     System.out.println("50% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     selectionSort(secondList, 10);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     resetCounts();
     
     //SelectionSort 75% Sorted Array of 10 words
     for (int i = 0; i < 10; i++)
     {
       String word = inputStream75.nextLine();
       wordList75[i] = word;
     }
     secondList = copyList(wordList75, 10);
     //displayWordList(secondList, 10);
     selectionSort(secondList, 10);
     System.out.println("75% Sorted List:");
     System.out.println("Selection Sort Swaps: " + getSwapCount());
     System.out.println("Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     selectionSort(secondList, 10);
     System.out.println("Already Sorted Selection Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Selection Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //InsertionSort test array of 10
     secondList = copyList(wordList, 10);
     insertionSort(secondList, 10);
     System.out.println("Unsorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     insertionSort(secondList, 10);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //InsertionSort 25% Sorted Array of 10
     secondList = copyList(wordList25, 10);
     insertionSort(secondList, 10);
     System.out.println("25% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     insertionSort(secondList, 10);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //InsertionSort 50% Sorted Array of 10
     secondList = copyList(wordList50, 10);
     insertionSort(secondList, 10);
     System.out.println("50% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     insertionSort(secondList, 10);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //InsertionSort 75% Sorted Array of 10
     secondList = copyList(wordList75, 10);
     insertionSort(secondList, 10);
     System.out.println("75% Sorted List:");
     System.out.println("Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     insertionSort(secondList, 10);
     System.out.println("Already Sorted Insertion Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Insertion Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //MergeSort test Array of 10
     System.out.println("Unsorted List:");
     secondList = copyList(wordList, 10);
     mergeSort(secondList, 0, 9);
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     mergeSort(secondList, 0, 9);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //MergeSort 25% Sorted Array of 10
     secondList = copyList(wordList25, 10);
     mergeSort(secondList, 0, 9);
     System.out.println("25% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     mergeSort(secondList, 0, 9);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //MergeSort 50% Sorted Array of 10
     secondList = copyList(wordList50, 10);
     mergeSort(secondList, 0, 9);
     System.out.println("50% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     mergeSort(secondList, 0, 9);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //MergeSort 75% Sorted Array of 10
     secondList = copyList(wordList75, 10);
     mergeSort(secondList, 0, 9);
     System.out.println("75% Sorted List:");
     System.out.println("Merge Sort Swaps: " + getSwapCount());
     System.out.println("Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     mergeSort(secondList, 0, 9);
     System.out.println("Already Sorted Merge Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Merge Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //QuickSort Test array of 10
     secondList = copyList(wordList, 10);
     quickSort(secondList, 0, 10);
     System.out.println("Unsorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     quickSort(secondList, 0, 10);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //QuickSort 25% Sorted Array of 10
     secondList = copyList(wordList25, 10);
     quickSort(secondList, 0, 10);
     System.out.println("25% Sorted Array:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     quickSort(secondList, 0, 10);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //QuickSort 50% Sorted Array of 10
     secondList = copyList(wordList50, 10);
     quickSort(secondList, 0, 10);
     System.out.println("50% Sorted List: ");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     quickSort(secondList, 0, 10);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     
     //QuickSort 75% Sorted Array of 10
     secondList = copyList(wordList75, 10);
     quickSort(secondList, 0, 10);
     System.out.println("75% Sorted List:");
     System.out.println("Quick Sort Swaps: " + getSwapCount());
     System.out.println("Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
     quickSort(secondList, 0, 10);
     System.out.println("Already Sorted Quick Sort Swaps: " + getSwapCount());
     System.out.println("Already Sorted Quick Sort Comparisons: " + getComparisonCount());
     //displayWordList(secondList, 10);
     resetCounts();
  
     inputStream.close();
     inputStream25.close();
     inputStream50.close();
     inputStream75.close();
   }
   
   public static void resetCounts()
   {
     swaps = 0;
     comparisons = 0;
   }
   public static void addSwap()
   {
     swaps++;
   }
   
   public static int getSwapCount()
   {
     return swaps;
   }
   
   public static void addComparison()
   {
     comparisons++;
   }
   
   public static int getComparisonCount()
   {
     return comparisons;
   }
   
   public static void selectionSort(String[] list, int n)
   {
     for(int i = 0; i < n - 1; i++)
     {
       int indexOfMin = i;
       for(int j = i + 1; j < n; j++)
       {
         addComparison();
         if(list[j].charAt(0) >= list[indexOfMin].charAt(0) )
         {
           //Determines which word should come first if they have equal values for charAt(k)
           if(list[j].charAt(0) == list[indexOfMin].charAt(0) && list[j].length() > 1)
           {
            for(int k = 1; (k < list[j].length()) && (k < list[indexOfMin].length()); k++)
            {
              if(list[j].charAt(k) < list[indexOfMin].charAt(k))
              {
                 indexOfMin = j;
                 k = list[j].length();
              }
              else if(list[j].charAt(k) > list[indexOfMin].charAt(k))
                  k = list[j].length();
              else if(k + 1 == list[j].length() && (list[j].length() < list[indexOfMin].length()))
              {
                indexOfMin = j;
                k = list[j].length();
              }
              addComparison();
            }
           }
           else if(list[j].charAt(0) == list[indexOfMin].charAt(0))
             indexOfMin = j;
         }         
         else
             indexOfMin = j;
       }
       if(i != indexOfMin)
         addSwap();
       String temp = list[i];
       list[i] = list[indexOfMin];
       list[indexOfMin] = temp;
     }
   }
     
   //loops through each element and inserts it at the appropriate place among previous elements
   public static void insertionSort(String[] list, int n)
   {
     for (int i = 1; i < n; i++)
     {
       boolean exitLoop = false;
       String key = list[i];
       int j = i -1;
       addComparison();
       int k = 0;
       
       while((j >= 0) && list[j].charAt(k) >= key.charAt(k) && !exitLoop)
       {
         if(list[j].charAt(k) == key.charAt(k) && k + 1 < list[j].length()  && k + 1 < key.length())
         {
           k++;
         }         
         else if((list[j].charAt(k) == key.charAt(k) && key.length() <= k + 1) || list[j].charAt(k) > key.charAt(k))
         {
           k = 0;
           list[j+1] = list[j];
           j--;
         }
         else if(list[j].charAt(k) == key.charAt(k) && list[j].length() <= k + 1)
         {
           exitLoop = true;
         }
         addComparison();
       }
       if(list[j + 1] != key)
         addSwap();
       list[j+1] = key;
     }
   }
   
   public static void quickSort(String[] list, int low,int high) 
   {
     if(high-low <= 1) 
       return;
     String pivot = list[high - 1];
     int split = low;
     int k = 0;
     addComparison();
     for(int i = low; i < high - 1; i++)
     {
       boolean exitLoop = false;
       while(!exitLoop)
       {       
         //Determines if a list word at position i comes before the pivot word alphabetically and swaps the
         //word with the word at a position in the array marked by split if it does, then split is incremented
         if(list[i].charAt(k) <= pivot.charAt(k))
           {
             if(list[i].charAt(k) == pivot.charAt(k) && list[i].length() > k + 1 && pivot.length() > k + 1)
             {
               k++;
             }
             else if(list[i].charAt(k) == pivot.charAt(k) && (pivot.length() == k + 1))
             {
               k = 0;
               exitLoop = true;
             }
             
             else if((list[i].charAt(k) == pivot.charAt(k) && list[i].length() == k + 1) 
                       || list[i].charAt(k) < pivot.charAt(k))
             {
               exitLoop = true;
               k = 0;
               if (i != split)
                 addSwap();
               swap(list, i, split);
               split++;
             }
             addComparison();
         }
         else
         {
           k = 0;
           exitLoop = true;
         }
       }
     }
     if(high - 1 != split)    
       addSwap();
     swap(list, high - 1, split);
     quickSort(list, low, split);
     quickSort(list, split + 1, high);
   }
 
   public static void mergeSort(String[] list, int low, int high)
   {
     //Divides array into smaller and smaller subparts which are then sorted and merged
     if (high - low > 1)
     {
       int mid = (high + low) / 2;
       mergeSort(list, low, mid);
       mergeSort(list, (mid + 1), high);
       merge(list, low, mid, high);
     }
     else
     {
       boolean exitLoop = false;
       int k = 0;
       while(!exitLoop)
       {
         addComparison();
         if (list[low].charAt(k) >= list[high].charAt(k))
         {
           //Determines which word should come first if they have equal values for charAt(k)
           if(list[low].charAt(k) == list[high].charAt(k) && list[low].length() > k + 1 && list[high].length() > k + 1)
             k++;
           else if(list[low].charAt(k) == list[high].charAt(k) && list[low].length() == k + 1)
             exitLoop = true;
           else if((list[low].charAt(k) == list[high].charAt(k) && list[high].length() == k + 1) 
                     || list[low].charAt(k) > list[high].charAt(k))
           {
             exitLoop = true;
             if(!list[low].equals(list[high]))
               addSwap();
             swap(list, low, high);
           }
         }
         else
           exitLoop = true;
       }
     }                    
   }
   
   //Copies the word list, then inserts the lowest value back into the list one at a time
   public static void merge(String[] list, int low, int mid, int high)
   {
     String[] tempArray = new String[high + 1];
     for (int i = low; i <= high; i++)
       tempArray[i] = list[i];
     int i = low;
     int j = mid + 1;
     int k = low;
     while(i <= mid && j <= high)
     {
       boolean exitLoop = false;
       int n = 0;
       while(!exitLoop)
       {
         addComparison();
         if(tempArray[i].charAt(n) <= tempArray[j].charAt(n))
         {       
           if(tempArray[i].charAt(n) == tempArray[j].charAt(n) && tempArray[i].length() > n + 1 
                && tempArray[j].length() > n + 1)
             n++;
           else if(tempArray[i].charAt(n) == tempArray[j].charAt(n) && tempArray[j].length() == n + 1)
           {
             exitLoop = true;
             if(k != j)
               addSwap();
             list[k] = tempArray[j];
             j++;
             k++; 
           }
           else if((tempArray[i].charAt(n) == tempArray[j].charAt(n) && tempArray[i].length() == n + 1) 
                     || tempArray[i].charAt(n) < tempArray[j].charAt(n))
           {
             exitLoop = true;
             if(k != i)
               addSwap();
             list[k] = tempArray[i];
             i++;
             k++;
           }
         }
         else
         {
           exitLoop = true;
           if(k != j)
             addSwap();
           list[k] = tempArray[j];
           j++;
           k++;
         }
       }
     }
     while(i <= mid)
     {
       if(k != i)
         addSwap();
       list[k] = tempArray[i];
       k++;
       i++;
     }
   }
   
   //Swaps a and b
   public static void swap(String[] list, int a, int b)
   {
     String temp = list[a];
     list[a] = list[b];
     list[b] = temp; 
   }
   
   //copies a String[] of n elements
   public static String[] copyList(String[] wordList, int n)
   {
     String[] newList = new String[n];
     for (int i = 0; i < n; i++)
       newList[i] = wordList[i];
     return newList;
   }
   
   //Prints each element in a String[]
   public static void displayWordList(String[] wordList, int n)
   {
     for (int i = 0; i < n; i++)
       System.out.println(wordList[i]);
   }
}