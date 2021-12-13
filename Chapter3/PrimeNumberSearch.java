package Chapter3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class PrimeNumberSearch {
    //num은 2 이상의 정수
    public boolean checkPrime(long num) {
        if (num == 2) {
            return true;
        }
        for (long i = 2L; i <= (long) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //num이 합성수 일 때 소인수를 찾음
    public void getPrimeFactor(long num) {
        if (checkPrime(num)) {
            System.out.printf("%d : 소수\n", num);
        } else {
            System.out.printf("%d : 합성수\n", num);
            for (long i = 2L; i <= (long) Math.sqrt(num) + 1; i++) {
                if (num % i == 0) {
                    System.out.printf("%d x %d\n", i, num / i);
                }
            }
        }
    }

    //1부터 num까지의 정수 중 소수를 출력
    public void printPrime(long num) {
        for (long i = 2L; i <= num; i++) {
            if (checkPrime(i)) {
                System.out.printf("%d\n", i);
            }
        }
    }

    //1부터 num까지의 정수 중 소수를 .txt파일로 저장
    public void savePrime(int num) {
        String fileName = "1부터 " + num + "까지의 소수.txt";

        //저장경로 재설정 필요
        String savePath = "C:/Users/9cksq/Desktop/temp/";

        File file = new File(savePath + fileName);
        try {
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }

            Writer writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("<1부터 " + num + "까지의 소수>");
            bw.newLine();
            for (int i = 2; i <= num; i++) {
                if (checkPrime(i)) {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
            writer.close();
            System.out.println("저장완료");

        } catch (Exception e) {
            System.out.println("에러발생");
        }
    }
}
