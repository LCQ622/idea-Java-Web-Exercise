package cn.mcandroid.test;

import java.math.BigInteger;

public class Test02 {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        long c = (long) a + b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        BigInteger z;
    }


    public static void t1() {
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 6) {
                    break ok;
                }
                System.out.println("i:" + i + "\tj:" + j);
            }
        }
    }

    public static void t2() {
        boolean flag = false;
        for (int i = 0; i < 10 && !flag; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 7) {
                    flag = true;
                    break;
                }
                System.out.println("i:" + i + "\tj:" + j);
            }
        }
    }
}
