// We have to find the number of subarrays whose sum is equal to k

package HashingAndHeaps;

import java.util.HashMap;

public class No_of_subarrays_sum_equal_to_K {
    public static void main(String[] args){
        
        // Input array
        int arr[] = {10, 2, -2, -20, 10};
        
        // Target sum
        int k = -10;

        // HashMap to store: (prefix sum → frequency)
        // It helps us track how many times a particular sum has occurred
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case:
        // If a subarray itself equals k from index 0,
        // then (sum - k = 0) should already exist in map
        map.put(0, 1);

        int ans = 0;   // stores total number of valid subarrays
        int sum = 0;   // prefix sum

        // Traverse the array
        for(int j = 0; j < arr.length; j++){
            
            // Update prefix sum
            sum += arr[j];

            // Check if there exists a previous prefix sum such that:
            // current_sum - previous_sum = k
            // => previous_sum = sum - k
            if(map.containsKey(sum - k)){
                
                // If found, add its frequency to answer
                // because that many subarrays end at index j with sum k
                ans += map.get(sum - k);
            }

            // Now update the map with current prefix sum

            // If this sum already exists, increase its count
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            } 
            else{
                // Otherwise, add it with frequency 1
                map.put(sum, 1);
            }
        }

        // Print the total number of subarrays with sum = k
        System.out.println(ans);
    }
}