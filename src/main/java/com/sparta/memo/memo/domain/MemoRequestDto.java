package com.sparta.memo.memo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor // final선언한 멤버변수에대한 생성자를 만들어줌
public class MemoRequestDto {
    private final String username;
    private final String contents;

}
