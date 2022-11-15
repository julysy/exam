package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName    : com.example.jpaexam.model
 * fileName       : Dept
 * author         : ds
 * date           : 2022-10-19
 * description    : 부서 모델(== JPA : 엔티티(Entity)) 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-19        ds       최초 생성
 */
@Entity
@Table(name = "TB_CUSTOMER")
@SequenceGenerator(
        name = "SQ_CUSTOMER_GENERATOR"
        , sequenceName = "SQ_CUSTOMER"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
// null 인 컬럼 데이터는 sql 문 자동 생성시 제외시킴
@DynamicInsert
@DynamicUpdate
// soft delete : 삭제하는 척만 하기 (화면에서는 안보이고, DB는 데이터를 삭제하지 않음)
// 법정 의무 보관 기간을 위해 실제 데이터를 삭제하지 않음.
// 사용법 1) @SQLDelete(sql="update문") : delete 문이 실행되지 않고, 매개변수의 update 문이 실행되게 함
//       2) @Where(clause = "강제조건") : 대상클래스에 붙이면 sql문 실행시 강제 조건이 붙어 실행됨
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_CUSTOMER SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE CID = ?")
public class Customer extends BaseTimeEntity{

//    CID          NUMBER NOT NULL PRIMARY KEY,
//    FIRST_NAME  VARCHAR2(255),
//    LAST_NAME   VARCHAR2(255),
//    EMAIL       VARCHAR2(255),
//    PHONE       VARCHAR2(255) ,

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    , generator = "SQ_CUSTOMER_GENERATOR")
    private Integer cid;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String firstName;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String lastName;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String email;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String phone;
}
