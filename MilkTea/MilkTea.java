package MilkTea;

public class MilkTea {
    public static void main(String[] args) {
        Milk milk = new Milk();
        Tea tea = new Tea();

        String milkResult = new String();
        String teaResult = new String();

        System.out.println("원래 이름 : " + milk.changedName + tea.changedName);
        System.out.println("이름 변경을 멀티스레드로 진행합니다.");
        System.out.println(milk.changedName + " " + tea.changedName);
        milk.start();
        tea.start();
        boolean stop = false;
        while (!stop) {
            if ("MilkTea".equals(milk.changedName + tea.changedName)) {
                milkResult = milk.changedName;
                teaResult = tea.changedName;
                stop = true;
                milk.interrupt();
                tea.interrupt();
            }
        }
//        멀티스레드 종료 후 메인스레드 종료를 위한 while
        while (true) {
            if (!milk.status || tea.status) {
                break;
            }
        }
        System.out.println("최종 변경된 이름 : " + milkResult + teaResult);
        System.out.println("메인 스레드를 종료합니다.");

    }
}
