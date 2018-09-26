class BNode {
	private int iData;
	private BNode left;
	private BNode right;
	
	BNode(int x) {
		iData = x;
		left = null;
		right = null;
	}
	
	void setIData(int iData) {
		this.iData = iData;
	}
	
	void setLeft(BNode left) {
		this.left = left;
	}
	
	void setRight(BNode right) {
		this.right = right;
	}
	
	int getIData() {
		return iData;
	}
	
	BNode getLeft() {
		return left;
	}
	
	BNode getRight() {
		return right;
	}
}

class BTree {
	private BNode root;
	
	BTree() {
		root = null;
	}
	
	boolean isEmpty() {
		return root == null;
	}
	
	BTree insert(int iData) {
		BNode node = new BNode(iData);
		
		if (isEmpty()) {
			root = node;
		} else {
			BNode temp = root;
			BNode t = root;
			
			while (temp != null) {
				if (node.getIData() > temp.getIData()) {
					t = temp;
					temp = temp.getRight();
				} else if (node.getIData() < temp.getIData()) {
					t = temp;
					temp = temp.getLeft();
				} else {
					return this;
				}
			}
			if (t.getIData() > node.getIData()) {
				t.setLeft(node);
			} else {
				t.setRight(node);
			}
		}
		return this;
	}
	
	void display() {
		display(root);
	}
	
	private void display(BNode root) {
		if (root != null) {
			display(root.getLeft());
			System.out.println(root.getIData());
			display(root.getRight());
		}
	}
}

public class BinaryTree {
	public static void main(String[] args) {
		BTree tree = new BTree();
		tree.insert(30).insert(40).insert(10).insert(20).display();
	}
}

