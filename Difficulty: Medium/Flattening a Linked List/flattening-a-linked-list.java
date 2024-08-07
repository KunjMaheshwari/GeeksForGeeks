//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

class Flatttening_A_LinkedList {
    Node head;

    void printList(Node node) {
        // Node temp = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
        while (t > 0) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }
            }
            // list.printList();
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
class GfG {
    Node merge2LinkedList(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.bottom = head1;
                head1 = head1.bottom;
            } else {
                temp.bottom = head2;
                head2 = head2.bottom;
            }
            temp = temp.bottom;
        }

        // Attach remaining nodes
        if (head1 != null) {
            temp.bottom = head1;
        } else {
            temp.bottom = head2;
        }

        return dummyNode.bottom;
    }

    Node flatten(Node root) {
        // Base case
        if (root == null || root.next == null) {
            return root;
        }

        // Recursively flatten the next list
        root.next = flatten(root.next);

        // Merge this list with the next list
        root = merge2LinkedList(root, root.next);

        return root;
    }
}