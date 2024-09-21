//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String l = br.readLine();
            String[] sarr = l.split(" ");
            int[] arr = new int[sarr.length];
            for (int i1 = 0; i1 < arr.length; i1++) {
                arr[i1] = Integer.parseInt(sarr[i1]);
            }

            Solution obj = new Solution();

            int[] res = obj.twoRepeated(n, arr);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {

    // Function to find two repeated elements.

    public int[] twoRepeated(int n, int arr[]) {

        // Your code here

        int a[]=new int[2];

        int g=0;

        HashSet<Integer> d=new HashSet<>();

        for(int i=0;i<arr.length;i++){

            if(d.contains(arr[i])){

                a[g]=arr[i];

                g++;

                if(g==2){

                    break;

                }

            }else{

                d.add(arr[i]);

            }

        }

        return a;

    }

}