package org.thkim.dlproj.studys;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassStudy {
    @Test
    // 정규 표현식에 입력 문자열을 검증
    void classPattern() {
        String regex = "[0-9]*$"; //숫자만

        String input1 = "0123456789"; //입력 문자열
        System.out.println(Pattern.matches(regex, input1));

        String input2 = "abcde56789"; //입력 문자열
        System.out.println(Pattern.matches(regex, input2));

        String input3 = "abcdefghij"; //입력 문자열
        System.out.println(Pattern.matches(regex, input3));
    }

    @Test
    // 입력 문자열의 패턴을 해석하고 주어진 패턴과 일치하는지 판별할 때 주로 사용
    void classMatcher() {
        // 소문자로 이루어진 단어만 받아와 표시하는 로직이다. 예를 들어 I, it.와 같이 대문자와 특수문자가 포함된 경우는 제외하고 표시
        String regEx = "[a-z]*[a-z]";
        String text = "I never dreamed about success, I worked for it.";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    void classRandom() {
        Random r1 = new Random();
        Random r2 = new Random(10);

        for (int i = 0; i < 10; i++) {
            System.out.println("r1: " + r1.nextInt() + ", r2: " + r2.nextInt());
            System.out.println(r1.nextInt(100));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(r1.nextGaussian());
        }
    }
}
