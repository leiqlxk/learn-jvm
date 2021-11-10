package org.lql.t3;

/**
 * Title: Demo3_5 <br>
 * ProjectName: learn-jvm <br>
 * description: 分成编译 <br>
 *
 * 关闭逃逸分析
 * -XX:- DoEscapeAnalysis
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/10 22:55 <br>
 */
public class Demo3_5 {

    public static void main(String[] args) {

        for (int i = 0; i < 200; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                new Object();
            }
            long end = System.nanoTime();

            System.out.printf("%d\t%d\n",i,(end - start));
        }
    }
}
