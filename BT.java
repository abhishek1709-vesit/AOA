class BTreeNode {
    int[] keys = new int[3];
    BTreeNode[] child = new BTreeNode[4];
    int n = 0;
    boolean leaf = true;
}

class BTree {
    BTreeNode root = new BTreeNode();

    void insert(int key) {
        BTreeNode r = root;

        if (r.n == 3) {
            BTreeNode s = new BTreeNode();
            s.leaf = false;
            s.child[0] = r;

            splitChild(s, 0);

            root = s;
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    void splitChild(BTreeNode parent, int i) {
        BTreeNode y = parent.child[i];
        BTreeNode z = new BTreeNode();

        z.leaf = y.leaf;
        z.n = 1;
        z.keys[0] = y.keys[2];

        if (!y.leaf) {
            z.child[0] = y.child[2];
            z.child[1] = y.child[3];
        }

        y.n = 1;

        for (int j = parent.n; j >= i + 1; j--) {
            parent.child[j + 1] = parent.child[j];
        }

        parent.child[i + 1] = z;

        for (int j = parent.n - 1; j >= i; j--) {
            parent.keys[j + 1] = parent.keys[j];
        }

        parent.keys[i] = y.keys[1];
        parent.n++;
    }

    void insertNonFull(BTreeNode node, int key) {
        int i = node.n - 1;

        if (node.leaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }

            node.keys[i + 1] = key;
            node.n++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }

            i++;

            if (node.child[i].n == 3) {
                splitChild(node, i);

                if (key > node.keys[i]) {
                    i++;
                }
            }

            insertNonFull(node.child[i], key);
        }
    }

    void inorder(BTreeNode node) {
        int i;

        for (i = 0; i < node.n; i++) {
            if (!node.leaf) {
                inorder(node.child[i]);
            }

            System.out.print(node.keys[i] + " ");
        }

        if (!node.leaf) {
            inorder(node.child[i]);
        }
    }
}

public class BT {
    public static void main(String[] args) {
        BTree tree = new BTree();

        int[] values = {10, 20, 5, 6, 12, 30, 7, 17};

        for (int value : values) {
            tree.insert(value);
        }

        System.out.print("B-Tree Traversal: ");
        tree.inorder(tree.root);
    }
}