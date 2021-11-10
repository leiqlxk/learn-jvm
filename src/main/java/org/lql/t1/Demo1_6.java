package org.lql.t1;

import java.util.concurrent.TimeUnit;

/**
 * Title: Demo1_6 <br>
 * ProjectName: learn-jvm <br>
 * description: 演示堆内存 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 22:57 <br>
 */
public class Demo1_6 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1....");
        TimeUnit.MILLISECONDS.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10];
        System.out.println("2....");
        TimeUnit.MILLISECONDS.sleep(30000);
        array = null;
        System.gc();
        System.out.println("3...");
        TimeUnit.MILLISECONDS.sleep(1000000);
    }
}
