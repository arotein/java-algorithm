package Chapter3;

public class Chapter3 {
    public static void main(String[] args) {
        int[] a = {39, 41, 53, 55, 68, 72, 84, 88, 92, 97};
        BinarySearch bs = new BinarySearch();
        bs.run(a);

        PrimeNumberSearch pns = new PrimeNumberSearch();
        pns.getPrimeFactor(102849178501914277L);
//        pns.savePrime(10000);
    }
}
