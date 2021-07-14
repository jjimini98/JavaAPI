import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class Project01_C {
    public static void main(String[] args) {
        String src = "info.json";

        // IO -> Stream(스트림)
        InputStream is = Project01_C.class.getResourceAsStream(src); // 다시

        if (is==null) {
            throw new NullPointerException("Cannnot find resource file") ;
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);

        JSONArray students = object.getJSONArray("students");

        for ( int i = 0; i<students.length();i++) {
            JSONObject student = (JSONObject) students.get(i);
            System.out.print(student.get("name") + "\t" + student.get("address")+"\t");
            System.out.println(student.get("phone"));
        }


    }
}
