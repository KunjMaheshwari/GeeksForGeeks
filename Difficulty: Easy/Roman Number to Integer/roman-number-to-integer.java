//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int romanToDecimal(String str) {
        // code here
        int values[] = new int[128];
        
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;
        
        int totalValue = 0;
        int prevValue = 0;
        
        for(int i=str.length()-1;i>=0;i--){
            int currentValue = values[str.charAt(i)];
            
            if(currentValue < prevValue){
                totalValue -= currentValue;
            }else{
                totalValue += currentValue;
            }
            prevValue = currentValue;
        }
        return totalValue;
        
    }
}