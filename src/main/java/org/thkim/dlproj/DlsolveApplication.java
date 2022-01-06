package org.thkim.dlsolve;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DlsolveApplication {
    public static void main(String[] args) {
        log.info("## main(): application starts..");
        SpringApplication.run(DlsolveApplication.class, args);
    }

}
