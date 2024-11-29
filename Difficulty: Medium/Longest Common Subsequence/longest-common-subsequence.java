//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the getLCSLength function with the lengths of the strings as
            // parameters
            System.out.println(obj.getLCSLength(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int LCS(String s1, String s2, int n, int m, int t[][]){
        if(n == 0 || m == 0){
            return 0;
        }
        
        if(t[n][m] != -1){
            return t[n][m];
        }
        
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            t[n][m] = 1 + LCS(s1, s2, n-1, m-1, t);
        }else{
            t[n][m] = Math.max(LCS(s1, s2, n-1, m, t), LCS(s1, s2, n, m-1, t));
        }
        return t[n][m];
    }
    // Function to find the length of the longest common subsequence in two strings.
    static int getLCSLength(String s1, String s2) {
        // your code here
        int n = s1.length();
        int m = s2.length();
        
        int t[][] = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                t[i][j] = -1;
            }
        }
        
        return LCS(s1, s2, n, m, t);
    }
}