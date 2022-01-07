package org.thkim.dlsolve.studys;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Data
public class OptionalStudy {
    @Data
    @AllArgsConstructor
    class Person {
        private String name;

    }

    @Data
    @AllArgsConstructor
    public class House {
        private Person onwer;
        private String address;

    }

    public OptionalStudy() {
        System.out.println("===============================================================");

    }

    House getHouse() {
        Person lPerson = new Person("thkim");
        return new House(lPerson, null);
    }


    @Test
    void test1() {
        House house = this.getHouse();
        if (house.getOnwer() != null) {
            System.out.println("onwer: " + house.getOnwer().getName());
        }
        System.out.println("address: " + house.getAddress());
    }


    @Test
    void test1Opt1() {
        House house = this.getHouse();
        Optional.of(house)
                .map(House::getOnwer)
                .map(Person::getName)
                .ifPresent(name -> System.out.println("onwer:" + name));    // if only present (bad!!)

        Optional.of(house)
                .map(House::getAddress)
                .ifPresent(address -> System.out.println("address:" + address));
    }

    @Test
    void test1Opt2() {
        House house = this.getHouse();
        String onwerName = Optional.of(house).map(House::getOnwer).map(Person::getName).orElse("없음");
        String address = Optional.of(house).map(House::getAddress).orElse("발급 되지 않음");

        System.out.println("onwer:" + onwerName);
        System.out.println("address:" + address);
    }
}
