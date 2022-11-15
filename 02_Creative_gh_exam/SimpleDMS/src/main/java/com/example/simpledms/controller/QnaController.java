package com.example.simpledms.controller;


import com.example.simpledms.model.Qna;
import com.example.simpledms.service.QnaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName    : com.example.jpaexam.controller.exam07
 * fileName       : Qna07Controller
 * author         : ds
 * date           : 2022-10-21
 * description    : 고객 컨트롤러 쿼리 메소드
 * 요약 :
 * 쿼리 메소드 : 자동으로 사용자 정의 sql 문을 생성해주는 함수
 * 목적 : 기본 함수보다 다양한 sql 문 작성하기 위해 사용
 * 사용법 : 함수이름으로 sql 문장을 작성함 ( Repository 안에 함수명만 작성 )
 * ex) JPA 클래스 == 대상 테이블
 * find == select
 * all == *
 * by == from
 * 속성 == where 컬럼
 * orderBy == order by
 * 속성 desc == 컬럼 desc
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-21        ds       최초 생성
 */
@Slf4j
// CORS 보안 : 한사이트레서 포트를 달리 사용 못함
// @CrossOrigin(허용할 사이트주소(Vue 사이트주소:포트) : CORS 보안을 허용해주는 어노테이션
//@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api")
public class QnaController {

    @Autowired
    QnaService qnaService; // @Autowired : 스프링부트가 가동될 때 생성된 객체를 하나 받아오기

//    frontend url ( 쿼리 스트링 방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url (파라메터 방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
//    @RequestParam(required = false) : false 매개변수에 값이 없어도 에러가 발생하지 않음
//                                      기본값은 required = true
//    @RequestParam(defaultValue = "값") : 매개변수의 값이 없을떄 기본값을 설정함
    @GetMapping("/qna")
    public ResponseEntity<Object> getQnaAll(@RequestParam String searchSelect,
                                             @RequestParam(required = false) String searchKeyword,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size
                                             ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Qna> qnaPage;

//            findAll() 생략해도 전체검색해야 됨:
//            why? like 검색시 고객명 매개변수가 ==이더라도 전채 검색 됨.
            if(searchSelect.equals("question")) {
                qnaPage = qnaService.findAllByQuestionContaining(searchKeyword, pageable);
            } else {
                qnaPage = qnaService.findAllByQuestionerContaining(searchKeyword, pageable);
            }


//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("qna", qnaPage.getContent());
            response.put("currentPage", qnaPage.getNumber());
            response.put("totalItems", qnaPage.getTotalElements());
            response.put("totalPages", qnaPage.getTotalPages());

            if (qnaPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PostMapping("/qna")
    public ResponseEntity<Object> createQna(@RequestBody Qna qna) {

        try {
            Qna qna2 = qnaService.save(qna);

            return new ResponseEntity<>(qna2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Optional 객체 : null 방지 객체
//    주요함수 : get() 안에 있는 객체 꺼내기 함수
//             .isPresent() 안에 있으면 true , 없으면 false
    @GetMapping("/qna/{qno}")
    public ResponseEntity<Object> getQnaId(@PathVariable int qno) {

        try {
            Optional<Qna> optionalQna = qnaService.findById(qno);

            if (optionalQna.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalQna.get(), HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트에)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
//           서버 에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/qna/{qno}")
    public ResponseEntity<Object> updateQna(@PathVariable int qno,
                                             @RequestBody Qna qna) {

        try {
            Qna qna2 = qnaService.save(qna);

            return new ResponseEntity<>(qna2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/qna/deletion/{qno}")
    public ResponseEntity<Object> deleteQna(@PathVariable int qno) {

        try {
            boolean bSuccess = qnaService.removeById(qno);

            if (bSuccess == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트에)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
//           서버 에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
