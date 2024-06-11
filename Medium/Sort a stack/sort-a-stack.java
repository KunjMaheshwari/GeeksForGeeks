//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
        
    public Stack<Integer> sort(Stack<Integer> st) {
        // add code here.
        if(st.size() == 1){
            return st;
        }
        int temp = st.pop();
        sort(st);
        
        return insertElementAtStack(st, temp);
    }
    public static Stack<Integer> insertElementAtStack(Stack<Integer> st, int temp){
        // base condition
        if(st.size() == 0 || temp>= st.peek()){
            st.push(temp);
            return st;
        }
        
        // hypothesis
        
        int val = st.pop();
        insertElementAtStack(st, temp);
        
        st.push(val);
        return st;
    }
}