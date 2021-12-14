package Chapter6;

public class Chapter6 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.addBST(4);
        bst.addBST(6);
        bst.addBST(5);
        bst.addBST(2);
        bst.addBST(3);
        bst.addBST(7);
        bst.addBST(1);

        bst.printPhysicalBST();
        System.out.println("--------------------------");
        bst.printLogicalBST(bst.rootIdx);
        System.out.println("--------------------------");
        int serchNum = 5;
        System.out.printf("찾는 값 : %d\n결과 : tree[%d]\n", serchNum, bst.searchBST(serchNum));
    }
}
