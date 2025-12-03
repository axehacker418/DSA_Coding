// 1436
/*
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct path going from cityAi to cityBi. Return the destination
 * city, that is, the city without any path outgoing to another city.
 * 
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will be exactly one destination city.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourteenThirtySix {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();

        for (List<String> p : paths) {
            map.put(p.get(0), p.get(1));
        }

        for (List<String> p : paths) {
            String dest = p.get(1);
            if (!map.containsKey(dest)) {
                return dest;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        List<List<String>> paths = Arrays.asList(
                Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo")); // paths = [["London","New York"],["New York","Lima"],["Lima","Sao
                                                     // Paulo"]]

        String city = new FourteenThirtySix().destCity(paths);
        System.out.println(city);
    }
}