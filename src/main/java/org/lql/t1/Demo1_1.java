package org.lql.t1;

/**
 * Title: Demo1_1 <br>
 * ProjectName: learn-jvm <br>
 * description: 演示栈帧 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 21:24 <br>
 */
public class Demo1_1 {

    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        method2(1, 2);
    }

    private static int method2(int a, int b) {
        int c = a + b;
        return c;
    }
}
