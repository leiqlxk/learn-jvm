package org.lql.t3;

/**
 * Title: Demo3_1 <br>
 * ProjectName: learn-jvm <br>
 * description: 演示 字节码指令 和 操作数栈、常量池的关系 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/8 22:27 <br>
 */
public class Demo3_1 {

    public static void main(String[] args) {
        int a = 10;
        int b = Short.MAX_VALUE + 1;
        int c = a + b;

        System.out.println(c);
    }
}
