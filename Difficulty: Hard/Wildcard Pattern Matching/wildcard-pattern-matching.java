//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        int n = pattern.length(), m = str.length();
        int[][] dp = new int[n][m];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return isValid(pattern, str, n-1, m-1,dp)?1:0;
    }
    private boolean isValid(String pattern, String str, int n, int m, int[][] dp){
        if(n<0 && m<0)
            return true;
        if((n<0 && m>=0) || (m<0 && n>=0 && pattern.charAt(n)!='*'))
            return false;
        if(m<0 && n>=0 && pattern.charAt(n)=='*')
            return isValid(pattern, str, n-1,m, dp);
        if(dp[n][m]!=-1) return dp[n][m]==1? true: false;
        boolean skip = false;
        boolean notSkip = false;
        
        if(pattern.charAt(n)== '*'){
            boolean multiple = isValid(pattern, str, n, m-1, dp);
            boolean empty = isValid(pattern, str, n-1, m, dp);
            boolean one = isValid(pattern, str, n-1, m-1, dp);
            skip = multiple || empty || one;
        }else if(pattern.charAt(n) == '?'){
            skip = isValid(pattern, str, n-1, m-1, dp);
        }
        else if(pattern.charAt(n) == str.charAt(m))
            notSkip = isValid(pattern, str, n-1, m-1, dp);
        dp[n][m] = skip || notSkip? 1:0;
        return skip || notSkip;
    }
}