import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Project04_C {
    public static void main(String[] args) {
        //https://cdn.inflearn.com/public/main_sliders/7177f62c-7a6c-4d4b-91bb-1e6c16a8d904/%5B%E1%84%86%E1%85%A6%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%92%E1%85%B5%E1%84%8B%E1%85%A5%E1%84%85%E1%85%A9%5D%E1%84%82%E1%85%A1%E1%84%8B%E1%85%A6%E1%84%80%E1%85%A6%E1%84%86%E1%85%A1%E1%86%BD%E1%84%82%E1%85%B3%E1%86%AB%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4_main_521.png
        Document doc = new Document();
        try{
            PdfWriter.getInstance(doc, new FileOutputStream("ImageDemo.pdf"));
            doc.open();

            String filename = "pic.jpg";
            Image img = Image.getInstance(filename);
            doc.add(img);

            String url ="https://item.kakaocdn.net/do/c5c470298d527ef65eb52883f0f186c49f17e489affba0627eb1eb39695f93dd";
            Image imgurl = Image.getInstance(url);
            doc.add(imgurl);

        }catch (Exception e){e.printStackTrace();}finally {
            doc.close();
            System.out.println("ImageDemo pdf 생성 완료");
        }

    }
}
