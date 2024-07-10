//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {

    static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline character after reading t

        while (t-- > 0) {
            String input = sc.nextLine();
            Scanner s = new Scanner(input);
            Node head = null, tail = null;
            boolean isFirst = true;

            while (s.hasNext()) {
                int x = s.nextInt();
                if (isFirst) {
                    head = new Node(x);
                    tail = head;
                    isFirst = false;
                } else {
                    tail.next = new Node(x);
                    tail = tail.next;
                }
            }
            s.close();

            Solution ob = new Solution();
            Node ans = ob.zigZag(head);
            print(ans);
            System.out.println();
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Node is as follows:

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

*/
class Solution {
    Node zigZag(Node head) {
        // if the list is empty or has only one element, no need to rearrange
        if (head == null || head.next == null) return head;

        // flag true indicates relation "<" is expected,
        // else ">" is expected. The first relation is "<".
        boolean flag = true;

        Node current = head;
        while (current != null && current.next != null) {
            if (flag) {
                // "<" relation expected
                if (current.data > current.next.data) {
                    // swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            } else {
                // ">" relation expected
                if (current.data < current.next.data) {
                    // swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
            // flip the flag for the next pair
            flag = !flag;
            // move to the next pair
            current = current.next;
        }
        return head;
    }
}