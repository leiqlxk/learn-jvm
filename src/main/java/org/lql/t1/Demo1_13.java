package org.lql.t1;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Title: Demo1_13 <br>
 * ProjectName: learn-jvm <br>
 * description: 禁用显示垃圾回收 <br>
 *
 * 禁用显示垃圾回收
 * -XX:+DisableExplicitGC
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 20:53 <br>
 */
public class Demo1_13 {
    private static final int _1GB = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(_1GB);
        System.out.println("分配完毕....");
        System.in.read();
        System.out.println("开始释放...");
        buffer = null;
        // 显示的垃圾回收，Full GC
        // 直接内存时通过垃圾回收清理检测到buffer回收时，通过Cleaner虚引用来主动调用unsafe.freeMemory()释放直接内存
        // 关闭显示垃圾回收后就只用等到真正有触发垃圾回收时才会释放直接内存
        System.gc();
        System.in.read();
    }
}
