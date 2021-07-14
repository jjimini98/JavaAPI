import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.inflearn.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;


public class Project01_A {
    public static void main(String[] args) {
        // Object (BookDTO) 를 JSON(문자열) 로 변환
        BookDTO dto = new BookDTO("Java",17000,"지민",670);
        Gson g = new Gson(); //Gson을 쓸때는 반드시 객체를 만들고 시작해야한다!

        String json = g.toJson(dto);
        System.out.println(json); //출력값으로 나온게 바로 json 형태임.

        //json을 다시 객체로 변경하고싶을때
        BookDTO dto1 = g.fromJson(json, BookDTO.class);
        System.out.println(dto1);


        //object (List<BookDTO>) -->json(string)
        List<BookDTO> lst = new ArrayList<BookDTO>();
        lst.add(new BookDTO("Java1",17000,"지민",670));
        lst.add(new BookDTO("Java2",18000,"지민",800));
        lst.add(new BookDTO("Java3",19000,"지민",569));
        lst.add(new BookDTO("Java4",20000,"지민",772));
        lst.add(new BookDTO("Java5",22000,"지민",980));

        String lstJson = g.toJson(lst);
        System.out.println(lstJson); //배열 형태의 json 생성

        // Json(String)  --> Object(List<BookDTO>) //자바의 reflection 기법 -> 고급기법
        List<BookDTO> lst1 = g.fromJson(lstJson, new TypeToken<List<BookDTO>>(){}.getType());
        for (BookDTO vo : lst1) {
            System.out.println(vo);
        }

    }
}
