//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends




class Solution {
    long[][][] dp= new long[26][5][4];
    int[][] a=new int[4][3];
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    long solve(int i,int k,int j,int n){
        if(i==n)return 1;
        if(dp[i][k][j]!=-1)return dp[i][k][j];
        long ans=0;
        ans+=solve(i+1,k,j,n);
        for(int x=0;x<4;x++){
            int newx=k+dx[x];
            int newy=j+dy[x];
            if(newx>=0 && newy>=0 && newx<4 && newy<3 && a[newx][newy]!=-1){
                ans+=solve(i+1,newx,newy,n);
            }
        }
        return dp[i][k][j]=ans;
    }
    
    public long getCount(int n) {
        for(int i=0;i<26;i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<4;k++)dp[i][j][k]=-1;
            }
        }
        for(int[] r:a)Arrays.fill(r,-1);
        
        int num=1;
        a[3][1]=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)a[i][j]=num++;
        }
        
       
        
        long ans=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(a[i][j]==-1)continue;
                ans+=solve(1,i,j,n);
            }
        }
        return ans;
    }
}