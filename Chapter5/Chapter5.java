package Chapter5;

public class Chapter5 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.initStationList();
        list.printStationList();

        list.insertStationList(5, "울산", 2);
        list.printStationList();

        list.deleteStationList(5, 2);
        list.printStationList();

    }
}
