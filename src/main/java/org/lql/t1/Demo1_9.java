package org.lql.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: Demo1_9 <br>
 * ProjectName: learn-jvm <br>
 * description: 串池位置分析 <br>
 *
 * jdk 8下设置 -Xmx10m -XX:-UseGCOverheadLimit
 * jdk 6下设置 -XX:MaxPermSize=10m
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/11/6 17:02 <br>
 */
public class Demo1_9 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;

        try {
            for (int j = 0; j < 260000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }

}
