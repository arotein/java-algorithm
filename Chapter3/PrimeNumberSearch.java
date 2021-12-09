package Chapter3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class PrimeNumberSearch {
    //  특정한 수가 소수인지 체크 (2부터 절반까지 찾음)
    public void run() {
        Scanner scn = new Scanner(System.in);
        System.out.printf("2이상의 정수를 입력 : ");
        long num = scn.nextLong();
        scn.close();
        long primeFactor = 1;
        boolean prime = true;

        long start = System.nanoTime();
        for (long i = 2; i <= (long) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                prime = false;
                primeFactor = i;
                break;
            }
        }
        long end = System.nanoTime();

        if (prime == false) {
            System.out.println(num + "은 합성수");
            System.out.printf("%d * %d = %d\n", primeFactor, num / primeFactor, num);
        } else {
            System.out.println(num + "은 소수");
        }
        System.out.println("소요시간 : " + (end - start) + "ns");

    }

    public boolean checkPrime(long num) {
        boolean prime = true;

        for (long i = 2; i <= (long) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            return true;
        } else {
            return false;
        }
    }

    //    2부터 특정 수 까지 모든 소수를 찾아 메모장에 저장
    public void run2() {
        Scanner scn = new Scanner(System.in);
        System.out.printf("4이상의 정수를 입력 : ");
        long num = scn.nextLong();
        scn.close();

        String filePath = "C:/Users/Chanu/Desktop/Temp/";
        String fileName = "1부터 " + num + "까지 소수.txt";

        File file = new File(filePath + fileName);
        try {
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }
            Writer writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("2\n");
            bw.write("3\n");

            long start = System.nanoTime();
            for (long k = 4; k <= num; k++) {
                boolean result = checkPrime(k);
                if (result) {
                    bw.write(String.valueOf(k));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
            writer.close();
            long end = System.nanoTime();
            System.out.println("소요시간 : " + (float) (end - start) / 1000000000 + "s");
        } catch (Exception e) {
            System.out.println("오류발생");
        }
    }
}
