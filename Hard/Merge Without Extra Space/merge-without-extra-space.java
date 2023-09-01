//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        
        
        // Arr1: 1 3 5 7
        // Arr2: 0 2 6 8 9
        // Start from end of arr1, towards left and start of arr2, towards right.
        // If arr1[right] > arr2[left] -> it means that bigger number is contained in arr1, which shouldn't be. So, we swap
        // If arr1[right] <= arr2[left] -> it means that smaller number is already in arr1, which is where it should be. So, don't even check for this case.
        // In the end, sort the haphazardically arranged items coming after swapping in their right place for both the arrays.
        
        int right = n-1;    // end of arr1
        int left = 0;       // start of arr2
        
        while(right >= 0 && left < m){
                
            if(arr1[right] > arr2[left]){
                
                //swap the right element of first array and left element of second array: 
                long x = arr1[right];
                arr1[right] = arr2[left];
                arr2[left] = x;
                
                right--;
                left++;
            }
            else 
                break;
        }
            
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}