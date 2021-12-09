package MilkTea;

public class Tea extends Thread {
    private String OriginalName = "카";
    public String changedName = "카";
    public boolean status = false;

    public String changeName(String name) {
        switch (name) {
            case "카":
                return "Car";
            case "Car":
                return "차";
            case "차":
                return "Tea";
            default:
                return "카";
        }
    }

    @Override
    public void run() {
        status = true;
        try {
            changedName = changeName(OriginalName);
            while (true) {
                System.out.println("\t" + changedName);
                changedName = changeName(changedName);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("\t" + changedName);
        }
        System.out.println("Tea스레드를 종료합니다.");
        status = false;
    }
}
