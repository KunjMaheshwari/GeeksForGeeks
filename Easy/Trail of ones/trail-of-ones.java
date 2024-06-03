//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends



// User function Template for Java
class Solution {
        static int MOD = 1000000007;


public static int numberOfConsecutiveOnes(int n) {
        if (n == 1) {
            return 0;
        }
        
        // a(n) will hold the number of strings without consecutive 1's
        long[] a = new long[n + 1];
        
        // Initial values
        a[0] = 1; // There is 1 empty string with length 0, and it doesn't have consecutive 1's
        a[1] = 2; // There are 2 strings of length 1: "0" and "1"
        
        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % MOD;
        }
        
        long totalStrings = powerOfTwo(n, MOD);
        long result = (totalStrings - a[n] + MOD) % MOD;
        
        return (int) result;
    }
    
    private static long powerOfTwo(int n, int mod) {
        long result = 1;
        long base = 2;
        
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            n >>= 1;
        }
        
        return result;
    }
}