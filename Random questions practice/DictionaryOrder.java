
import java.util.*;

public class DictionaryOrder {
    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        al.add("ab");
        al.add("bc");
        al.add("ac");
        al.add("cd");
        Collections.sort(al);
        String res = "";

        for (int i = 0; i < al.size(); i++) {
            res += al.get(i);

        }
        System.out.println(res);
    }
}
