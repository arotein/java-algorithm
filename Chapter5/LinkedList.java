package Chapter5;

//단방향 연결 리스트(Singly Linked List)
public class LinkedList {
    public static StationList[] list = new StationList[10];
    public static int head;

    public static void initStationList() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new StationList();
        }

        list[0].name = "부산";
        list[0].next = -1;
        list[1].name = "대전";
        list[1].next = 3;
        list[2].name = "서울";
        list[2].next = 4;
        list[3].name = "동대구";
        list[3].next = 0;
        list[4].name = "천안아산";
        list[4].next = 1;

        head = 2;
    }

    public static void printStationList() {
        int idx = head;
        while (idx != -1) {
            System.out.printf("[%s] → ", list[idx].name);
            idx = list[idx].next;
        }
        System.out.println();
    }

    public static void insertStationList(int insIdx, String insName, int prevIdx) {
        list[insIdx].name = insName;
        list[insIdx].next = list[prevIdx].next;
        list[prevIdx].next = insIdx;
    }

    public static void deleteStationList(int delIdx, int prevIdx) {
        list[prevIdx].next = list[delIdx].next;
    }
}
