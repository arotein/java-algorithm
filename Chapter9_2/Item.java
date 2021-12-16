package Chapter9_2;

public class Item {
    String name;
    int weight, value;

    Item() {
        this("", 0, 0);
    }

    Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}
