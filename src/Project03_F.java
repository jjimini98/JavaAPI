import kr.inflearn.ExcelDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Project03_F {
    public static void main(String[] args) {
        //입력받는 메뉴를 만드는 곳
        ExcelDAO dao = new ExcelDAO();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("입력(I)/종료(E)");
            String sw = br.readLine();
            switch (sw) {
                case "I":
                    dao.excel_input();
                    break;
                case "E" :
                    System.out.println("프로그램 종료");
                    System.exit(0);
                    break;
                default:
                    System.out.println("I or E input");

            }
        }catch (Exception e) {e.printStackTrace();}
    }
}
