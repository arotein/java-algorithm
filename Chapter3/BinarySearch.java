package Chapter3;

import java.util.Scanner;

public class BinarySearch {
    public void run() {
        int[] a = {39, 41, 53, 55, 68, 72, 84, 88, 92, 97};
        int left = 0;
        int right = a.length - 1;
        int pos = -1;

        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        scn.close();

        while (pos == -1 && left <= right) {
            int middle = (left + right) / 2;
            if (a[middle] == x) {
                pos = middle;
            } else if (a[middle] > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println("pos : " + pos);
    }
}
