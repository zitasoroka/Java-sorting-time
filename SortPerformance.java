package sort;
import java.util.Scanner;
import org.apache.commons.lang3.time.StopWatch;

 
public class SortPerformance {
 
	
    public static void main(String[] args){
    	
    		// initialising stop watches and scanner 	
    		StopWatch timer = new StopWatch();	
    		StopWatch timer2 = new StopWatch();
    		Scanner reader = new Scanner(System.in);
			
    		// for loop used to ask for user input 10 timer
			for(int i=0; i<10; i++){
				
	    		System.out.println("Enter array size");
	    		int n = reader.nextInt();
	    		int A[] = new int[n];
	    		
	    		
	    		// calling method to populate an array
				populateArray(A);
				timer.reset();
				timer2.reset();
				
				// method to start and stop timer
				// method to use insertion sort on array of user input size
				timer.start();
				insertionSort(A);
				timer.stop();
				
				// method to start and stop timer
				// method to use merge sort on array of user size
				timer2.start();
				mergeSort(A);
				timer2.stop();
				
				
				System.out.println("Insertion sort running time: " + timer.getNanoTime() / 1000000 + " ms");
				System.out.println("Merge sort running time: " + timer2.getNanoTime() / 1000000 + " ms");
		
			}
    }

 
 
    // This method will sort the integer array using insertion sort algorithm
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }
 
    // method used to populate an array with random numbers 
    public static void populateArray(int[] B) {
        for (int i = 0; i < B.length; i++) {
            B[i] = (int) (Math.random() * 1000);
        }
    }
    
    // This method will sort an integer array 
    // using the merge sort algorithm
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // methods to split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            
            // calling method recursively to sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // method to merge the sorted halves into a sorted whole
            merge(array, left, right);
        }
    }
    
    // Returns the first half of the given array.    
    public static int[] leftHalf(int[] array) {		
        int size1 = array.length / 2;			
        int[] left = new int[size1];			
        for (int i = 0; i < size1; i++) {			
            left[i] = array[i];
        }
        return left;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    
    // Merges the given left and right arrays into the given 
    // result array 
    // where input result is empty, left/right are sorted
    // output result contains result of merging sorted lists;
    public static void merge(int[] result, 
                             int[] left, int[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // add from left array
                i1++;
            } else {
                result[i] = right[i2];   // add from right array
                i2++;
            }
        }
    }
}