package com.example.simpledms.dto;

import lombok.*;

/**
 * packageName    : com.example.simpledms.dto.fileDb
 * fileName       : ResponseMessageDto
 * author         : ds
 * date           : 2022-11-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-10        ds       최초 생성
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessageDto {
//    클라이언트(Vue) 쪽으로 전닿할 메세지
    private String message;
}
