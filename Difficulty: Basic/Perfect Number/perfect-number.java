//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPerfect(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int printFactorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        
        return n*printFactorial(n-1);
    }
    int isPerfect(int N) {
        // code here
        int sum = 0;
        int originalNum = N;
        
        while(N > 0){
            int lastDigit = N%10;
            sum += printFactorial(lastDigit);
            N = N/10;
        }
        
        if(sum == originalNum){
            return 1;
        }
        return 0;
    }
}