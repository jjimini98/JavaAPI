import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.util.Iterator;

public class Project03_C {
    public static void main(String[] args) {
        String filename = "cellDataType.xls";
        try(FileInputStream fis = new FileInputStream(filename)) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis); // 파일을 읽어서 워크북으로 만들기
            HSSFSheet sheet =workbook.getSheetAt(0);
            Iterator<Row> rows =sheet.rowIterator(); //row 한 줄씩 읽어서 가지고오기
            while(rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cells=row.cellIterator(); //행 하나에 칼럼 개수가 몇개인지?
                while (cells.hasNext()){ //row가 있으면
                    HSSFCell cell =(HSSFCell) cells.next();
                    //셀 데이터의 타입을 알아보기
                    CellType type =cell.getCellType();
                    if (type==CellType.STRING){
                        System.out.println("["+cell.getRowIndex()+','+cell.getColumnIndex()+"]=String; Value="+cell.getRichStringCellValue().toString());
                    }
                    else if (type ==CellType.NUMERIC){System.out.println("["+cell.getRowIndex()+','+cell.getColumnIndex()+"]=NUMBERIC; Value="+cell.getNumericCellValue());}
                    else if (type == CellType.BOOLEAN) {System.out.println("["+cell.getRowIndex()+','+cell.getColumnIndex()+"]=BOOLEAN; Value="+cell.getBooleanCellValue());}
                    else if (type == CellType.BLANK) {System.out.println("["+cell.getRowIndex()+','+cell.getColumnIndex()+"]=BLANK CELL");}
                }
            }

        }catch (Exception e) {e.printStackTrace();}


    }
}
