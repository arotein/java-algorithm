package Chapter6;

public class BinarySearchTree {
    public BST[] tree = new BST[10];

    public final int rootIdx = 0;

    public int newIdx = 0;

    public void addBST(int data) {
        tree[newIdx] = new BST();
        int currentIdx;
        boolean addFlag;

        tree[newIdx].data = data;
        tree[newIdx].left = -1;
        tree[newIdx].right = -1;

        if (newIdx != rootIdx) {
            currentIdx = rootIdx;
            addFlag = false;

            do {
                if (data < tree[currentIdx].data) {
                    if (tree[currentIdx].left == -1) {
                        tree[currentIdx].left = newIdx;
                        addFlag = true;
                    } else {
                        currentIdx = tree[currentIdx].left;
                    }
                } else {
                    if (tree[currentIdx].right == -1) {
                        tree[currentIdx].right = newIdx;
                        addFlag = true;
                    } else {
                        currentIdx = tree[currentIdx].right;
                    }
                }
            } while (!addFlag);
        }
        newIdx++;
    }

    public void printPhysicalBST() {
        int i;
        for (i = 0; i < newIdx; i++) {
            System.out.printf("tree[%d] : data = %d, left = %d, right = %d\n", i, tree[i].data, tree[i].left, tree[i].right);

        }
    }

    public void printLogicalBST(int currentIdx) {
        if (currentIdx != -1) {
            System.out.printf("tree[%d] : data = %d, left = %d, right = %d\n", currentIdx, tree[currentIdx].data, tree[currentIdx].left, tree[currentIdx].right);
            printLogicalBST(tree[currentIdx].left);
            printLogicalBST(tree[currentIdx].right);
        }
    }

    public int searchBST(int data) {
        int idx = -1;
        int currentIdx = rootIdx;

        while (currentIdx != -1) {
            if (tree[currentIdx].data < data) {
                currentIdx = tree[currentIdx].right;
            } else if (tree[currentIdx].data > data) {
                currentIdx = tree[currentIdx].left;
            } else {
                idx = currentIdx;
                break;
            }
        }
        return idx;
    }
}