package org.lql.t1;

import java.util.concurrent.TimeUnit;

/**
 * Title: Demo1_4 <br>
 * ProjectName: learn-jvm <br>
 * description: CPU占用过多演示 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 22:26 <br>
 */
public class Demo1_4 {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("1.....");
            while (true) {

            }
        }, "thread1").start();

        new Thread(() -> {
            System.out.println("2....");
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2").start();

        new Thread(() -> {
            System.out.println("3....");
            try {
                TimeUnit.SECONDS.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread3").start();
    }
}
