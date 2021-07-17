import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Project01_D {
    public static void main(String[] args) {

        String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
        String client_id = "x7ojf3outz";
        String client_secret = "zGudX2r4sXik1Ng1a1X6AGF3ouIkTgXfaZTn4AAu";

        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("주소를 입력하세요");
            String address = io.readLine();
            String addr = URLEncoder.encode(address,"UTF-8");
            String reqURL = apiURL + addr;

            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID",client_id);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY",client_secret);

            int responsecode = conn.getResponseCode();
            if (responsecode == 200) {}



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
