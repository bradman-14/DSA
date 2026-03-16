//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
public class container_with_most_water {
     public static int maxArea(int[] height) {

        // left pointer at start
        int left = 0;

        // right pointer at end
        int right = height.length - 1;

        // variable to store maximum area
        int maxArea = 0;

        while (left < right) {

            /*
            Area formula:
            height of water = min(height[left], height[right])
            width = distance between the two lines
            */
            int area = Math.min(height[left], height[right]) * (right - left);

            // update maximum area
            maxArea = Math.max(maxArea, area);

            /*
            Move the pointer with smaller height
            because it limits the container height.
            Moving the taller one will not increase area.
            */
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // return maximum water that can be stored
        return maxArea;
    }

    public static void main(String[] args) {

        // Test case 1
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum Water: " + maxArea(height1));

        // Test case 2
        int[] height2 = {1,1};
        System.out.println("Maximum Water: " + maxArea(height2));

        // Test case 3
        int[] height3 = {4,3,2,1,4};
        System.out.println("Maximum Water: " + maxArea(height3));
    }
}