//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++)
            visited[i] = false;
        
        int ans = -1;
        
        for(int i = 0; i< V; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(adj, i, visited);
                ans = i;
            }                           //at the termination of this loop, ans stops at the last unvisited node.
        }

        boolean[] motherCheck = new boolean[V];
        for(int i = 0; i < V; i++)
            motherCheck[i] = false;

        motherCheck[ans] = true;
        DFS(adj, ans, motherCheck);     //perform dfs once again to check if it is the mother node or just a dead end with none pointing to it
        
        for(boolean v : motherCheck){   //if any of the vertex is unvisited, it means that vertex ans just a dead end
            if(!v)
                return -1;              
        }
        
        return ans;
    }
    
    void DFS(ArrayList<ArrayList<Integer>>adj, int nodeUnderConsideration, boolean[] visited){
        
        for(Integer neighbour : adj.get(nodeUnderConsideration)){       //adj[nodeUnderConsideration] is the adjacency list of nodeUnderConsideration, in which we loop to get to all its neighbours
            if(!visited[neighbour]){
                visited[neighbour] = true;
                DFS(adj, neighbour, visited);
            }
        }
    }
}