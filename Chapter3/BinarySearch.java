package Chapter3;

import java.util.Scanner;

public class BinarySearch extends PrintArray {
    //    정렬된 배열이 주어지고 값을 입력받아서 배열안에 들어있는 값인지 확인
    public void run(int... a) {
        int left = 0;
        int right = a.length - 1;
        int pos = -1;

        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        scn.close();

        printIntArray(a);
        while (pos == -1 && left <= right) {
            int middle = (left + right) / 2;
            if (input < a[middle]) {
                right = middle - 1;
            } else if (a[middle] < input) {
                left = middle + 1;
            } else {
                pos = middle;
            }
        }
        System.out.printf("pos : %d\n", pos);
    }
}
