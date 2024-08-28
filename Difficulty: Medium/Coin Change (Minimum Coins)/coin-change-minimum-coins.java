//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution{
  int dp[][];
    public int minCoins(int coins[], int N, int sum) {
        // code here.
        dp=new int[N+1][sum+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans=helper(coins,N,sum,0);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public int helper(int c[],int n,int sum,int current){
        if(sum==current){
            return 0;
        }
        if(n==0 || sum<current) {
            return Integer.MAX_VALUE;
        }
        if(dp[n][current]!=-1){
            return dp[n][current];
        }
    
            int include=helper(c,n,sum,current+c[n-1]);
            if(include!=Integer.MAX_VALUE){
                include+=1;
            }
            int exclude=helper(c,n-1,sum,current);
    
        return dp[n][current]=Math.min(include,exclude);
    }
}