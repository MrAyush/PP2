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
	
	BNode find(int iData) {
		BNode temp = root;
		
		while (temp.getIData() != iData) {
			if (temp.getIData() < iData)
				temp = temp.getLeft();
			else
				temp = temp.getRight();
			if (temp == null)
				return null;
		}
		return temp;		
	}
	
	BNode findMax() {
		BNode temp = root;
		
		while (temp.getRight() != null) {
			temp = temp.getRight();
		}
		System.out.println(temp.getIData());
		return temp;
	}
	
	BNode findMin() {
		BNode temp = root;
		
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		System.out.println(temp.getIData());
		return temp;
	}
	
	BTree delete(int key) {
		BNode temp = root;
		BNode pTemp = root;
		boolean isLeftChild = false;
		
		if (isEmpty())
			return this;
		
		while (temp.getIData() != key) {
			pTemp = temp;
			
			if (temp.getIData() > key) {
				isLeftChild = true;
				temp = temp.getLeft();
			} else {
				isLeftChild = false;
				temp = temp.getRight();
			}
			if (temp == null)
				return this;
		}
		
		/*For leaf nodes*/
		if (temp.getLeft() == null && temp.getRight() == null) {
			if (temp == root)
				root = null;
			else if (isLeftChild)
				pTemp.setLeft(null);
			else
				pTemp.setRight(null);
		}else if (temp.getLeft() == null) {	/*For nodes having one child*/
			if (temp == root)
				root = root.getRight();
			else if (isLeftChild)
				pTemp.setLeft(temp.getRight());
			else
				pTemp.setRight(temp.getRight());
		} else if (temp.getRight() == null) {
			if (temp == root)
				root = root.getLeft();
			else if (isLeftChild)
				pTemp.setLeft(temp.getLeft());
			else
				pTemp.setRight(temp.getLeft());
		} else {	/*For nodes having two childs*/
			BNode it = getSuccessor(temp);
			
			if (temp == root)
				root = it;
			else if (isLeftChild)
				pTemp.setLeft(it);
			else
				pTemp.setRight(it);
				
			it.setLeft(temp.getLeft());
		}
		return this;
	}
	
	private BNode getSuccessor(BNode node) {
		BNode temp = node;
		BNode pTemp = node;
		
		BNode it = temp.getRight();
		
		while (it != null) {
			pTemp = temp;
			temp = it;
			it = it.getLeft();
		}
		
		if (node != pTemp && temp.getRight() != node) {
			pTemp.setLeft(temp.getRight());
			temp.setRight(node.getRight());
		}
		return temp;
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
		/*tree.find(30);
		tree.findMax();
		tree.findMin();*/
		tree.delete(10).display();
	}
}

