package org.lql.t3;

import java.io.IOException;

/**
 * Title: Demo3_3 <br>
 * ProjectName: learn-jvm <br>
 * description: 解析的含义 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/10 21:14 <br>
 */
public class Demo3_3 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ClassLoader classloader = Demo3_3.class.getClassLoader();
        // loadClass 方法不会导致类的解析和初始化
        Class<?> c = classloader.loadClass("org.lql.t3.C");

        // new 会触发类的解析和初始化
        // new C();
        System.in.read();
    }
}

class C {
    D d = new D();
}

class D {
}
