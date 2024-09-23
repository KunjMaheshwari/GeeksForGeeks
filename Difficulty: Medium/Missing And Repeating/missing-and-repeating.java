//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        long expectedSum = (long)n * (n + 1) / 2; // Sum of first n numbers
        long expectedSumOfSquares = (long)n * (n + 1) * (2 * n + 1) / 6; // Sum of squares of first n numbers
        
        long actualSum = 0;
        long actualSumOfSquares = 0;

        // Calculating the actual sum and actual sum of squares from the array
        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
            actualSumOfSquares += (long)arr[i] * arr[i];
        }

        // Let x be the missing number and y be the repeating number.
        long diffSum = expectedSum - actualSum; // x - y
        long diffSumOfSquares = expectedSumOfSquares - actualSumOfSquares; // x^2 - y^2

        // We know that x^2 - y^2 = (x - y) * (x + y)
        // => (x + y) = (x^2 - y^2) / (x - y)
        long sumXY = diffSumOfSquares / diffSum;

        // Now we have two equations:
        // 1. x - y = diffSum
        // 2. x + y = sumXY
        // Solving these gives us:
        long x = (diffSum + sumXY) / 2;
        long y = x - diffSum;

        return new int[]{(int)y, (int)x}; // y is the repeating number, x is the missing number
    }
}
