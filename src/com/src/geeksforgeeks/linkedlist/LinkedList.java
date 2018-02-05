package com.src.geeksforgeeks.linkedlist;

import java.util.stream.Stream;

public class LinkedList {
	private Node header=null;
	
	//Add a node at the front
	public void addFront(int data){
		Node insertNode=new Node(data);
		if(header==null){
			header=insertNode;
		}else{
			insertNode.setNext(header);
			header=insertNode;
		}
	}
	
	//Add a node after a given node iterative
	public void addAfter(int data,int target){
		Node insertNode=new Node(data);
		if(header==null){
			header=insertNode;
		}else{
			boolean targetfound=false;
			Node temp=header,prev=null;
			while(temp!=null){
				if(temp.getData()==target){
					if(temp.getNext()!=null)
						insertNode.setNext(temp.getNext());
					temp.setNext(insertNode);
					targetfound=true;
				}
				prev=temp;
				temp=temp.getNext();
			}
			if(!targetfound){
				System.out.println("Node "+target+" Not found");
			}
		}
	}
	
	//Add a node after a given node recursive
	public void addAfterRecursive(int data,int target){
		if(header==null){
			header=new Node(data);
		}else{
			if(!addafterRecursive(header,target,data,false)){
				System.out.println("Element "+target+" Not found");
			}
		}
	}
	
	private boolean addafterRecursive(Node currNode,int target,int data,boolean isfound){
		if(currNode==null){
			return isfound;
		}
		else if(currNode.getData()==target){
			Node insertNode=new Node(data);
			if(currNode.getNext()!=null){
				insertNode.setNext(currNode.getNext());
			}
			currNode.setNext(insertNode);
		}else{
			addafterRecursive(currNode.getNext(),target,data,false);
		}
		return isfound;
	}
	
	//Add a node at the end iterative
	public void addEnd(int data){
		if(header==null){
			header=new Node(data);
		}else{
			Node temp=header;
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			temp.setNext(new Node(data));
		}
	}
	
	//Add a node at the end recursive
	public void addEndRecursive(int data){
		if(header==null){
			header=new Node(data);
		}else{
			addEndRecursive(header,data);
		}
	}
	private void addEndRecursive(Node currNode,int data){
		if(currNode==null){
			return;
		}else if(currNode.getNext()==null){
			currNode.setNext(new Node(data));
		}else{
			addEndRecursive(currNode.getNext(),data);
		}
	}
	
	//Find previous node of the node to be deleted iterative
	public void findPreviousDelete(int data){
		boolean elementfound=false;
		if(header!=null){
			Node temp=header,prev=null;
			while(temp!=null){
				if(temp.getData()==data){
					if(prev==null){
						header=temp.getNext();
						System.out.println("Starting element deleted");	
					}if(temp.getNext()!=null){
						prev.setNext(temp.getNext());
					}else{
						prev.setNext(null);
					}
					elementfound=true;
					System.out.println("Previous node is "+prev.getData());
					break;
				}
				prev=temp;
				temp=temp.getNext();
			}
		}
		if(!elementfound){
			System.out.println("Element not found");
		}
	}
	
	//Find previous node of the node to be deleted recursive
	public void findPreviousDeleteRecursive(int data){
		if(!findPreviousDeleteRecursive(header,null,data,false)){
			System.out.println("Element not found");
		}
	}
	private boolean findPreviousDeleteRecursive(Node currNode,Node prevNode,int delete,boolean isdeleted){
		if(currNode!=null){
			if(currNode.getData()==delete){
				if(prevNode==null){
					header=currNode.getNext();
				}
				else if(currNode.getNext()!=null){
					prevNode.setNext(currNode.getNext());
				}else{
					prevNode.setNext(null);
				}
				return true;
			}else{
				findPreviousDeleteRecursive(currNode.getNext(),currNode,delete,false);
			}
		}
		return isdeleted;
	}
	
	//Move last element to first Iterative
	public void moveLastToFirst(){
		Node temp=header;
		Node prev=null;
		while(temp.getNext()!=null){
			prev=temp;
			temp=temp.getNext();
		}
		prev.setNext(null);
		temp.setNext(header);
		header=temp;
	}
	
	// Free memory for the node to be deleted
	public void free(){
		Runtime.getRuntime().freeMemory();
	}
	
	// Delete a linked list node at the given position
	public void deleteAtPosition(int index){
		Node temp=header,prev=null;
		int currindex=0;
		if(index==0){
			header=header.getNext();
		}else{
			while(temp!=null){
				if(index==currindex){
					prev.setNext(temp.getNext());
					break;
				}
				prev=temp;
				temp=temp.getNext();
				currindex++;
			}
		}
	}
	
	//Find Length of a Linked List
	public void length(){
		Node temp=header;
		int length=0;
		while(temp!=null){
			length++;
			temp=temp.getNext();
		}
		System.out.println("length of list is "+length);
	}
	
	// Search an element in a Linked List 
	public void find(int element){
		Node temp=header;
		int index=1;
		while(temp!=null){
			if(temp.getData()==element){
				System.out.println("element found at "+index);
				break;
			}
			index++;
			temp=temp.getNext();
		}
		if(temp==null){
			System.out.println("element not found");
		}
	}
	// Write a function that modify head pointer of a Linked List
	public void modifyHeader(){
		header=header.getNext();
	}
	// Swap nodes in a linked list without swapping data
	public void swapNodes(){
		Node curr=header,prev=null,next=null;
		prev=curr;
		curr=curr.getNext();
		next=curr.getNext();
		header=curr;
		curr.setNext(prev);
		prev.setNext(next);
		curr=next;
		next=curr.getNext();
		System.out.println(this);
		prev=curr;
		curr=curr.getNext();
		next=curr.getNext();
		System.out.println(this);
	}
	
	public String toString() {
		StringBuffer result=new StringBuffer();
		Node temp=header;
		while(temp!=null){
			result.append(temp.getData()+",");
			temp=temp.getNext();
		}
		return result.substring(0,result.length()-1);
	}
}
