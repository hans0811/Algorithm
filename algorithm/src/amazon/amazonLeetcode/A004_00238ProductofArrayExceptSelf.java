package amazonLeetcode;

public class A004_00238ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];

        prefix[0] = 1;
        for(int i=1 ; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }


        int right = 1;
        for(int j = nums.length-1; j >= 0; j--){
            if( j < nums.length - 1){
                right = right * nums[j+1];
            }
            prefix[j] *= right;
        }

        return prefix;
    }

    public static void main(String[] args) {
        int[] a = {-1,1,0,-3,3};

        System.out.println(productExceptSelf(a));
    }

    // Number
}
