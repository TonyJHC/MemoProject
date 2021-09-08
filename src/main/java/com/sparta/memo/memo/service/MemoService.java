package com.sparta.memo.memo.service;

import com.sparta.memo.memo.domain.Memo;
import com.sparta.memo.memo.domain.MemoRepository;
import com.sparta.memo.memo.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // 2. final 선언시 꼭 필요
@Service
public class MemoService {

    // final로 선언되면 값 수정 x, 값을 넣는 방법은 1) 생성자로 2) 선언과 동시에
    private final MemoRepository memoRepository; // 1. Spring에게 꼭 받아야 되는거라고 말해줌

    @Transactional // 3. 해당 메소드가 호출될 때 바뀐 내용을 DB에 반영을 해줘야되 !
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow( // 예외처리 : 만약에 없다면 ?
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.") // 파라미터가 잘 못 들어왔을 때
        );
        memo.update(requestDto);
        return memo.getId();
    }
}
