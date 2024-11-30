//{ Driver Code Starts
//Initial Template for Java

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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int LRS(String str1, String str2, int n, int m, int t[][]){
        if(n ==0 || m ==0){
            return 0;
        }

        if(t[n][m] != -1){
            return t[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1) && n != m){ // small change in the LCS Code -> add (n != m) condition.
            t[n][m] = 1 + LRS(str1, str2, n-1, m-1, t);
        }else{
            t[n][m] = Math.max(LRS(str1, str2, n-1, m, t), LRS(str1, str2, n, m-1, t));
        }
        return t[n][m];
    }
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        String newStr = str;

        int n = str.length();
        int m = newStr.length();

        int t[][] = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                t[i][j] = -1;
            }
        }
        
        return LRS(str, newStr, n, m, t);
    }
}