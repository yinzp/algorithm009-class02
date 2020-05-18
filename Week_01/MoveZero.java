package geek;

public class MoveZero {

    private static final int[] test = {5, 0,1,0,3,12};

    public static void main(String[] args) {
        moveZeroes1(test);
    }

    public static void moveZeroes1(int[] nums){
       int[] temp = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp[j] = nums[i];
                j++;
            }

        }

        for (int i = j; i < temp.length; i++) {
            temp[i] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }

    }

}
