package org.lql.t1;

/**
 * Title: Demo1_10 <br>
 * ProjectName: learn-jvm <br>
 * description: StringTable 垃圾回收 <br>
 *-Xmx10m
 *
 * StringTable统计信息
 * -XX:+PrintStringTableStatistics
 *
 * 打印垃圾回收详细信息
 * -XX:+PrintGCDetails -verbose:gc
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 17:23 <br>
 */
public class Demo1_10 {

    public static void main(String[] args) {
        int i = 0;

        try {
            for (int j = 0; j < 10000; j++) {
                String.valueOf(i).intern();
                i++;
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
