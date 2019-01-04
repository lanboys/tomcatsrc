package org.apache.catalina.mbeans;

/**
 * Created by 蓝兵 on 2018/7/27.
 */

public class Bing {

    public static void main(String[] args) throws InterruptedException {
        new Thread("bing-thread") { // 断点0
            @Override
            public void run() {
                System.out.println("1"); // 断点1
                try {
                    for (int i = 0; i < 120; i++) {
                        Thread.sleep(100);
                        System.out.print(i+"-"); // 断点1
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"); // 断点2
            }
        }.start();
        // 外线程
        System.out.println("3"); // 断点3
        Thread.sleep(12000);
        System.out.println("4"); // 断点4
    }
}
