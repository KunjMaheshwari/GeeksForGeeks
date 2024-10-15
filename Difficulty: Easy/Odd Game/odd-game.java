//{ Driver Code Starts


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.oddGame(N));
        }
    }
}
// } Driver Code Ends




class Solution {
    static Long oddGame(Long N) {
        // code here
        if(N == 1){
            return N;
        }
        
        long ans = 2;
        
        while(ans < N){
            ans = ans*2;
        }
        
        if(ans > N){
            return ans/2;
        }
        
        return ans;
    }
};