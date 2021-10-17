package com.sparta.memo.memo.controller;

import com.sparta.memo.memo.domain.Entity.Memo;
import com.sparta.memo.memo.domain.Repo.MemoRepository;
import com.sparta.memo.memo.domain.Dto.MemoRequestDto;
import com.sparta.memo.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController // --> new MemoController 를 Spring이 자동으로 해줌
@RequiredArgsConstructor // 2. final 선언시 꼭 필요 --> new ~ 안해줘도됨. (생성자 자동으로 만들어 준다 )
public class MemoController {

    private final MemoRepository memoRepository; // 등록 ,조회 ,삭제 , 수정 할시 repository 필요함
    private final MemoService memoService;  // 업데이트가 필요하니까 service가 필요함
    private Memo save;


    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return save;
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
//        return memoRepository.findAllByOrderByModifiedAtDesc(); // 찾는데 순서대로 수정된 날짜를 기준으로 내림차순
        LocalDateTime end = LocalDateTime.now(); // 현재 시간
        LocalDateTime start = LocalDateTime.now().minusDays(1); // 하루전 시간
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @GetMapping("/api/memos/{id}")
    public Optional<Memo> readOneMemo(@PathVariable Long id) {
        Optional<Memo> memo = memoRepository.findById(id);
        return memo;
    }

    @PutMapping("/api/memos/{id}")
    public Long putMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) { // 경로에 있는 변수를 가져온다 이름 같은 놈
        memoRepository.deleteById(id);
        return id;
    }

}
