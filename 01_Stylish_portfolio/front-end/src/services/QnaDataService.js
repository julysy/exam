// QnaDataService.js
// 목적 : Qna 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class QnaDataService {
    // 모든 고객정보 조회 요청 함수
    // question : 고객명
    // page : 현재 페이지 번호
    // size : 페이지당 화면에 보여질 개수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/qna")
        // 1) 전체 조회 +
        // 2) 고객명 조회 같이하는 함수
        return http.get(`/qna?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 고객번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/qna/{qno}"), @PathVariable
    get(qno) {
        return http.get(`/qna/${qno}`)
    }

    // 고객정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/qna"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/qna", data);
    }

    // 고객정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/qna/{qno}"), @RequestBody
    update(qno, data) {
        return http.put(`/qna/${qno}`, data);
    }

    // 고객정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/qna/deletion/{qno}")
    //                        , @PathVariable  
    delete(qno) {
        return http.delete(`/qna/deletion/${qno}`);
    }

    // 고객정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/qna/all")
    // deleteAll() {
    //     return http.delete("/qna/all")
    // }

    // 고객명 검색 요청 함수
    // 쿼리스트링 방식 url : ?변수명=값&변수명2=값2....
    // get 방식 통신 요청 -> @GetMapping("/api/qna") , @RequestParam
    // findByDname(question) {
    //     return http.get(`/qna?question=${question}`);
    // }

}

export default new QnaDataService();