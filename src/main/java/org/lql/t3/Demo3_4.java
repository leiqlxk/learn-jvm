package org.lql.t3;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Title: Demo3_4 <br>
 * ProjectName: learn-jvm <br>
 * description: 自定义类加载器 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/10 22:30 <br>
 */
public class Demo3_4 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> test = classLoader.loadClass("Test");

        System.out.println(test.newInstance());
    }
}

class MyClassLoader extends ClassLoader {

    // name为类的名称
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "D:\\org\\lql\\t3\\" + name + ".class";


        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            Files.copy(Paths.get(path), os);

            // 得到字节数组
            byte[] bytes = os.toByteArray();

            // byte[] -> *.class
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();

            throw new ClassNotFoundException("未找到此类", e);
        }
    }
}
