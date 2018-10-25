import java.util.Stack;

class BNode {
    private int iData;

    private char cData;

    private BNode left;
    private BNode right;

    BNode(int x) {
        iData = x;
        left = null;
        right = null;
    }

    BNode(char x) {
        cData = x;
        left = null;
        right = null;
    }

    public char getCData() {
        return cData;
    }

    public void setcData(char cData) {
        this.cData = cData;
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
    public static final String IN_ORDER = "inorder";
    public static final String POST_ORDER = "postorder";
    public static final String PRE_ORDER = "preorder";

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
        } else if (temp.getLeft() == null) {    /*For nodes having one child*/
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
        } else {    /*For nodes having two childs*/
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
        display(IN_ORDER);
    }

    private void displayIn(BNode root) {
        if (root != null) {
            displayIn(root.getLeft());
            System.out.println(root.getIData());
            displayIn(root.getRight());
        }
    }

    private void displayPre(BNode root) {
        if (root != null) {
            System.out.println(root.getIData());
            displayPre(root.getLeft());
            displayPre(root.getRight());
        }
    }

    private void displayPost(BNode root) {
        if (root != null) {
            displayPost(root.getLeft());
            displayPost(root.getRight());
            System.out.println(root.getIData());
        }
    }

    void display(String order) {
        switch (order) {
            case IN_ORDER:
                displayIn(root);
                break;
            case POST_ORDER:
                displayPost(root);
                break;
            case PRE_ORDER:
                displayPre(root);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    void displayTree() {
        displayTree(true);
    }

    void displayTree(boolean isChar) {
        Stack<BNode> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) {
            Stack<BNode> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                BNode temp = globalStack.pop();
                if (temp != null) {
                    if (!isChar)
                        System.out.print(temp.getIData());
                    else
                        System.out.print(temp.getCData());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null || temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            } // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        } // end while isRowEmpty is false
        System.out.println("......................................................");
    }

    BTree makeLetterTree(String s) {
        if (s.isEmpty())
            return null;
        BTree tree = new BTree();
        int i = 1;
        if (s.length() >= 2) {
            while (i < s.length()) {
                BNode node = new BNode('+');
                if (tree.isEmpty()) {
                    node.setLeft(new BNode(s.charAt(0)));
                    node.setRight(new BNode(s.charAt(1)));
                } else {
                    node.setLeft(tree.root);
                    node.setRight(new BNode(s.charAt(i)));
                }
                tree.root = node;
                i++;
            }
        } else {
            tree.root = new BNode('+');
            tree.root.setLeft(new BNode(s.charAt(0)));
        }
        return tree;
    }

}

public class BinaryTree {
    public static void main(String[] args) {
        BTree tree = new BTree();
        //tree.insert(30).insert(40).insert(10).insert(20).displayTree();
		/*tree.find(30);
		tree.findMax();
		tree.findMin();*/
        //tree.delete(10).display();
        tree.makeLetterTree("ABCDE").displayTree();
    }
}

