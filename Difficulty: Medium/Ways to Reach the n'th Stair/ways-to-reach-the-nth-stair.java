//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to count number of ways to reach the nth stair.
    public static int printSolution(int n, int ways[]){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        
        if(ways[n] != -1){
            return ways[n];
        }
        
        ways[n] = printSolution(n-1, ways) + printSolution(n-2, ways);
        return ways[n];
    }
    int countWays(int n) {

        // your code here
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        
        return printSolution(n, ways);
    }
}
