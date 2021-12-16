package Chapter9_2;

//32가지의 모든 경우의 수를 계산하는 방법
public class AllCases {
    int itemNum = 5;
    int maxWeight = 6;
    Item[] items = new Item[itemNum];
    Item[] result = new Item[(int) Math.pow(2, 5)];

    public void initItems() {
        for (int k = 0; k < result.length; k++) {
            result[k] = new Item();
        }

        items[0] = new Item("A", 1, 100);
        items[1] = new Item("B", 2, 300);
        items[2] = new Item("C", 3, 350);
        items[3] = new Item("D", 4, 500);
        items[4] = new Item("E", 5, 650);
    }

    public void printValidItem() {
        for (int i = 0; i < 32; i++) {
            if (result[i].weight > 0 && result[i].weight <= maxWeight) {
                System.out.printf("물건 : %s, 무게 : %dkg, 값 : %d원\n", result[i].name, result[i].weight, result[i].value);
            }
        }
    }

    public void func(Item[] result, int idx, int head, int tail) {
        if (idx < 5 && head != tail) {
            for (int i = (head + tail + 1) / 2; i <= tail; i++) {
                result[i].name += items[idx].name;
                result[i].weight += items[idx].weight;
                result[i].value += items[idx].value;
            }
            func(result, idx + 1, head, (head + tail) / 2);
            func(result, idx + 1, ((head + tail) / 2) + 1, tail);
        }
    }

    public void run() {
        func(result, 0, 0, result.length - 1);
    }

    public int getMaxValue() {
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (max < result[i].value && result[i].weight <= maxWeight) {
                max = result[i].value;
            }
        }
        return max;
    }
}
