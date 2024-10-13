//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int findMaxLen(String s) {
        int maxLength = 0;
        int open = 0, close = 0;

        // Left-to-right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                maxLength = Math.max(maxLength, 2 * close);
            } else if (close > open) {
                open = close = 0;  // Reset when invalid
            }
        }

        // Reset counts for right-to-left pass
        open = close = 0;

        // Right-to-left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                maxLength = Math.max(maxLength, 2 * open);
            } else if (open > close) {
                open = close = 0;  // Reset when invalid
            }
        }

        return maxLength;
    }
}
