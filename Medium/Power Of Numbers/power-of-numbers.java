//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
        //testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    
		    
            //input N
		    N=sc.nextInt();
		    int R=0;
		    
		    	    
            // reverse the given number n
		    R=(int)rev(N);
	
            //power of the number to it's reverse
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static final int MOD = 1000000007;

    long power(int N, int R) {
        return modularExponentiation(N, R, MOD);
    }

    long modularExponentiation(long base, long exponent, int mod) {
        if (exponent == 0) {
            return 1;
        }

        long half = modularExponentiation(base, exponent / 2, mod) % mod;
        half = (half * half) % mod;

        if (exponent % 2 != 0) {
            half = (half * base) % mod;
        }

        return half;
    }

    // Helper function to reverse a number
    int reverseNumber(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}