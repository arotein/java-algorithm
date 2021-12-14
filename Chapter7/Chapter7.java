package Chapter7;

import java.util.Scanner;
//개방 주소법(Open Addressing)을 이용한 해시테이블
public class Chapter7 {

    public static int[] hashTable = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static int hashFunc(int data) {
        return data % 10;
    }

    public static void main(String[] args) {
        int data, hashValue;
        int pos;

        Scanner scn = new Scanner(System.in);
        do {
            System.out.printf("\n저장할 데이터 : ");
            data = scn.nextInt();

            if (data < 0) {
                break;
            }
            hashValue = hashFunc(data);

            pos = hashValue;
            while (hashTable[pos] != -1) {
                pos++;

                if (pos >= hashTable.length) {
                    pos = 0;
                }
                if (pos == hashValue) {
                    break;
                }
            }
            if (hashTable[pos] == -1) {
                hashTable[pos] = data;
            } else {
                System.out.println("해쉬테이블 꽉 참\n");
            }
        } while (true);

        do {
            System.out.printf("\n탐색할 데이터 : ");
            data = scn.nextInt();

            if (data < 0) {
                break;
            }
            hashValue = hashFunc(data);

            pos = hashValue;

            while (hashTable[pos] != -1 && hashTable[pos] != data) {
                pos++;
                if (pos >= hashTable.length) {
                    pos = 0;
                }

                if (hashTable[pos] == -1 || pos == hashValue) {
                    break;
                }
            }

            if (hashTable[pos] == data) {
                System.out.printf("발견! hashTable[%d]\n", pos);
            } else {
                System.out.println("없음 ㅅㄱ");
            }
        } while (true);
        scn.close();
    }
}
