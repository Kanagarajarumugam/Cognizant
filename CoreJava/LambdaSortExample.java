import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("David");

        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        for (String name : names) {
            System.out.println(name);
        }
    }
}
