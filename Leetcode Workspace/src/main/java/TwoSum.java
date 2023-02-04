import java.lang.reflect.Array;
import java.util.ArrayList;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] correctSet = new int[2];
        int endpoint = nums.length-1;
        int startpoint = 0;


        while(true){
            if (startpoint == endpoint){
                startpoint ++;
                endpoint = nums.length-1;
            }
            else if (nums[startpoint] + nums[endpoint] == target) {
                correctSet[0] = startpoint;
                correctSet[1] = endpoint;
                return correctSet;
            } else if (nums[startpoint] + nums[endpoint] != target){
                endpoint--;
            }
        }

    }
}

