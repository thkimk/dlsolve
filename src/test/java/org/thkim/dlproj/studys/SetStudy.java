package org.thkim.dlproj.studys;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SetStudy {

    public SetStudy() {
        System.out.println("===============================================================");

    }

    @Test
    void test1() {
        Random ran = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();

        // List로 중복 없애려면..
        for (int i = 0; i < 6; i++) {
            int num = ran.nextInt(45) + 1; //1부터 45까지 랜덤숫자 반환...
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (num == list.get(j)) { //이전까지 나왔던 숫자들과 비교해서 중복숫자 나오면 빼줘야했음 (Set에서는 불필요)
                    flag = true;
                }
            }
            if (flag) i--;
            else list.add(num);
        }
        System.out.println(list.toString()); // ex) [26, 9, 43, 17, 38, 30]

        // Set은 중복없는 List가 필요할 때 사용..
        Set<Integer> set2 = new HashSet<Integer>();
        while (set2.size() < 6) {
            int num2 = ran.nextInt(45) + 1;
            set2.add(num2);
        }
        System.out.println(set2); // ex) [33, 36, 21, 5, 38, 31]
    }


    class Person1 {
        protected String name;
        protected int age;

        public Person1(String name, int age) {
            this.name=name;
            this.age=age;
        }

        @Override
        public String toString() {
            return String.format("%s(%s)",this.name,this.age);

        }

    }

    class Person2 extends Person1 {
        public Person2(String name, int age) {
            super(name, age);
        }

        @Override
        public int hashCode() {
            return (this.name+this.age).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            //p1.equals(p2)
            if(obj instanceof Person1) {
                Person1 p = (Person1)obj;
                return this.hashCode()==p.hashCode();

            }
            return false;
        }
    }

    @Test
    void test2() {
        Set<Person1> set1 = new HashSet<Person1>();
        set1.add(new Person1("홍길동",20));
        set1.add(new Person1("홍길동",20));

        Set<Person2> set2 = new HashSet<Person2>();
        set2.add(new Person2("홍길동",20));
        set2.add(new Person2("홍길동",20));

        System.out.println(set1.toString());
        System.out.println(set2.toString());
    }


    @Test
    void test3() {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(20);
        set.add(50);
        set.add(30);
        set.add(10);
        set.add(40);

        System.out.println(set);
    }

    @Data
    class User1 {
        private String name;
        private int point;

        public User1(String name, int point) {
            this.name = name;
            this.point = point;
        }
    }

    @Test
    void test4() {
        TreeSet<User1> set = new TreeSet<User1>(new Comparator<User1>() {
            @Override
            public int compare(User1 a, User1 b) {
                //포인트 순으로 정렬할 경우
                return a.getPoint()-b.getPoint();

                // 이름순으로 정렬할 경우
                //return a.getName().compareTo(b.getName());
            }
        });
        set.add(new User1("홍길동", 100));
        set.add(new User1("아무개", 10));
        set.add(new User1("하하하", 55));
        set.add(new User1("호호호", 90));
        set.add(new User1("테스트", 42));

        System.out.println(set);
    }

    @Data
    @AllArgsConstructor
    class User2 implements Comparable<User2> {
        private String name;
        private int point;

        @Override
        public int compareTo(User2 o) {
            return this.point - o.point;
        }
    }

    @Test
    void test5() {
        TreeSet<User2> set = new TreeSet<User2>();
        set.add(new User2("홍길동", 100));
        set.add(new User2("아무개", 10));
        set.add(new User2("하하하", 55));
        set.add(new User2("호호호", 90));
        set.add(new User2("테스트", 42));

        System.out.println(set);
    }
}
