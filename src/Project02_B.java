import kr.inflearn.DownloadBroker;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

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
        //리소스 다운로드 (mp3)
//            Element tag = doc.select("source").first();
//            String dpath = tag.attr("src").trim(); // mp3 다운로드 링크 : https://meditation.su.or.kr/meditation_mp3/2019/20191010.mp3
//            String filename = dpath.substring(dpath.lastIndexOf("/")+1) ;

        // 리소스 다운로드 (img)
            Element tag = doc.select(".img > img").first();
            String dpath = "https://sum.su.or.kr:8888"+tag.attr("src").trim();
            String filename = dpath.substring(dpath.lastIndexOf("/")+1) ;

            Runnable r = new DownloadBroker(dpath,filename);
            Thread dLoad = new Thread(r);
            dLoad.start();
            for(int i = 0; i<10;i++){ //thread가 실행이 될때 main 함수에서는 for문이 진행된다 .
                try {
                    Thread.sleep(10000);
                }catch (Exception e ){
                        e.printStackTrace();
                }
                System.out.print(""+(i+1));
            }
            System.out.println("Download Complete ! ");
            System.out.println("==============================================");
        } catch (Exception e ){
            e.printStackTrace();
        }

    }
}
