//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Trie {
    int freq;
    Trie[] child;
    public Trie() {
        this.freq = 0;
        this.child = new Trie[26];
    }
}

class Solution {
    

    static String[] findPrefixes(String[] arr, int N) {
        final Trie root = new Trie();
        
        for(int i = 0; i < N; i++){
            buildTrie(arr[i], root);
        }
        
        String[] ans = new String[N];
        for(int i = 0; i < N; i++) {
            ans[i] = buildPrefix(arr[i], root);
        }
        
        return ans;
    }
    
    public static void buildTrie(String s, Trie root){
        Trie cur = root;
        for(char ch : s.toCharArray()) {
            int index = ch - 'a';
            if(cur.child[index] == null)
                cur.child[index] = new Trie();
            cur.child[index].freq++;
            cur = cur.child[index];
        }
    }
    
    public static String buildPrefix(String s, Trie root) {
        Trie cur = root;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            int index = ch - 'a';
            sb.append(ch);
            
            if(cur.child[index].freq == 1) break;
                
            cur = cur.child[index];
        }
        return sb.toString();
    }
};