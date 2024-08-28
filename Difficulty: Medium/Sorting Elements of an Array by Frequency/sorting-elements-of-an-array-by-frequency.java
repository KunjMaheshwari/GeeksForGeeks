//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java
import java.util.*;

class Solution {
    // Function to sort the array according to the frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // Sort the array first to handle elements with the same frequency
        Arrays.sort(arr);
        
        // Create a frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // Convert the map to a list of elements
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        
        // Sort the list by frequency, then by value
        Collections.sort(list, (a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey() - b.getKey(); // If frequencies are the same, sort by value
            } else {
                return b.getValue() - a.getValue(); // Sort by frequency (descending)
            }
        });
        
        // Create a result list
        ArrayList<Integer> newArr = new ArrayList<>();
        
        // Add elements to the result list according to their frequency
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                newArr.add(entry.getKey());
            }
        }
        
        return newArr;
    }
}


//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends