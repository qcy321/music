import sun.java2d.cmm.CMSManager;

import java.util.*;
import java.util.concurrent.*;

public class MuTest {

    public static int size = 10000;

    public static String room = "1001";

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(25, 50, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(size));

    public static Map<String, Set> map = new ConcurrentHashMap<>();

    public static CyclicBarrier barrier = new CyclicBarrier(size);

    public static CountDownLatch downLatch = new CountDownLatch(size);

    public static void main(String[] args) throws InterruptedException {
        //Set<Integer> set = new ConcurrentSkipListSet<>();
        //map.put(room, set);
        long l = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            int finalI = i;
            /*executor.execute(new Thread(() -> {
                map.get(room).add(finalI);
                //System.out.println(Thread.currentThread().getName() + "执行完毕------");
                downLatch.countDown();
            }, "A" + i));*/
            executor.execute(new Thread(() -> {
                map.put(room + finalI, new HashSet());
                //System.out.println(Thread.currentThread().getName() + "执行完毕------");
                downLatch.countDown();
            }, "A" + i));
        }
        System.out.println("等待其他程序执行");
        downLatch.await();
        System.out.println("全部执行完毕");
        System.out.println("房间的个数" + map.size() + "  耗时为:" + (System.currentTimeMillis() - l));
        executor.shutdown();
        /*Iterator iterator = map.get(room).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
    }
}
