//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public static boolean[][] subsetSum(int arr[], int range) {
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][range + 1];
        
        // Initialize the DP table
        for (int i = 0; i <= n; i++) {
            t[i][0] = true; // Sum of 0 is always possible with an empty subset
        }
        for (int j = 1; j <= range; j++) {
            t[0][j] = false; // No positive sum is possible with 0 elements
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t;
    }

    public int minDifference(int arr[]) {
        int n = arr.length;
        int range = 0;
        for (int i = 0; i < n; i++) {
            range += arr[i]; // Sum of all elements
        }

        boolean[][] t = subsetSum(arr, range);
        int minDiff = Integer.MAX_VALUE;

        // Check for the maximum possible sum that can be achieved
        for (int j = 0; j <= range / 2; j++) {
            if (t[n][j]) {
                minDiff = Math.min(minDiff, range - 2 * j);
            }
        }
        return minDiff;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends