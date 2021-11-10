package org.lql.t1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Title: Demo1_ <br>
 * ProjectName: learn-jvm <br>
 * description: 垃圾回收后，内存占用仍然很高 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 23:09 <br>
 */
public class Demo1_7 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }

        TimeUnit.SECONDS.sleep(10000);
    }
}

class Student {
    private byte[] big = new byte[1024 * 1024];
}
