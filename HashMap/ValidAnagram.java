/*
 * Problem:-  GIven two Strings s and t return true if t is an anagram of s 
 * and false otherwise .
 * An anagram is a word or pharse formed by rearranging the letters of a diffrent word or phrase
 * typically using all the original letters exactly ones exp race care true tulip lipid false 
 */

import java.util.HashMap;

public class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
            
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) != null) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }

            }
            else{
                return false;
            }
        }
        // return true;
        return map.isEmpty();

    }

    public static void main(String[] args) {
        String s = "aman";
        String t = "anam";

        System.out.println(isAnagram(s, t));
    }

}
