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
@Table(name = "TB_GALLERY")
@SequenceGenerator(
        name = "SQ_GALLERY_GENERATOR"
        , sequenceName = "SQ_GALLERY"
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
@SQLDelete(sql = "UPDATE TB_GALLERY SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE GID = ?")
public class GalleryDb extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_GALLERY_GENERATOR")
    private Integer gid;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String galleryTitle;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String galleryFileName;

    @Column(columnDefinition = "VARCHAR2(1000)")
    private String galleryType;

    //    @Lob : DB 테이블의 Blob/Clob 자료형에 해당하는 컬럼일 경우 @ 사용함
//           자료형은 byte[] 사용.
    @Lob
    @Column
    private byte[] galleryData; // 이미지


    public GalleryDb(String galleryTitle, String galleryFileName, String galleryType, byte[] galleryData) {
        this.galleryTitle = galleryTitle;
        this.galleryFileName = galleryFileName;
        this.galleryType = galleryType;
        this.galleryData = galleryData;
    }
}
