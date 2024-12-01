//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int memo(int arr[], int i, int j, int t[][]){
        if(i == j){
            return 0;
        }
        
        if(t[i][j] != -1){
            return t[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int k=i;k<=j-1;k++){
            int cost1 = memo(arr, i, k, t);
            int cost2 = memo(arr, k+1, j, t);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            
            int finalCost = cost1 + cost2 + cost3;
            
            ans = Math.min(ans, finalCost);
            
            t[i][j] = ans;
        }
        
        return t[i][j];
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        
        int i = 1;
        int j = n-1;
        
        int t[][] = new int[n+1][n+1];
        
        for(int l=0;l<=n;l++){
            for(int p=0;p<=n;p++){
                t[l][p] = -1;
            }
        }
        
        return memo(arr, i, j, t);
    }
}