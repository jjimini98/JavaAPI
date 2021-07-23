import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Project04_D {
    public static void main(String[] args) {
        Document doc = new Document();
        try{
            PdfWriter.getInstance(doc, new FileOutputStream("ImageScaling.pdf"));
            doc.open();

            String filename = "choon.png";
            Image img = Image.getInstance(filename);
            doc.add(img);

            String filename2 = "choon.png";
            Image img2 = Image.getInstance(filename2);
            img2.scaleAbsolute(100f,100f);
            doc.add(img2);

            String filename3 = "choon.png";
            Image img3 = Image.getInstance(filename3);
            img3.scalePercent(50f);
            doc.add(img3);

            String url = "https://item.kakaocdn.net/do/c5c470298d527ef65eb52883f0f186c49f17e489affba0627eb1eb39695f93dd";
            Image img4= Image.getInstance(url);
            img4.scaleToFit(200f,200f);
            doc.add(img4);

            System.out.println("크기 조절 성공 !");


        }catch (Exception e){e.printStackTrace();}finally {
            doc.close();
        }
    }
}
