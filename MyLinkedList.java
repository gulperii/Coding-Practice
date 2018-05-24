class Node {
	public int value;
	public Node next;

	public Node(int val) {
		value = val;
		next = null;
	}
}

public class MyLinkedList {
	Node head = null;
	Node tail = null;

	public void add(int a) {
		// Adds a new node that contains the value 'a' to the end of the list
		Node newNode = new Node(a);
		if (head == null)
			head = tail = newNode;
		else {
			Node current = head;
			while(current.next != null)
				current = current.next;
			tail = current.next = newNode;
		}
	}
	 public int getCountRec(Node node)
	    {
	        // Base case
	        if (node == null)
	            return 0;
	 
	        // Count is this node plus rest of the list
	        return 1 + getCountRec(node.next);
	    }
	public void insert(int val, int index)
	{
		// Inserts a new node that contains the value 'a' at 'index.
		// If index is beyond the end of the list, it should be added as the last element.

		Node newNode = new Node(val);
		Node current = head;
		int currentIndex = 0;
		
		if (index == 0) {
			// newNode must be the new head
			newNode.next = head;   // If head was null, no problem.
			head = newNode;
			if (head.next == null) {
				// This is the only node in the list. Update also tail.
				tail = head;
			}
			return;   // We are done. Skip the rest of the method.
		}
		
		// If we reach this point, we are sure current is not null.
		// Iterate until current is the node before insertion point.
		while ((currentIndex!=index-1) && (current.next!=null)) {
			current = current.next;
			currentIndex++;
		}
		
		// newNode should be inserted after 'current'.
		if (current.next==null) {
			// newNode is to become the last node.
			newNode.next=null;
			current.next=newNode;
			tail=newNode;
		}
		else {
			newNode.next=current.next;
			current.next=newNode;
		}
	}
	
	@Override
	public String toString() {
		String result = "[";

		if (head != null) {
			Node current = head;
			while(current.next != null) {
				result += current.value+", ";
				current = current.next;
			}
			result += current.value;
		}
		result += "]";
		return result;
	}
}
