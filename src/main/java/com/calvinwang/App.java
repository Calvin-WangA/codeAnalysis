package com.calvinwang;

/**
 * Hello world!
 *
 */
public class App 
{
    /***
     * boot入口
     * @param args
     */
    public static void main( String[] args )
    {
        String str = new String("hello");

        String str2 = new String("world");

        String str3 = "hello";
        String str4 = "hello";
        System.out.println(str3 == str4);

        System.out.println("---------------------------------------------");

        System.out.println(str == str3);
        str4 += str2;
        str3 += str2;
        System.out.println("----------------------------------------------");
        System.out.println(str4 == str3);

        StringBuffer strBuffer = new StringBuffer("world");

        StringBuilder strBuilder = new StringBuilder("hi");

        for (int i = 0; i < 20; i++) {
            str += i;
        }

        str += strBuffer;

    }
}
