//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        
        int remainingSum = S;
        int digitsRemaining = N;
        String ans = "";
        
        if(S == 0 && N > 1) return "-1";
        
        if(S > N*9) return "-1";
        
        while(digitsRemaining > 0){
            
            if(remainingSum > 9){
                ans += "9";
                remainingSum -= 9;
            }
            else{
                ans += remainingSum;
                remainingSum = 0;
            }
            digitsRemaining--;
        }
        
        return ans;
    }
}