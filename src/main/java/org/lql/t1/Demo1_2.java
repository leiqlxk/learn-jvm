package org.lql.t1;

/**
 * Title: Demo1_2 <br>
 * ProjectName: learn-jvm <br>
 * description: 局部变量的线材安全问题 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 21:36 <br>
 */
public class Demo1_2 {

    public static void main(String[] args) {

    }

    // 对象在方法内创建，不存在逃逸，是线程安全的
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1)
                .append(2)
                .append(3);
        System.out.println(sb.toString());
    }

    // sb对象是方法外传入进来的，那么其逃离了该方法的作用范围，则其不是方法私有，有线程安全问题
    public static void m2(StringBuilder sb) {
        sb.append(1)
                .append(2)
                .append(3);
        System.out.println(sb.toString());
    }

    // sb会当初返回结果返回，也逃离除了该方法作用范围，也会有线程安全的问题
    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1)
                .append(2)
                .append(3);
        return sb;
    }
}
