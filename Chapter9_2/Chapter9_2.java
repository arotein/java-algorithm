package Chapter9_2;

//배낭문제(knapsack problem)
public class Chapter9_2 {
    public static void main(String[] args) {
        AllCases ac = new AllCases();
        ac.initItems();
        ac.run();
        ac.printValidItem();
        System.out.println(ac.getMaxValue());

        System.out.println("------------------");

        KnapsackDP dp = new KnapsackDP();
        dp.run();
    }
}
