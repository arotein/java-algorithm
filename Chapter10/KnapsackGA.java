package Chapter10;

public class KnapsackGA {
    // 최대무게, 물건종류, 개체수, 돌연변이확률
    public int KNAP_MAX = 6;
    public int ITEM_NUM = 5;
    public int IND_NUM = 8;
    public double MUTATE_RATE = 0.1;

    // 물건들
    public char[] itemName = {'A', 'B', 'C', 'D', 'E'};
    public int[] itemWeight = {1, 2, 3, 4, 5};
    public int[] itemValue = {100, 300, 350, 500, 650};

    public int indGeneration;                               // 개체의 세대
    public int[][] indGene = new int[IND_NUM][ITEM_NUM];    // 개체의 유전자
    public int[] indWeight = new int[IND_NUM];              // 개체의 무게
    public int[] indValue = new int[IND_NUM];               // 개체의 가치
    public int[] indFitness = new int[IND_NUM];             // 개체의 적응도

    // 개체 무작위 생성
    public void createIndividual() {
        int ind, item;

        for (ind = 0; ind < IND_NUM; ind++) {
            for (item = 0; item < ITEM_NUM; item++) {
                indGene[ind][item] = Math.random() > 0.5 ? 0 : 1;
            }
        }
    }

    // 개체의 무게, 가치, 적응도 계산
    public void calcIndividual() {
        int ind, item;
        for (ind = 0; ind < IND_NUM; ind++) {
            indWeight[ind] = 0;
            indValue[ind] = 0;
            for (item = 0; item < ITEM_NUM; item++) {
                if (indGene[ind][item] == 1) {
                    indWeight[ind] += itemWeight[item];
                    indValue[ind] += itemValue[item];
                }
            }
            if (indWeight[ind] <= KNAP_MAX) {
                indFitness[ind] = indValue[ind];
            } else {
                indFitness[ind] = 0;
            }
        }
    }

    // 개체의 정보 표시
    public void showIndividual() {
        int ind, item;

        System.out.printf("\n<%d세대>\n", indGeneration);

        System.out.printf("유전자\t\t\t 무게\t  가치\t적응도\n");
        for (ind = 0; ind < IND_NUM; ind++) {
            for (item = 0; item < ITEM_NUM; item++) {
                System.out.printf("[%d]", indGene[ind][item]);
            }
            System.out.printf("\t%2dkg\t%4d원\t%4d\n", indWeight[ind], indValue[ind], indFitness[ind]);
        }
        System.out.println();
    }

    // 적응도 순으로 개체정렬, 삽입정렬 사용
    public void sortIndividual() {
        // 요소, 위치, 아이템, 임시
        int pos, ins, item, tmp;
        for (pos = 1; pos < IND_NUM; pos++) {
            ins = pos;
            while (ins >= 1 && indFitness[ins - 1] < indFitness[ins]) {
                for (item = 0; item < ITEM_NUM; item++) {
                    tmp = indGene[ins - 1][item];
                    indGene[ins - 1][item] = indGene[ins][item];
                    indGene[ins][item] = tmp;
                }
                tmp = indWeight[ins - 1];
                indWeight[ins - 1] = indWeight[ins];
                indWeight[ins] = tmp;

                tmp = indValue[ins - 1];
                indValue[ins - 1] = indValue[ins];
                indValue[ins] = tmp;

                tmp = indFitness[ins - 1];
                indFitness[ins - 1] = indFitness[ins];
                indFitness[ins] = tmp;

                ins--;
            }
        }
    }

    // 도태 수행
    public void selectIndividual() {
        int ind, item;

        for (ind = 0; ind < IND_NUM / 2; ind++) {
            for (item = 0; item < ITEM_NUM; item++) {
                indGene[ind + IND_NUM / 2][item] = indGene[ind][item];
            }
        }
        System.out.println("하위 50% 도태시킴");
    }

    // 교차 수행
    public void crossoverIdividual() {
        int ind, item, crossoverPoint, tmp;

        // 하위 50%에서만 교차
        for (ind = IND_NUM / 2; ind < IND_NUM - 1; ind += 2) {
            crossoverPoint = (int) (Math.random() * 10000) % (ITEM_NUM);
            for (item = crossoverPoint; item < ITEM_NUM; item++) {
                tmp = indGene[ind][item];
                indGene[ind][item] = indGene[ind + 1][item];
                indGene[ind + 1][item] = indGene[ind][item];
            }
            System.out.printf("%d개체와 %d개체를 %d위치에서부터 교차.\n", ind, ind + 1, crossoverPoint);
        }
    }

    // 돌연변이 생성
    public void mutateIndividual() {
        int ind, item;

        // 하위 50%에서만 생성
        for (ind = IND_NUM / 2; ind < IND_NUM; ind++) {
            for (item = 0; item < ITEM_NUM; item++) {
                if (Math.random() <= MUTATE_RATE) {
                    indGene[ind][item] ^= 1;
                    System.out.printf("%d개체의 %d에서 돌연변이 발생.\n", ind, item);
                }
            }
        }
    }

    public void run(int gm) {
        int genMax = gm;
        int item;

        indGeneration = 1;
        createIndividual();
        calcIndividual();
        sortIndividual();
        showIndividual();

        indGeneration++;
        while (indGeneration <= genMax) {
            sortIndividual();
            selectIndividual();
            crossoverIdividual();
            mutateIndividual();
            calcIndividual();
            sortIndividual();
            showIndividual();
            indGeneration++;
        }

        System.out.println("------------------");
        String names = new String();
        for (item = 0; item < ITEM_NUM; item++) {
            if (indGene[0][item] == 1) {
                names += String.valueOf(itemName[item]);
            }
        }
        System.out.printf("결과는 %S로 %dkg %d원\n", names, indWeight[0], indValue[0]);
    }
}
