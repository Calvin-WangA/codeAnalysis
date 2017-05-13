package com.calvinwang.map;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created Date 2017/4/29
 *
 * @copyright SL131
 */
public class ListAnalysis {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("test");
        list.add("hello");

        List<String> llist = new LinkedList<String>();
        list.add("world");
        list.add("test2");

        GenericTest<Date> test = new GenericTest<Date>();
        test.setObj(new Date());

        System.out.println(test.getObj());

        System.out.println("-------------------------位操作测试----------------------------");

        System.out.println(1 >> 2);

        System.out.println("-----------------------------------------------------");
        System.out.println(1 << 2);

        System.out.println("-------------------------Integer最大值最小值--------------------------");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


    }
}
