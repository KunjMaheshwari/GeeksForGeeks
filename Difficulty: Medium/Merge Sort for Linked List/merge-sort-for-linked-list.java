//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution {
    public static Node merge2SortedLinkedList(Node leftHead, Node rightHead) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (leftHead != null) {
            temp.next = leftHead;
        } else {
            temp.next = rightHead;
        }

        return dummyNode.next;
    }

    // Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        // Find the middle point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middleNode = slow;
        Node leftHead = head;
        Node rightHead = middleNode.next;
        middleNode.next = null; // Split the list

        // Recursively sort the sublists
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        // Merge the sorted sublists
        return merge2SortedLinkedList(leftHead, rightHead);
    }
}


