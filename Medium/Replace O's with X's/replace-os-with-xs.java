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

class Solution{
    
    static int[] dx = {0, 0,-1, 1};           //Order: R, L, U, D
    static int[] dy = {1,-1, 0, 0};          //Order: R, L, U, D
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
    
        for(int col = 0; col < m; col++)
        {
            if(a[0][col] == 'O')
                setNotClosed(a, 0, col, n, m);
            
            if(a[n-1][col] == 'O')
                setNotClosed(a, n-1, col, n, m);
        }
        
        for(int row = 0; row < n; row++)
        {
            if(a[row][0] == 'O')
                setNotClosed(a, row, 0, n, m);
            
            if(a[row][m-1] == 'O')
                setNotClosed(a, row, m-1, n, m);
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
    
    static void setNotClosed(char[][] arr, int i, int j, int n, int m){
        arr[i][j] = 'N';
        
        for(int d = 0; d < 4; d++){
            int ii = i + dx[d];
            int jj = j + dy[d];
            
            if(isValid(ii,jj,n,m) && arr[ii][jj] == 'O')
                setNotClosed(arr, ii,jj,n,m);
        }
        
    }
    
    
    static boolean isValid(int ii, int jj, int n, int m){
        return (ii>0 && ii < n && jj > 0 & jj < m);
        
    }
    
    
}