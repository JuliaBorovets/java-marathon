package sprint04.task03;

//Create a listMapCompare() method of the MyUtils class to compare the contents of a list of strings and the values of a map.
//For example, for a given list
//[aa, bb, aa, cc]
//and map
//{1=cc, 2=bb, 3=cc, 4=aa, 5=cc}
//you should get true.

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {
    // Code
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa", "bb", "aa", "cc");
        Map<String, String> map = new HashMap<>();
        map.put("1", "cc");
        map.put("2", "bb");
        map.put("3", "aa");
        map.put("4", "cc");
        System.out.println(new MyUtils().listMapCompare(list, map));


    }

    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        return list.containsAll(map.values());
    }
}
