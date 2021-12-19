package Chapter8;

//기준값을 기준의 첫 번째 요소로 했을 경우
public class QuickSort {
    public int divideArray(int[] a, int head, int tail) {
        int left, right, temp;
        left = head + 1;
        right = tail;

        while (true) {

            while (left < tail && a[head] > a[left]) {
                left++;
            }

            while (a[head] < a[right]) {
                right--;
            }

            if (left >= right) {
                break;
            }
            temp = a[right];
            a[right] = a[left];
            a[left] = temp;

            left++;
            right--;
        }
        temp = a[head];
        a[head] = a[right];
        a[right] = temp;

        return right;
    }

    public void sortArray(int[] a, int start, int end) {
        int pivot;

        if (start < end) {
            pivot = divideArray(a, start, end);
            sortArray(a, start, pivot - 1);
            sortArray(a, pivot + 1, end);
        }
    }
}
