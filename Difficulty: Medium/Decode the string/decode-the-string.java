//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends






class Solution {
    static String decodeString(String s) {
        // code here
        StringBuilder sb=new StringBuilder("");
        Stack<StringBuilder> st=new Stack<>();
        Stack<Integer> cnt=new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int count=0;
                while(Character.isDigit(s.charAt(i))){
                    count=count*10+(s.charAt(i)-'0');
                    i++;
                }
                cnt.push(count);
            }
            else if(ch=='['){
              st.push(sb);
              sb=new StringBuilder("");
              i++;
            }
           else if(ch==']'){
                StringBuilder prev=st.pop();
                int n=cnt.pop();
                for(int j=0; j<n; j++){
                    prev.append(sb);
                }
                sb=prev;
                i++;
               
            }
            else{
                sb.append(ch);
                i++;
            }
        }
        return sb.toString();
    }
}