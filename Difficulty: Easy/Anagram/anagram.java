//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            Solution obj = new Solution();

            if (obj.isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to check whether two strings are anagrams of each other
    public static boolean isAnagram(String str1, String str2) {

        // If the lengths are not equal, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a HashMap to count the frequency of characters in str1
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequencies of characters in str1
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrease the frequency of characters while processing str2
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);

            // If the character doesn't exist in the map or its frequency is 0, return false
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }

            // Decrement the frequency of the character
            map.put(ch, map.get(ch) - 1);
        }

        // If all characters matched, the strings are anagrams
        return true;
    }
}
