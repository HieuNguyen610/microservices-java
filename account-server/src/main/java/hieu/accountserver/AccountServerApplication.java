package hieu.accountserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServerApplication.class, args);
    }

}
