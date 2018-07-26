package com.bfchengnuo.SecurityDemo;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class SecurityDemoApplicationTests {

    @Test
    public void contextLoads() {
        PasswordEncoder encoder;
        for (int i = 5; i > 0; i--) {
            encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            System.out.println(encoder.encode("123"));
        }
    }

}
