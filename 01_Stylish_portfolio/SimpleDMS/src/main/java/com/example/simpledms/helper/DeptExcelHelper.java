package com.example.simpledms.helper;

import com.example.simpledms.model.Dept;
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

public class DeptExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//  다운로드 엑셀 헤더(제목)
  static String[] HEADERs = { "Dno", "Dname", "Loc" };
  static String SHEET = "dept";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static ByteArrayInputStream deptToExcel(List<Dept> deptList) {

//    try with resource 구문 ( 파일입출력 정의하면 자동 .close() 가 끝에 실행됨 )
    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      int rowIdx = 1;
      for (Dept dept : deptList) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(dept.getDno());
        row.createCell(1).setCellValue(dept.getDname());
        row.createCell(2).setCellValue(dept.getLoc());
      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }

  public static List<Dept> excelToDept(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<Dept> deptList = new ArrayList<>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        Dept dept = new Dept();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
//          case 0:
//            dept.setDno((Integer) currentCell.getNumericCellValue());
//            break;

          case 0:
            dept.setDname(currentCell.getStringCellValue());
            break;

          case 1:
            dept.setLoc(currentCell.getStringCellValue());
            break;

          default:
            break;
          }

          cellIdx++;
        }

        deptList.add(dept);
      }

      workbook.close();

      return deptList;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
