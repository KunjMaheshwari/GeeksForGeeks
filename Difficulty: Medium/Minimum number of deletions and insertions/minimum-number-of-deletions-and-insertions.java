//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.minOperations(s1, s2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int LCS(String str1, String str2, int n, int m, int t[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (t[n][m] != -1) {
            return t[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            t[n][m] = 1 + LCS(str1, str2, n - 1, m - 1, t);
        } else {
            t[n][m] = Math.max(LCS(str1, str2, n - 1, m, t), LCS(str1, str2, n, m - 1, t));
        }
        return t[n][m];
    }
    public int minOperations(String s1, String s2) {
        // Your code goes here
        int n = s1.length();
        int m = s2.length();

        int t[][] = new int[n + 1][m + 1];

        // Initialize the DP array with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                t[i][j] = -1;
            }
        }

        // Compute LCS
        int lcsLength = LCS(s1, s2, n, m, t);

        // Minimum deletions = length of word1 - LCS
        int deletions = n - lcsLength;

        // Minimum insertions = length of word2 - LCS
        int insertions = m - lcsLength;

        // Total minimum operations = deletions + insertions
        return deletions + insertions;
    }
}