package com.sparta.memo.memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 스프링아 우리 Jpa 쓸건데 data 변동이 있으면 꼭 jpa가 자동으로 반영하도록 해줘 ~ -> 이거 없으면 수정/변경 될 때 데이터 반영 안됨
public class MemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemoApplication.class, args);
    }

}
