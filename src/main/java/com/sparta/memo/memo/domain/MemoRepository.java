package com.sparta.memo.memo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository를 상속 받음으로써 save, findByAll등 이미 만들어진 메소드들을 사용할 수 있음
// 이미 만들어진 놈들을 어디다 쓸거냐
public interface MemoRepository extends JpaRepository<Memo, Long> { // 그 대상은 Memo라는 녀석이고 id값은 Long형인 녀석에게 가져다가 쓸거다
    List<Memo> findAllByOrderByModifiedAtDesc(); // 중요함 !! 해당 링크로 가서 꼭 확인해보기
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

    /*
    findAll : 다 찾아라
    By OrderBy : 찾아서 정렬을 해줘
    ModifiedAt : 이러한 기준으로 ( 수정된 날짜를 기준으로 ) : private LocalDateTime modifiedAt;
    --> 멤버변수와 같은 이름 ?

    Desc : 내림차순으로
    뜻 : 찾아라 전부 , 찾아서 정렬을 하는데 수정된 날짜를 기준으로 정렬을 해라. 정렬 순수는 내림차순으로 해라.

리    */
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

    // JPA가 규칙을 세웠을 때 해당 규칙대로 메소드 명만 잘 만들어주면 그 뒤에 메소드들은 다 만들어 준다.
    // ex)
    /*
     * keyword가 And : findByLastnameAndFirstname : 여기서 Lastname , Firstnmae 은 실제 멤버 변수와 일치해야됨.
     * 뜻 : Lastname 과 Firstname이라는 멤버변수를 둘다 찾고 싶다.
     *
     */
}