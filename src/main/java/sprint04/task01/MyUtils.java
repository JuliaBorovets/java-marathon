package sprint04.task01;

//Create a createNotebook() method of the MyUtils class to create a new map with name as key and phone list as value.
// The method receives a map  with phone as key and name as value.
//For example, for a given map {0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}
//you should get
//{Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}.

import java.util.*;

public class MyUtils {
    public static void main(String[] args) {
        Map<String, String> phones = new HashMap<String, String>() {{
            put("0967654321", "Petro");
            put("0677654321", "Petro");
            put("0501234567", "Ivan");
            put("0970011223", "Stepan");
            put("0631234567", "Ivan");
        }};
        System.out.println(new MyUtils().createNotebook(phones));
    }

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> result = new HashMap<>();

        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (result.containsKey(entry.getValue())) {
                result.get(entry.getValue()).add(entry.getKey());
            } else {
                result.put(entry.getValue(), new ArrayList<>(Collections.singleton(entry.getKey())));
            }
        }

        return result;
    }
}
