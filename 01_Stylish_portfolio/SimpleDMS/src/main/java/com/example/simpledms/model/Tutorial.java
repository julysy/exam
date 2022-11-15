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
@Table(name = "TB_TUTORIAL")
@SequenceGenerator(
        name = "SQ_TUTORIAL_GENERATOR"
        , sequenceName = "SQ_TUTORIAL"
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
@SQLDelete(sql = "UPDATE TB_TUTORIAL SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE ID = ?")
public class Tutorial extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_TUTORIAL_GENERATOR")
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private boolean published;


}
