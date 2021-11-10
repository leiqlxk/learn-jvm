package org.lql.t2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Demo2_1 <br>
 * ProjectName: learn-jvm <br>
 * description: 演示GC Roots <br>
 *
 * jmap
 * 生成dump文件
 * -dump:format=b(二进制格式),live(只关心存活对象，并且抓取快照时会触发一次垃圾回收),file=1.bin 进程id
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 21:06 <br>
 */
public class Demo2_1 {

    public static void main(String[] args) throws IOException {
        List<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(1);
        System.in.read();

        list = null;
        System.out.println(2);
        System.in.read();
        System.out.println("end...");
    }
}
