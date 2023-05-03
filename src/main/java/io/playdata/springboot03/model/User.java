package io.playdata.springboot03.model;

import lombok.*;

import javax.persistence.*;

@Entity // jpa 객채 등록 어노테이션
@Table(name = "account") // sql 테이블 지정
@Getter @Setter // 멤버변수 불러오기, 설정하기
@NoArgsConstructor @AllArgsConstructor @ToString // 인자 없는 초기 생성자, 모든 멤버변수가 인자로 있는 생성자, ?
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;
}
