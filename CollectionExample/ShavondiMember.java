package CollectionExample;

public class ShavondiMember {
    String name;
    String city;
    int age;

    ShavondiMember(String name) {
        this(name, "한국이나 일본 어딘가", 30);
    }

    ShavondiMember(String name, String city) {
        this(name, city, 30);
    }

    ShavondiMember(String name, int age) {
        this(name, "한국이나 일본 어딘가", age);
    }

    ShavondiMember(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ShavondiMember) {
            ShavondiMember member = (ShavondiMember) obj;
            if (this.name.equals(member.name) && this.age == member.age) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
