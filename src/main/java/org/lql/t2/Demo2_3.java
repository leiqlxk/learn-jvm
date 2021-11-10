package org.lql.t2;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Demo2_3 <br>
 * ProjectName: learn-jvm <br>
 * description: 演示弱引用 <br>
 *
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 22:37 <br>
 */
public class Demo2_3 {

    public static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        // list --> WeakReference --> byte[]
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.print(w.get() + "");
            }
            System.out.println();
        }

        System.out.println("循环结束后：" + list.size());
    }
}