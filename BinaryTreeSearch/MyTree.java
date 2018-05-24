


import java.util.ArrayList;

public class MyTree {

	public MyNode root = null;

	public void add(int v) {
		if (root == null) {
			root = new MyNode(v);
		} else {
			MyNode current = root;
			MyNode parentOfCurrent = null;
			while (current != null) {
				parentOfCurrent = current;
				if (v > current.value) {
					current = current.right;
				} else {
					current = current.left;
				}
			}

			if (v > parentOfCurrent.value) {
				parentOfCurrent.right = new MyNode(v);
			} else {
				parentOfCurrent.left = new MyNode(v);
			}
		}
	}

	public String preOrderVisit(MyNode n) {
		String s = "";
		if (n != null) {
			s += n.value + ",";

			if (n.left != null)
				s += preOrderVisit(n.left);

			if (n.right != null)
				s += preOrderVisit(n.right);
		}
		return s;
	}

	public String inOrderVisit(MyNode n) {
		String s = "";
		if (n != null) {
			if (n.left != null)
				s += inOrderVisit(n.left);
			s += n.value + ",";
			if (n.right != null)
				s += inOrderVisit(n.right);
		}
		return s;
	}

	public String postOrderVisit(MyNode n) {
		String s = "";
		if (n != null) {
			if (n.left != null)
				s += postOrderVisit(n.left);

			if (n.right != null)
				s += postOrderVisit(n.right);

			s += n.value + ",";
		}
		return s;
	}

	public void printPreOrder() {
		preOrderVisit(root);
	}

	public String printInOrder() {
		return inOrderVisit(root);
	}

	public void printPostOrder() {
		postOrderVisit(root);
	}

	public String bft() {
		String s = "";
		ArrayList<MyNode> st = new ArrayList<MyNode>();

		st.add(root);
		while (!st.isEmpty()) {
			MyNode n = st.remove(0);

			if (n.left != null) {
				st.add(n.left);
			}
			if (n.right != null) {
				st.add(n.right);
			}
			s += n.value + ",";
		}
		if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == ',') {
			s = s.substring(0, s.length() - 1);
		}
		return s;
	}
}
