package org.lql.t1;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Title: Demo1_11 <br>
 * ProjectName: learn-jvm <br>
 * description: 直接内存溢出 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 18:10 <br>
 */
public class Demo1_11 {

    private static final int _100M = 1024 * 1024 * 100;

    public static void main(String[] args) {
        int i = 0;
        ArrayList<ByteBuffer> list = new ArrayList<>();

        try {
            for (int j = 0; j < 100; j++) {
                ByteBuffer allocate = ByteBuffer.allocate(_100M);
                list.add(allocate);
                i++;
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
