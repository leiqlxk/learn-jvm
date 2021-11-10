package org.lql.t2;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Demo2_2 <br>
 * ProjectName: learn-jvm <br>
 * description: 演示软引用 <br>
 *
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 21:56 <br>
 */
public class Demo2_2 {

    public static final int _4MB = 4 * 1024 * 1024;

    // 软引用，只有软引用时如果gc后内存还是不够则会回收软引用对象
    public static void main(String[] args) {
        // list --> SoftReference --> byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();

        // 使用引用队列来清理无用的软引用
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5; i++) {
            // 关联引用队列，当软引用所关联的byte[]被回收时，软引用自己就会加入到queue中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

        System.out.println("循环结束：" + list.size());

        Reference<? extends byte[]> poll = queue.poll();

        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("删除无用软引用后：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }

    // 强引用
    public static void test(String[] args) throws IOException {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 如果字节数组为图片时，其不是核心的系统资源，如果使用强引用的话会一直占据内存，超出后会报OutOfMemory
            list.add(new byte[_4MB]);
        }

        System.in.read();
    }
}
