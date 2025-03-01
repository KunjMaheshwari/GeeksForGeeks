//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int cutRod(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][n + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) { // Can cut the rod at this length
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - i], dp[i - 1][j]);
                } else { // Skip this length
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][n];
    }
}
