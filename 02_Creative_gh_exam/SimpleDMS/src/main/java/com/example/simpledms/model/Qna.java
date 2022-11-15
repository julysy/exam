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
@Table(name = "TB_QNA")
@SequenceGenerator(
        name = "SQ_QNA_GENERATOR"
        , sequenceName = "SQ_QNA"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_QNA SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE QNO = ?")
public class Qna extends BaseTimeEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    , generator = "SQ_QNA_GENERATOR")
    private Integer qno;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String question;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String answer;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String questioner;

    @Column(columnDefinition = "VARCHAR2(255)")
    private String answerer;
}
