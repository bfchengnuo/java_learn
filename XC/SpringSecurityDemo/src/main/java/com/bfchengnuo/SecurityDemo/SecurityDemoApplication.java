package com.bfchengnuo.SecurityDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "hello world!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "这里是 Hello";
    }

    // 注意要加前缀
    @PreAuthorize("hasRole('ROLE_admin')")
    @RequestMapping("/roleAuth")
    public String role() {
        return "有 admin 角色才能进入的页面";
    }

    // 权限之前之后的判断
    @PreAuthorize("#a < 10 or principal.username.equals(#username)")
    @PostAuthorize("hasRole('ROLE_admin') or hasPermission()")
    // 对集合类型的参数、返回值过滤，过滤！
    @PreFilter("")
    @PostFilter("filterObject % 2 == 0")
    public List<Integer> test(int a, String username, List<Integer> list) {
        // 注解说明
        return null;
    }
}
