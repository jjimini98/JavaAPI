import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Project04_B {
    public static void main(String[] args) {
        //pdf를 만드려면 document를 먼저 만들어야한다.

        Document doc = new Document();
        try{
            FileOutputStream fos = new FileOutputStream("paragraphDemo.pdf");
            // 도큐먼트와 아웃풋 스트림을 연결해주는 pdfwriter
            PdfWriter.getInstance(doc,fos);
            doc.open();

            String content= "Your word is a lamp to my feet and a light for my path";
            Paragraph par1 = new Paragraph(32); //문장 사이 간격을 32
            par1.setSpacingBefore(50);
            par1.setSpacingAfter(50); // 앞뒤 공백???

            for(int i =0; i<20;i++){
                Chunk chunk = new Chunk(content); //청크 객체 만들기
                par1.add(chunk); //par1에 chunk 추가

            }
            doc.add(par1);

            Paragraph par2 = new Paragraph();
            for(int i =0; i<10; i++){
                par2.add(new Chunk(content)); //청크 객체를 chunk 변수를 따로 만들어서 넣지 않고 바로 add해버림
            }
            doc.add(par2);

            doc.close(); //열고 난 다음 반드시 닫으십셔
            System.out.println("PDF 생성 완료 !");
        }catch (Exception e) {e.printStackTrace();}
    }
}
