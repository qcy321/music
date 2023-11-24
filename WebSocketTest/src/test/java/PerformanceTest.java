import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PerformanceTest {

    public static List<User> vector = new Vector();

    public static List<User> sy = Collections.synchronizedList(new ArrayList<>());

    public static List<User> copy = new CopyOnWriteArrayList<>();

    public static List<User> stack = new Stack<>();

    public static Map<String, User> hashMap = new HashMap<>();
    public static Map<String, User> concurrent = new ConcurrentHashMap<>();
    public static Map<String, User> tree = new TreeMap<>();
    public static Map<String, User> skipMap = new ConcurrentSkipListMap<>();

    static {
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(String.valueOf(i), new User("张三", i));
            concurrent.put(String.valueOf(i), new User("张三", i));
            tree.put(String.valueOf(i), new User("张三", i));
            skipMap.put(String.valueOf(i), new User("张三", i));
            //vector.get(i);
        }
    }

    public static void hashMap() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            hashMap.put(String.valueOf(i), new User("张三", i));
            //vector.get(i);
        }
        System.out.println("hashMap:" + (System.currentTimeMillis() - l));
    }

    public static void concurrent() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            concurrent.put(String.valueOf(i), new User("张三", i));
            //vector.get(i);
        }
        System.out.println("concurrent:" + (System.currentTimeMillis() - l));
    }

    public static void tree() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            tree.put(String.valueOf(i), new User("张三", i));
            //vector.get(i);
        }
        System.out.println("tree:" + (System.currentTimeMillis() - l));
    }

    public static void skipMap() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            skipMap.put(String.valueOf(i), new User("张三", i));
            //vector.get(i);
        }
        System.out.println("skipMap:" + (System.currentTimeMillis() - l));
    }

    public static void getHashMap() {
        Random random = new Random();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            hashMap.get(String.valueOf(random.nextInt(1000000)));
            //vector.get(i);
        }
        System.out.println("hashMap:" + (System.currentTimeMillis() - l));
    }

    public static void getConcurrent() {
        Random random = new Random();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            concurrent.get(String.valueOf(random.nextInt(1000000)));
            //vector.get(i);
        }
        System.out.println("concurrent:" + (System.currentTimeMillis() - l));
    }

    public static void getTree() {
        Random random = new Random();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            tree.get(String.valueOf(random.nextInt(1000000)));
            //vector.get(i);
        }
        System.out.println("tree:" + (System.currentTimeMillis() - l));
    }

    public static void getSkipMap() {
        Random random = new Random();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            skipMap.get(String.valueOf(random.nextInt(1000000)));
            //vector.get(i);
        }
        System.out.println("skipMap:" + (System.currentTimeMillis() - l));
    }
    /*static {
        for (int i = 0; i < 100000; i++) {
            vector.add(i);
        }
        for (int i = 0; i < 100000; i++) {
            sy.add(i);
        }
        for (int i = 0; i < 100000; i++) {
            copy.add(i);
        }
    }*/

    public static void sy() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sy.add(new User("张三", i));
            //vector.get(i);
        }
        System.out.println("sy:" + (System.currentTimeMillis() - l));
    }

    public static void vector() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            vector.add(new User("张三", i));
            //vector.get(i);
        }
        System.out.println("vector:" + (System.currentTimeMillis() - l));
    }

    public static void stack() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            stack.add(new User("张三", i));
            //vector.get(i);
        }
        System.out.println("stack:" + (System.currentTimeMillis() - l));
    }

    public static void copy() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            copy.add(new User("张三", i));
            //vector.get(i);
        }
        System.out.println("copy:" + (System.currentTimeMillis() - l));
    }


    public static void main(String[] args) {

    }

}

class User {
    String name;
    int age;
    List<Integer> list;

    User(String name, int age) {
        this.name = name;
        this.age = age;
        this.list = new ArrayList<>();
    }
}
