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
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDigitSumPalindrome(int n) {
        // code here
        int sum = 0;
        int originalNum = n;
        
        while(originalNum>0){
            sum += originalNum%10;
            originalNum = originalNum/10;
        }
        
        int reversedNum = 0;
        int originalSum = sum;
        
        while(sum >0){
            reversedNum = reversedNum*10 + (sum%10);
            sum = sum/10;
        }
        
        if(reversedNum == originalSum){
            return 1;
        }
        return 0;
    }
}