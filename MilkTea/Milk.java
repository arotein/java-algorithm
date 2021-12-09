package MilkTea;

public class Milk extends Thread {
    private String OriginalName = "유우";
    public String changedName = "유우";
    public boolean status = false;

    public String changeName(String name) {
        switch (name) {
            case "유우":
                return "우유";
            case "우유":
                return "Milk";
            default:
                return "유우";
        }
    }

    @Override
    public void run() {
        status = true;
        try {
            changedName = changeName(OriginalName);
            while (true) {
                System.out.println(changedName);
                changedName = changeName(changedName);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println(changedName);
        }
        System.out.println("Milk스레드를 종료합니다.");
        status = false;
    }
}
