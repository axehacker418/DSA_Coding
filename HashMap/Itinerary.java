// Find the itinerary from tickets like chennai-delhithen goa etc 

/*
Solution approach is 
from start- to end  and end to start to maps 
*/

import java.util.HashMap;

public class Itinerary {

    public static String getStart(HashMap<String,String> tickets){
        HashMap <String, String> revMap=new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }

        for(String key: tickets.keySet()){
            if (!revMap.containsKey(key)) {
                return key;
                
            }
        }
        return null;
    }

    public static void main(String[] args) {

        HashMap<String , String> tickets=new HashMap<>();
        tickets.put("chennai", "banglore");
        tickets.put("banglore", "delhi");
        tickets.put("delhi", "goa");
        tickets.put("goa", "mumbai");
        tickets.put("mumbai", "sudan");
        tickets.put("sudan", "kathmandu");

        String start=getStart(tickets);
        System.out.println("tickets are... ");
        System.out.println(start);

        for(String key: tickets.keySet()){
            System.out.println("->"+ tickets.get(start));
            start=tickets.get(start);
        }

        
    }
    
}
