//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        
        return mergeSort(arr, 0, N-1);
    }
    
    
    static long mergeSort(long[] arr, long low, long high){
        
        long count = 0;
        
        if(low < high){
            long mid = (low + high)/2;
                
            count+= mergeSort(arr, low, mid);
            count+= mergeSort(arr, mid+1, high);
            count+= merge(arr,low,mid,high);
        }
        
        return count;
    }
    
    static long merge(long[] arr, long low, long mid, long high){
        
        long count = 0;
        
        long[] localArray = new long[(int)(high - low + 1)];
        long idx = 0;
        
        long i = low;                                //i is index inside left half
        long j = mid+1;                              //j is index inside right half
        
        while(i < mid+1 && j < high+1){             //The next element to be merged is coming from left half
            if(arr[(int)i] <= arr[(int)j]){
                localArray[(int)idx++] = arr[(int)i++];
            }
            if(arr[(int)i] > arr[(int)j]){          //The next element to be merged is coming from right half. This is the case which causes inversions.
                localArray[(int)idx++] = arr[(int)j++];  //as arr[i] > arr[j] but i < j (obv because i = index inside left half and j = index inside right half).
                count += mid - i + 1;               //count inversions here: because all elements to the right of index i in the left subarray are greater than arr[j] and are thus capable of forming a pair with the incoming element from right half.
            }
        }
        
        while(i < mid+1)
            localArray[(int)idx++] = arr[(int)i++];
            
        while(j < high+1)
            localArray[(int)idx++] = arr[(int)j++];
                
        for(int z = 0; z < localArray.length; z++)  //After the merging is complete, copy the elements from localArray back to the original arr in the range [low, high].
            arr[(int)(low + z)] = localArray[z];
            
        return count;
        
        
    }
}