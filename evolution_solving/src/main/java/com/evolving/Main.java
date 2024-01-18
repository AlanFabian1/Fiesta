package evolution_solving.src.main.java.com.evolving;

import org.json.JSONObject;

// Aux file, to review functions.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        fileReader x = new fileReader();
        JSONObject Obj = new JSONObject();
        Obj = x.getJSON();
        System.out.println(Obj.getString("content"));
    }
}