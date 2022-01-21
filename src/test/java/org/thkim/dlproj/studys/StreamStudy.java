package org.thkim.dlsolve.studys;

import com.sun.prism.shader.Solid_ImagePattern_Loader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamStudy {
    public StreamStudy() {
        System.out.println("===============================================================");

    }

    @Test
    void test0() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        long lCount = myList  .stream() // 생성하기
                .filter(s -> s.startsWith("c")) // 가공하기
                .map(String::toUpperCase) // 가공하기
                .sorted() // 가공하기
                .count(); // 결과만들기

        System.out.println("## count : "+ lCount);
    }

    @Test
    void test1() {
        // Stream 사용 후
        String[] nameArr = {"IronMan", "Captain", "Hulk", "Thor"};
        List<String> nameList = Arrays.asList(nameArr);

        // 원본의 데이터가 아닌 별도의 Stream을 생성함
        Stream<String> arrayStream = Arrays.stream(nameArr);
        Stream<String> nameStream = nameList.stream();

        // 복사된 데이터를 정렬하여 출력함
        nameStream.sorted().forEach(System.out::println);
        arrayStream.sorted().forEach(System.out::println);

    }

    @Test
    void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer i : list) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        list.stream() // Stream 생성
                .filter(i -> i % 2 == 0) // 중간 연산
                .forEach(i -> System.out.println(i)); // 최종 연산
    }

    interface Animal {
        /**
         * 울음 소리를 반환한다.
         */
        String getCry();
    }

    @Test
    void test3() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream() // Stream 생성
                .map(i -> "요소는" + i + "입니다.") // 중간 연산
                .forEach(i -> System.out.println(i)); // 최종 연산

/*
        List<Animal> animalList = Arrays.asList("dog", "cat", "elephant");
        animalList.stream() // Stream 생성
                .map(animal -> animal.getCry()) // 중간 연산
                .forEach(cry -> System.out.println(cry)); // 최종 연산
*/
    }

    @Test
    void test4() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream() // Stream 생성
                .sorted((a, b) -> Integer.compare(a, b)) // 중간 연산
                .forEach(i -> System.out.println(i)); // 최종 연산

        integerList.stream() // Stream 생성
                .sorted(Comparator.reverseOrder()) // 중간 연산
                .forEach(i -> System.out.println(i)); // 최종 연산
    }

}
