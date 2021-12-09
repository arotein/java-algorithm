package CollectionExample;

import java.util.HashSet;
import java.util.Set;

public class Shavondi {
    ShavondiMember member1 = new ShavondiMember("차누", "부산", 27);
    ShavondiMember member2 = new ShavondiMember("통현", "후쿠오카");
    ShavondiMember member3 = new ShavondiMember("통길", 27);
    Set<ShavondiMember> memberSet = new HashSet<>();

    Shavondi() {
        memberSet.add(member1);
        memberSet.add(member2);
        memberSet.add(member3);
    }


}
