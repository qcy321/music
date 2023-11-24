import com.mu.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {

    @Test
    public void test1() {
        System.out.println("你好");

    }

    public static void main(String[] args) {
        String str = "     ";
        System.out.println(str.trim().equals(""));
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(2);
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.addAll(objects);
        System.out.println(hashSet);
    }
}