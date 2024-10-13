//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;


// } Driver Code Ends
class Solution {
    public String maximumFrequency(String str) {
        // Your Code goes here
        String words[] = str.split("\\s+");
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        int maxFreq = 0;
        String maxFreqWord = "";
        
        for(String word : words){
            int freq = map.get(word);
            
            if(freq > maxFreq){
                maxFreqWord = word;
                maxFreq = freq;
            }
        }
        return maxFreqWord +" "+ maxFreq;
        
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            Solution sol = new Solution();
            System.out.println(sol.maximumFrequency(str));
        }

        sc.close();
    }
}

// } Driver Code Ends