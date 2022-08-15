package amazonLeetcode;

public class A021_L00053MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int sum = Integer.MIN_VALUE;
        int cur = 0;

        for(int n : nums){
            cur = Math.max(cur + n, n);
            sum = Math.max(sum, cur);
        }

        return sum;
    }

    public static int maxSubArrayDivideAndConquer(int[] nums) {
        if(nums.length == 0) return 0;

        return divdeAndConquer(nums, 0, nums.length-1);
    }

    public static int divdeAndConquer(int[] nums, int l, int r){
        if(l >= r) return nums[l];

        int mid = l + ((r-l)/2);
        int lmax = divdeAndConquer(nums, l, mid-1);
        int rmax = divdeAndConquer(nums, mid+1, r);

        int mmax = nums[mid], t = mmax;

        for(int i=mid-1; i >= l; --i){
            t+= nums[i];
            mmax = Math.max(mmax, t);
        }

        t = mmax;

        for(int i=mid+1; i <=r; ++i){
            t+= nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }




    public static void main(String[] args) {

    }
}
