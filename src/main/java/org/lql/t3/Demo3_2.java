package org.lql.t3;

import java.io.IOException;

/**
 * Title: Demo3_2 <br>
 * ProjectName: learn-jvm <br>
 * description: 多态原理 <br>
 *
 * 禁用指针压缩
 * -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/9 21:24 <br>
 */
public class Demo3_2 {

    public static void test(Animal animal) {
        animal.eat();
        System.out.println(animal.toString());
    }

    public static void main(String[] args) throws IOException {
        test(new Cat());
        test(new Dog());
        System.in.read();
    }
}

abstract class Animal {
    public abstract void eat();

    @Override
    public String toString() {
        return "我是" + this.getClass().getSimpleName();
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
