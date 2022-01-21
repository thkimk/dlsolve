package org.thkim.dlsolve.studys;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *  기존 방식
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello world lambda");
        }
    }).start();

    람다 방식
    new Thread(()->{
        System.out.println("Hello world lambda"); 
    }).start();
 */
public class LamdaStudy {
    public LamdaStudy() {
        System.out.println("===============================================================");

    }

    interface MyFunction {
    }

    @Test
    void test1() {
        System.out.println(new MyFunction() {
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        }.max(3, 5));

    }

    // 함수형 인터페이스의 등장으로 우리는 함수를 변수처럼 선언할 수 있게 되었고, 코드 역시 간결하게 작성할 수 있게 되었다..
    @FunctionalInterface
    interface MyLambdaFunction {
        int max(int a, int b);
    }

    @Test
    void test1Lamda1() {
        MyLambdaFunction lambdaFunction = (int a, int b) -> a > b ? a : b;
        System.out.println(lambdaFunction.max(3, 5));

        lambdaFunction = (a, b) -> a < b ? a : b;
        System.out.println(lambdaFunction.max(3, 5));
    }

    @Test
    void test2() {
        // List의 람다식
        List<String> stringList = new ArrayList<String>();
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("strawberry");

        for (String string : stringList) {
            System.out.println(string);
        }

        stringList.forEach(string -> System.out.println(string));

        // Map의 람다식
        System.out.println("===============================================================");
        Map<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("apple", "red");
        stringMap.put("orange", "orange");
        stringMap.put("strawberry", "red");

        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        stringMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        // 배열의 람다식
        System.out.println("===============================================================");
        String[] stringArray = { "apple", "orange", "strawberry" };
        Arrays.asList(stringArray).forEach(string -> System.out.println(string));

    }
}
