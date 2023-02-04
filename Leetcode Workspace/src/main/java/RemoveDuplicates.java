import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 3, 4, 5};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {
        int totalUniqueNums = 0;

        int[] intStream = Arrays.stream(nums).distinct().toArray();
        totalUniqueNums = intStream.length;

        for(int i = 0; i <= totalUniqueNums; i++){
            nums[i] = intStream[i];
        }


        return totalUniqueNums;
    }
}
