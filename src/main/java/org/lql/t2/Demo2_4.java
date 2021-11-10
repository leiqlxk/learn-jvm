package org.lql.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: Demo2_4 <br>
 * ProjectName: learn-jvm <br>
 * description: 分代回收演示 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 23:24 <br>
 */
public class Demo2_4 {

    public static final int _512KB = 512 * 1024;
    public static final int _1MB = 1024 * 1024;
    public static final int _6MB = 6 * 1024 * 1024;
    public static final int _7MB = 7 * 1024 * 1024;
    public static final int _8MB = 8 * 1024 * 1024;

    // -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        /*list.add(new byte[_7MB]);
        list.add(new byte[_512KB]);
        list.add(new byte[_512KB]);*/
        list.add(new byte[_8MB]);
    }
}
