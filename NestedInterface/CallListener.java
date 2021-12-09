package NestedInterface;

public class CallListener implements Button.OnClickListener {
    @Override
    public void onClick() {
        System.out.printf("전화를 겁니다.\n");
    }
}
