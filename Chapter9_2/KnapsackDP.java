package Chapter9_2;

//DP를 이용한 풀이
public class KnapsackDP {
    public int KNAP_MAX = 6;
    public int ITEM_NUM = 5;
    Item[] items = new Item[5];
    public int[][] maxValue = new int[ITEM_NUM][KNAP_MAX + 1];

    KnapsackDP() {
        items[0] = new Item("A", 1, 100);
        items[1] = new Item("B", 2, 300);
        items[2] = new Item("C", 3, 350);
        items[3] = new Item("D", 4, 500);
        items[4] = new Item("E", 5, 650);
    }

    public void showKnap(int itemIdx) {
        int knap;

        System.out.printf("<%s, %dkg, %d원을 고려한 결과>\n", items[itemIdx].name, items[itemIdx].weight, items[itemIdx].value);

        for (knap = 0; knap <= KNAP_MAX; knap++) {
            System.out.printf("%dkg\t", knap);
        }
        System.out.println();

        for (knap = 0; knap <= KNAP_MAX; knap++) {
            System.out.printf("%d원\t", maxValue[itemIdx][knap]);
        }
        System.out.println();
    }

    public void run() {
        int itemIdx, knap, selVal, totalWeight;
        itemIdx = 0;
        for (knap = 0; knap <= KNAP_MAX; knap++) {
            if (items[itemIdx].weight <= knap) {
                maxValue[itemIdx][knap] = items[itemIdx].value;
            } else {
                maxValue[itemIdx][knap] = 0;
            }
        }
        showKnap(itemIdx);

        for (itemIdx = 1; itemIdx < ITEM_NUM; itemIdx++) {
            for (knap = 0; knap <= KNAP_MAX; knap++) {
                if (items[itemIdx].weight <= knap) {
//                    selVal : itemIdx를 고려한 값
                    selVal = maxValue[itemIdx - 1][knap - items[itemIdx].weight] + items[itemIdx].value;
                    if (selVal > maxValue[itemIdx - 1][knap]) {
                        maxValue[itemIdx][knap] = selVal;
                    } else {
                        maxValue[itemIdx][knap] = maxValue[itemIdx - 1][knap];
                    }
                } else {
                    maxValue[itemIdx][knap] = maxValue[itemIdx - 1][knap];
                }
            }
            showKnap(itemIdx);
        }
        System.out.printf("최댓값 : %d원\n", maxValue[ITEM_NUM - 1][KNAP_MAX]);
    }
}
