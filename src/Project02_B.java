import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Project02_B {
    public static void main(String[] args) {
        String url = "https://sum.su.or.kr:8888/bible/today/Ajax/Bible/BosyMatter?qt_ty=QT1";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("[입력 -> 년(yyyy)-월(mm)-일(dd)]: ");
            String bible = br.readLine();
            url = url+"&Base_de="+bible+"&bibleType=1";
            System.out.println("==============================================");
            Document doc = Jsoup.connect(url).post();
            Element bible_Text = doc.select(".bible_text").first();
            System.out.println(bible_Text.text());

            Element bibleinfo_box = doc.select(".bibleinfo_box").first();
            System.out.println(bibleinfo_box.text());

            Elements lilist = doc.select(".body_list > li");
            for (Element li:lilist) {
                System.out.print(li.select(".num").first().text()+" ");
                System.out.println(li.select(".info").first().text());
            }
            System.out.println(bibleinfo_box.text());


        } catch (Exception e ){
            e.printStackTrace();
        }

    }
}
