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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//refer: https://discuss.geeksforgeeks.org/comment/153060307f0d671d07c806b8e49d8e31

class Solution{
    
    static int[] dx = {-1, 1, 0, 0};           //Order: U, D, R, L
    static int[] dy = {0, 0, -1, 1};           //Order: U, D, R, L
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
    
        // First, go to all the boundaries and find the discaradble Os.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isBoundary(i,j,n,m) && a[i][j] == 'O')
                    setNotClosed(a, i, j, n, m);            //all the Os in contact with any boundary O are also discardable. Hence, called DFS.
            }
        }
    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 'N')
                    a[i][j] = 'O';
                else
                    a[i][j] = 'X';
            }
        }
        
        return a;
        
    }
    
    static boolean isBoundary(int i, int j, int n, int m){  //just a simple function called initially in fill()(main function) while traverse the the boundary 
        return (i==0 || i == n-1 || j == 0 || j == m-1);
    }
    
    static void setNotClosed(char[][] arr, int i, int j, int n, int m){     //makes the current discardable element as 'N' and is called recursively(basically DFS) on its immediate four neighbours(U, D, R, L) to find any adjacent discardable 'O'
        arr[i][j] = 'N';
        
        for(int d = 0; d < 4; d++){
            int ii = i + dx[d];
            int jj = j + dy[d];
            
            if(isValid(ii,jj,n,m) && arr[ii][jj] == 'O')                    //isValid checks for valid directional neighbours in case of boundary elements. For rest elements(non boundary elements), it is basically useless as it will return true.
                setNotClosed(arr, ii,jj,n,m);
        }
        
    }
    
    
    static boolean isValid(int ii, int jj, int n, int m){                   //tells whether ii, jj lie inside matrix
        return (ii>0 && ii < n && jj > 0 & jj < m);
        
    }
    
    
}