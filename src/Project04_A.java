import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.jsoup.Connection;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Phaser;

public class Project04_A {
    public static void main(String[] args) {
        String [] title = new String[] {"제목","저자","출판사","이미지URL"};
        String [][] rows = new String[][]{
                {"물리법칙의 이해","리처드 파인먼","해나무","http://naver.com"},
                {"Java의 정석","남궁성","도우출판","http://naver.com"},
                {"리눅스 프로그래밍","창병모","생능출판","http://naver.com"}
        };
        Document doc = new Document(PageSize.A4);
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(new File("Book.pdf")));
            doc.open();
            //한글 폰트가 필요
            BaseFont bf = BaseFont.createFont("malgun.ttf",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
            Font fontTitle = new Font(bf,12);
            Font fontRows = new Font(bf,10);

            PdfPTable table = new PdfPTable(title.length);
            table.setWidthPercentage(100);

            float [] colwidth = new float[]{20f, 15f, 15f, 30f};
            table.setWidths(colwidth);

            for (String header : title){
                PdfPCell cell = new PdfPCell();
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(10);
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(header, fontTitle));
                table.addCell(cell);


            }
            table.completeRow();

            for (String [] row : rows) { //행 한 줄 꺼내오기
                for(String data :row) { //행 한 줄 안에 데이터 가져오기
                    Phrase phrase = new Phrase(data, fontRows);
                    PdfPCell cell = new PdfPCell(phrase);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setPaddingTop(20);
                    cell.setPaddingRight(30);
                    cell.setPaddingBottom(20);
                    cell.setPaddingLeft(30);

                    table.addCell(cell); // 반복문으로 만들어진 cell을 table에 저장
                }
                table.completeRow();
            }

            PdfPCell cell4 = new PdfPCell(new Phrase("Cell 5"));
            //셀 합치기
            cell4.setColspan(2);

            PdfPCell cell5 = new PdfPCell(new Phrase("Cell 6"));
            cell5.setColspan(2);

            table.addCell(cell4);
            table.addCell(cell5);


            doc.addTitle("PDF Table demo");
            doc.add(table);
            System.out.println("Table 생성 완료");


        }catch (Exception e) {e.printStackTrace();}
    }
}
