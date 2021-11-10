package org.lql.t1;

/**
 * Title: Demo1_3 <br>
 * ProjectName: learn-jvm <br>
 * description: 栈内存溢出 StackFlowError <br>
 * -Xss256k
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 21:48 <br>
 */
public class Demo1_3 {
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        }catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
