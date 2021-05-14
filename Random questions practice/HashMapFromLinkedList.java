//question asked in ajio.com hackerearth test

/*Sample Input                   Sample Output
                               
Abc 4                         Abc 4
fxh 5                         fxh 5
fxh 7                         iui 10
iui 10                        oop 9
oop 9*/
import java.util.*;

class MyHashMap {
    String k;
    int v;

    MyHashMap() {
    }

    MyHashMap(String k, int v) {
        this.k = k;
        this.v = v;

    }
}

public class HashMapFromLinkedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMapFromLinkedList hll = new HashMapFromLinkedList();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int num = sc.nextInt();
            hll.addKey(s, num);
        }

        hll.getPairs();
    }

    MyHashMap hm = new MyHashMap();

    private ArrayList<MyHashMap> pairList = new ArrayList<>();

    public void addKey(String s, int num) {
        MyHashMap temp = new MyHashMap(s, num);
        if (pairList.size() == 0)
            pairList.add(temp);
        int flag = 0;
        for (int i = 0; i < pairList.size(); i++) {
            // System.out.println(pairList.get(i).k.toString());
            if (pairList.get(i).k.toString().equals(s)) {
                flag = 1;
                break;
            }

        }
        if (flag == 0) {
            pairList.add(temp);
        }
    }

    public void getPairs() {
        for (int i = 0; i < pairList.size(); i++) {
            System.out.println(pairList.get(i).k.toString() + " " + pairList.get(i).v);
        }
    }

}
