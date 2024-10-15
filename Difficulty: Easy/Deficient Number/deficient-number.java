//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long x = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isDeficient(x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isDeficient(long x){
        long sum=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                sum+=i;
            }
        }
        if(sum<=(2*x)){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}