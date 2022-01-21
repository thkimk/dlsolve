package org.thkim.dlproj.studys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.net.SocketOption;

@Data
@AllArgsConstructor
@Builder
public class LombokStudy {
    String key;
    String value;

    public LombokStudy() {
        System.out.println("===============================================================");

    }


    @Test
    void test1() {
        LombokStudy lombokStudy = LombokStudy.builder()
                                    .key("key1")
                                    .value("value1").build();
        System.out.println("## "+ lombokStudy.toString());
    }
}




