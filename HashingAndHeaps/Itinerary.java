//we need to get the itinerary in the correct order. So we can use a hashmap to store the source and destination. Then we can start from the source and keep on getting the destination until we reach the end of the itinerary.

package Hashing;

import java.util.HashMap;

public class Itinerary {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> reverseMap = new HashMap<>();
        for(String key: tickets.keySet()) {
            reverseMap.put(tickets.get(key), key);
        }
        // Find the starting point
        String start = "";
        for(String key: tickets.keySet()) {
            if(!reverseMap.containsKey(key)) {
                start = key;
                break;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Banglore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        String start = getStart(map);
        System.out.print(start);
        while(map.containsKey(start)) {
            System.out.print(" -> " + map.get(start));
            start = map.get(start);
        }
    }
}
