//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {}
    
    public static void mySieve(int prime[], int n){
        for(int i=1;i<=n;i++){
            prime[i] = i;
        }
        
        for(int i=2;i*i<=n;i++){
            if(prime[i] == i){
                for(int j=i*i;j<=n;j+=i){
                    if(prime[j] == j){
                        prime[j] = i;
                    }
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        
        int prime[] = new int[N+1];
        
        mySieve(prime, N);
        
        while(N != 1){
            ans.add(prime[N]);
            N = N/prime[N];
        }
        return ans;
        
    }
}
