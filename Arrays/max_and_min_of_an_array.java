import java.util.ArrayList;

class max_and_min_of_an_array {
    public static ArrayList<Integer> findMinMax(int[] arr) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        
        // Find minimum and maximum
        for (int num : arr) {
            if (num < mini) mini = num;
            if (num > maxi) maxi = num;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(mini);
        result.add(maxi);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};
        ArrayList<Integer> result = findMinMax(arr);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}