package CollectionExample;

public class CollectionExample {
    public static void main(String[] args) {
        Shavondi shavondi = new Shavondi();
        ShavondiMember newMember = new ShavondiMember("경준");

        shavondi.memberSet.add(newMember);
        for (ShavondiMember member : shavondi.memberSet) {
            System.out.println(member.city + "에 사는 " + member.age + "살 " + member.name);
        }
    }
}
