//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java'

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        // Sort both Arrival and Departure arrays
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int platformsNeeded = 0; // Tracks platforms needed at any point
        int maxPlatforms = 0;    // Tracks the maximum platforms required

        int i = 0, j = 0;
        int n = Arrival.length;

        // Process arrival and departure times
        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                // A train has arrived; increment platforms needed
                platformsNeeded++;
                i++;
            } else {
                // A train has departed; decrement platforms needed
                platformsNeeded--;
                j++;
            }
            // Update the maximum platforms required
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }
}
