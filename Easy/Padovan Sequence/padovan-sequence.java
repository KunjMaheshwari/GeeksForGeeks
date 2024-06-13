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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends

//User function Template for Java

class Solution
{
    private static final int MOD = 1000000007;
    public static int padovanSequence(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 1;
        }

        // Initialize the array to store the Padovan sequence values
        int[] P = new int[n + 1];
        P[0] = P[1] = P[2] = 1;

        // Compute values from P(3) to P(n)
        for (int i = 3; i <= n; i++) {
            P[i] = (P[i - 2] + P[i - 3]) % MOD;
        }

        return P[n];
    }
    
}


