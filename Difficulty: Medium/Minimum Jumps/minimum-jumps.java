//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    static int minJumps(int[] arr) {
         
      int n = arr.length;
        if (n == 1) return 0;  // No jumps needed if we are already at the last index
        if (arr[0] == 0) return -1;  // If the first element is 0, we can't move anywhere

        int jumps = 0, farthest = 0, currentEnd = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);  // Update the farthest reachable index

            // If we reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;  // Increase the number of jumps
                currentEnd = farthest;  // Set new range limit

                // If the farthest we can reach is beyond or at the end of the array, we are done
                if (currentEnd >= n - 1) break;
            }
        }

        return currentEnd >= n - 1 ? jumps : -1;
    }
    
    
    
    public static int fun(int ind,int n,int arr[]){
        if(ind>=n)return (int)(1e9); 
        
        if(ind==n){
            return 0; 
            
        }
        
        if(arr[ind]==0){
          return (int)(1e9); 
        } 
        int maxi=(int)(1e9);
        for(int j=1;j<=arr[ind];j++){
             maxi=Math.min(maxi,1+fun(ind+j,n,arr));
        }
        
        return maxi; 
        
    }
}