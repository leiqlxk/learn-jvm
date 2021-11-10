package org.lql.t1;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * Title: Demo1_8 <br>
 * ProjectName: learn-jvm <br>
 * description: 元空间内存溢出 <br>
 * -XX:MaxMetaspaceSize=8m
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/3 23:30 <br>
 */
public class Demo1_8 extends ClassLoader {// 可以用来加载类的二进制字节码

    public static void main(String[] args) {
        int i = 0;
        try {
            Demo1_8 test = new Demo1_8();

            for (int j = 0; j < 10000; j++,i++) {
                // ClassWriter 作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                // 版本号， 修饰符，  类名， 包名， 类的父类， 接口名
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + j, null, "java/lang/Object", null);
                // 生成类并返回类的二进制字节码的字节数组
                byte[] code = cw.toByteArray();
                // 执行类的加载，生成Class 对象
                test.defineClass("Class" + j, code, 0, code.length);
            }
        }finally {
            System.out.println(i);
        }
    }
}
