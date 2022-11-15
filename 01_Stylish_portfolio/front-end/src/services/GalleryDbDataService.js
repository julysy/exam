// GalleryDbDataService.js
import http from "../http-common";

class GalleryDbDataService {
    // 함수명   : upload() 함수 ( DB 저장 함수 )
    // 매개변수 title : 제목
    //          content : 내용
    //          galleryDb : 업로드 대상 이미지
    upload(title, galleryDb) {
        // json 객체 사용하지 않음 (x)
        // form 태그로 전송하는 방식을 이용함
        // html <form></form> == js FormData 객체로 사용가능
        //                       .append("속성명", 값) 함수 : 데이터를 저장
        // axios 함수 : .post()
        // 헤더 : "Content-Type" : "multipart/form-data" 
        let formData = new FormData(); // 폼(form) 객체 생성

        formData.append("galleryTitle", title);
        formData.append("galleryDb", galleryDb);

        return http.post("/galleryDb/upload", formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        })
    }

    // 이미지 제목 검색 요청 함수
    getFiles(galleryTitle, page, size) {
        console.log(galleryTitle);
        console.log(page);
        console.log(size);
        return http.get(`/galleryDb?galleryTitle=${galleryTitle}&page=${page}&size=${size}`)
    }

    // 이미지 삭제 요청 함수
    delete(gid) {
        return http.delete(`/galleryDb/deletion/${gid}`);
    }

}

export default new GalleryDbDataService();