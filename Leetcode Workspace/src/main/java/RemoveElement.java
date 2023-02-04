public class RemoveElement {

    public static void main(String[] args) {

        int[] intArr = new int[]{4, 5};

        System.out.println(removeElement(intArr, 5));
    }

    public static int removeElement(int[] nums, int val) {
        int lastSpacePointer = nums.length-1;

        try {
            for (int i = 0; i <= lastSpacePointer; i++) {
                int temp = nums[lastSpacePointer];
                if (nums[i] == val) {
                    nums[lastSpacePointer] = nums[i];
                    nums[i] = temp;
                    lastSpacePointer--;
                }

                temp = nums[lastSpacePointer];


                if (nums[i] == val) {
                    nums[lastSpacePointer] = nums[i];
                    nums[i] = temp;
                    lastSpacePointer--;
                }
            }
        }
        catch(Exception e){
            return lastSpacePointer + 1;
        }

        return lastSpacePointer+1;
    }
}
