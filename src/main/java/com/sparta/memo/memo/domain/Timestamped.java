package com.sparta.memo.memo.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // 꼭 달아줘야 GET 할 때 불러와줄 수 있음 .
@MappedSuperclass
// Entity가 자동으로 컬럼으로 인식합니다. --> 해당 class인 Timestamped를 상속한 class가 자동으로 LocalDataTime형인 createdAt, modifiedAt 변수를 column으로 인식
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
// EntityListeners : Timestamped를 상속한 녀석인 Memo의 소리를 항상 듣는다 (지켜본다)
// AuditingEntityListener : 변화가 있을때마다 자동으로 생성 해주겠다.
public abstract class Timestamped { // 추상 클래스란 ? 상속을 강제한다 : new Timestamped라고 할 수 없음. 상속만 가능 ! 빵틀 new로 못만든다.

    // ** 중요 !  Getter가 있어야 private으로 선언된 변수를 사용할 수 있기에 꼭 쓰기 !!

    @CreatedDate // 생성시간
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정 시간
    private LocalDateTime modifiedAt;

}
