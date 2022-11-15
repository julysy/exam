package com.example.simpledms.controller;


import com.example.simpledms.model.Customer;
import com.example.simpledms.service.CustomerService;
import com.example.simpledms.service.CustomerService;
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
 * fileName       : Customer07Controller
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
public class CustomerController {

    @Autowired
    CustomerService customerService; // @Autowired : 스프링부트가 가동될 때 생성된 객체를 하나 받아오기

//    frontend url ( 쿼리 스트링 방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url (파라메터 방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
//    @RequestParam(required = false) : false 매개변수에 값이 없어도 에러가 발생하지 않음
//                                      기본값은 required = true
//    @RequestParam(defaultValue = "값") : 매개변수의 값이 없을떄 기본값을 설정함
    @GetMapping("/customer")
    public ResponseEntity<Object> getCustomerAll(@RequestParam(required = false) String email,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size
                                             ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//            Page 객체 정의
            Page<Customer> customerPage;

//            findAll() 생략해도 전체검색해야 됨:
//            why? like 검색시 고객명 매개변수가 ==이더라도 전채 검색 됨.
                customerPage = customerService.findAllByEmailContaining(email, pageable);



//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("customer", customerPage.getContent());
            response.put("currentPage", customerPage.getNumber());
            response.put("totalItems", customerPage.getTotalElements());
            response.put("totalPages", customerPage.getTotalPages());

            if (customerPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {

        try {
            Customer customer2 = customerService.save(customer);

            return new ResponseEntity<>(customer2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Optional 객체 : null 방지 객체
//    주요함수 : get() 안에 있는 객체 꺼내기 함수
//             .isPresent() 안에 있으면 true , 없으면 false
    @GetMapping("/customer/{cid}")
    public ResponseEntity<Object> getCustomerId(@PathVariable int cid) {

        try {
            Optional<Customer> optionalCustomer = customerService.findById(cid);

            if (optionalCustomer.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
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

    @PutMapping("/customer/{cid}")
    public ResponseEntity<Object> updateCustomer(@PathVariable int cid,
                                             @RequestBody Customer customer) {

        try {
            Customer customer2 = customerService.save(customer);

            return new ResponseEntity<>(customer2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/customer/deletion/{cid}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int cid) {

        try {
            boolean bSuccess = customerService.removeById(cid);

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
