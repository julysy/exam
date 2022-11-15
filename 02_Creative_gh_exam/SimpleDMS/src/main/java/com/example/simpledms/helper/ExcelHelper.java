package com.example.simpledms.helper;

import com.example.simpledms.model.Tutorial;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
//  엑셀 타입 : .xls(과거), .xlsx(최신)
//  아래 엑셀타입 : .xlsx 타입
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//  엑셀 문서의 제목부분
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
  static String SHEET = "Tutorials";

//  엑셀인지아닌지 체크하는 함수
  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

//  Tutorial 테이블 데이터 -> 엑셀로 변환하는 함수
  public static ByteArrayInputStream tutorialsToExcel(List<Tutorial> tutorials) {
//    변형 try(파일입출력){} - catch{} : 파일입출력 마지막 .close() 자동
    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
//      엑셀 워크북 ( 시트들 )
      Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

//      제목 4개 반복문 이용해서 엑셀에 출력
      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      int rowIdx = 1;
//      엑셀에 데이터를 출력하는 부분
      for (Tutorial tutorial : tutorials) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(tutorial.getId());
        row.createCell(1).setCellValue(tutorial.getTitle());
        row.createCell(2).setCellValue(tutorial.getDescription());
        row.createCell(3).setCellValue(tutorial.isPublished());
      }

      workbook.write(out); // 엑셀에 반영
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }

//  엑셀 -> Tutorial 테이블에 데이터 생성
  public static List<Tutorial> excelToTutorials(InputStream is) {
    
    try {
//      엑셀 워크북 생성
      Workbook workbook = new XSSFWorkbook(is);

//      엑셀 시트 호출
      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<Tutorial> tutorials = new ArrayList<Tutorial>();

      int rowNumber = 0;
//      여러 엑셀의 행을 -> 테이블의 행으로 생성하는 부분
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

//        여러열을 선택
//        Iterator 객체 : for/while 반복문을 편하게 실행하기 위해 사용.
//        .hasNext() : 배열안에 0~n번 데이터가 있으면 배열의 끝에 도달했는지 여부를 알기위해 호출
//         return 값 : 다음 데이터가 있으면 true, 없으면 false
//        .next() : 다음 데이터를 가져오기 함수
        Iterator<Cell> cellsInRow = currentRow.iterator();

//        Tutorial 객체 생성
        Tutorial tutorial = new Tutorial();

        int cellIdx = 0;
//        엑셀 셀 데이터를 Tutorial 테이블에 데이터 한 행을 생성하는 부분
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) { // 엑셀의 인덱스 번호(0 -> A, 1-> B)

          case 0:
            tutorial.setTitle(currentCell.getStringCellValue());
            break;

          case 1:
            tutorial.setDescription(currentCell.getStringCellValue());
            break;

          case 2:
            tutorial.setPublished(currentCell.getBooleanCellValue());
            break;

          default:
            break;
          }

          cellIdx++;
        }

        tutorials.add(tutorial);
      }

      workbook.close();

      return tutorials;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
