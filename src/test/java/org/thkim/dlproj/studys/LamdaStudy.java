package org.thkim.dlsolve.studys;

import org.junit.jupiter.api.Test;

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

    }
}
