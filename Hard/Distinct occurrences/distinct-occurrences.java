//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends




/*You are required to complete this method*/

class Solution
{
    static int mod = 1000000007;
    int  subsequenceCount(String s, String t)
    {
        int dp[][] = new int[s.length()][t.length()];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int count = solve(s,t,dp,0,0);
        return count;
    }
    public static int solve(String s,String t,int dp[][],int sPos,int tPos){
        
        if(tPos==t.length()){
            return 1;
        }
        if(sPos == s.length()){
            return 0;   
        }
        if(dp[sPos][tPos]!=-1){
            return dp[sPos][tPos];
        }
        if(s.charAt(sPos)==t.charAt(tPos)){
            return dp[sPos][tPos] = (solve(s,t,dp,sPos+1,tPos+1) + solve(s,t,dp,sPos+1,tPos))%mod;    
        }
        return dp[sPos][tPos] = solve(s,t,dp,sPos+1,tPos);	
    }
}