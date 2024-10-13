//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // Two pointers approach to check palindrome
        int left = 0;
        int right = S.length() - 1;

        while (left < right) {
            // If characters at both pointers don't match, it's not a palindrome
            if (S.charAt(left) != S.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }

        // If we traversed the string without finding a mismatch, it's a palindrome
        return 1;
    }
}
