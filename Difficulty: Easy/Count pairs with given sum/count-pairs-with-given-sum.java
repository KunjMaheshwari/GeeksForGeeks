//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(read.readLine().trim());
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            int ans = obj.getPairsCount(nums, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int sum) {
        // HashMap to store the frequency of each element
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the complement
            int complement = sum - arr[i];
            
            // Check if the complement exists in the hash map
            if (freq.containsKey(complement)) {
                count += freq.get(complement);
            }
            
            // Update the frequency of the current element in the hash map
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }

        return count;
    }
}
