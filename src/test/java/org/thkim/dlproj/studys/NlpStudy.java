package org.thkim.dlproj.studys;

import org.junit.jupiter.api.Test;

// 자연어 처리
public class NlpStudy {
    public NlpStudy() {
        System.out.println("===============================================================");

    }

    public final static String[] CHO = {"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ", "ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
    public final static String[] JOONG = {"ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ", "ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ","ㅟ","ㅠ","ㅡ","ㅢ","ㅣ"};
    public final static String[] JONG = {"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ","ㄻ","ㄼ", "ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};

    @Test
    void test1() {
//      char a = (초성 * 21 + 중성) * 28 + 종성 + 0xAC00
        char a = (11 * 21 + 0) * 28 + 4 + 0xAC00;
        System.out.println(a);

        // 초성 추출 : 초성 = ((문자유니코드 - 0xAC00)/28)/21
        char uniVal = "안".charAt(0);
        char cho = (char)((uniVal-0xAC00)/28/21);
        System.out.println(uniVal + "[" + (int)cho + "]");

        // 중성 추출 : 중성 = (문자유니코드 - 0xAC00) / 28 % 21
        char joong = (char)((uniVal-0xAC00)/28%21);
        System.out.println(uniVal + "[" + (int)joong + "]");

        // 종성 추출 : 종성 = (문자유니코드 - 0xAC00) % 28
        char jong = (char)((uniVal-0xAC00)%28);
        System.out.println(uniVal + "[" + (int)jong + "]");

    }

    @Test
    void test2() {
        String text = "안녕하세요. 닭가슴살은 퍽퍽하고, 스타벅스 자바칩프라푸치노 맛나요ㅋㅋ";

        for (int i = 0; i < text.length(); i++) {
            char uniVal = text.charAt(i);

            // 한글일 경우만 시작해야 하기 때문에 0xAC00부터 아래의 로직을 실행한다
            if(uniVal >= 0xAC00) {
                System.out.print(uniVal + "=>");
                uniVal = (char)(uniVal - 0xAC00);
                char cho = (char)(uniVal/28/21);
                char joong = (char) ((uniVal)/28%21);
                char jong = (char) (uniVal % 28); // 종성의 첫번째는 채움이기 때문에

                System.out.println(CHO[cho] + JOONG[joong] + JONG[jong]);
            } else {
                System.out.println(uniVal + "=>" + uniVal);
            }
        }
    }

}

