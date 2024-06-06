//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution
{
     static boolean isPrime(int  num ){
        
        for(int i = 2 ; i*i <= num;i++ ){
            if(num % i == 0 ) return false; 
        }
        return true ;
    }

    public int[] AllPrimeFactors(int N)
    {
          
        // arraylist as we don't know that how many number 

  //  of  factorsare prime  
        ArrayList<Integer> list = new ArrayList<>();
        
      for(int i = 2 ; i<= N  ;i++){
          
          if(N % i == 0 ){
              
              if(isPrime(i)) list.add(i);
          }
      }
      
     int arr [] = new int [list.size()];
     
     for(int i =0 ;i< arr.length ; i++){
         arr[i] = list.get(i);
     }
      return arr ;
    }
}