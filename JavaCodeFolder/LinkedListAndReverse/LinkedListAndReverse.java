/* Create a linked list of numbers, write a function to print the numbers in the linked list. Write a function that will reverse the linked list, and print it. */

import java.util.Scanner;

class Node{
	int data;
	Node next;

	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class LinkedListAndReverse{
	
	static Node createLinkedList(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of nodes: ");
		int n = sc.nextInt();

		Node head = null;
		Node temp = null;

		for(int i=1; i<=n; i++){
			System.out.println("Enter data: ");
			int value = sc.nextInt();

			Node newNode = new Node(value);

			if(head == null){
				head = newNode;
				temp = head;
			}else{
				temp.next = newNode;
				temp = newNode;
			}
		}
		return head;
	}

	static void printList(Node head){

		Node temp = head;

		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	static Node reverseList(Node head){
		Node prev = null;
		Node current = head;
		Node next = null;

		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void main(String[] args){

		Node head = createLinkedList();

		System.out.println("Original Linked List:");
		printList(head);

		head = reverseList(head);

		System.out.println("Reversed Linked List:");
		printList(head);
	}
}