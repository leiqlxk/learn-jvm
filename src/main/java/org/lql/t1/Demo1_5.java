package org.lql.t1;

import java.util.ArrayList;

/**
 * Title: Demo1_5 <br>
 * ProjectName: learn-jvm <br>
 * description: 堆内存溢出 OutOfMemoryError: Java heap space <br>
 * -Xmx8m
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 22:49 <br>
 */
public class Demo1_5 {

    public static void main(String[] args) {
        int i = 0;

        try {
            ArrayList<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        }catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
