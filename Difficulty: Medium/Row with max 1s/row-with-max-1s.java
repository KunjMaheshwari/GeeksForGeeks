//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int max = -1;
        int idx = -1;
        
        for(int i=0;i<arr.length;i++){
            int start = 0;
            int end = arr[i].length-1;
            int mid;
            
            while(start <= end){
                mid = (start+end)/2;
                if(arr[i][mid] == 0){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            if(start < arr[i].length){
                if(max < arr[i].length-1-start){
                    max = arr[i].length-1-start;
                    idx = i;
                }
            }
        }
        return idx;
    }
}