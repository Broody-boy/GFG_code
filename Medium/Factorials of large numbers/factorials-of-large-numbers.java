//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        int carryIndex = Integer.MIN_VALUE;
        
        ans.add(1);
        int carry = 0;
        
        for(int i = 2; i <= N; i++){
            
            for(int j = ans.size() - 1; j >= 0; j--){
            
                int product = ans.get(j) * i + carry;
                int digit = product%10;
                carry = product/10;
                ans.set(j, digit);
            
                if(j==0){               //reached the start of the array but carry is still pending
                    
                    while(carry > 0){   //Now, dispose off the carries by moving one by one to the left inside the carry e.g. if carry = 180=> first add 0 to the start of the arraylist, then 8 to the start and then 1 to the start
                        ans.add(0, carry%10);
                        carry = carry/10;
                    }
                }
            }

            carry = 0;
        }
        return ans;
    }
    
}