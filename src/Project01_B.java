import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {
    public static void main(String[] args) {
        // JSON - org.json 사용
        JSONArray students = new JSONArray();

        JSONObject student = new JSONObject(); //클래스로 객체를 만들지 않아도 json 만들기 가능!
        student.put("name", "홍길동" );
        student.put("phone", "010-1111-1111" );
        student.put("address", "서울" );
        students.put(student);

        student  = new JSONObject();
        student.put("name", "나길동" );
        student.put("phone", "010-2222-2222" );
        student.put("address", "광주" );
        students.put(student);


        JSONObject object = new JSONObject();
        object.put("students" , students);

        System.out.println(object.toString(2));
    }
}
