//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int calculateCube(int n){
        return n*n*n;
    }
    static String armstrongNumber(int n) {
        // code here
        int sum = 0;
        
        int originalNum = n;
        
        while(n >0){
            int lastDigit = n%10;
            sum += calculateCube(lastDigit);
            n = n/10;
        }
        
        if(sum == originalNum){
            return "true";
        }
        return "false";
    }
}