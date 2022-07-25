package algorithm.array;

import java.util.Arrays;

public class l00034FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {

        int idx = searchIndex(nums, 0, nums.length-1, target);
        if (idx == -1) return new int[]{-1, -1};

        int l = 0;
        int r = nums.length-1;

        while(l > 0 && nums[l-1] == nums[idx]) --l;
        while(r < nums.length - 1 && nums[r+1] == nums[idx]) ++r;

        return new int[]{l,r};
    }

    public static int searchIndex(int[] nums, int l, int r, int target){

        if(l > r) return -1;

        int mid = l + ( (r-l)/2 );
        if(nums[mid] == target) return mid;

        if(nums[mid] > target){
            return searchIndex(nums, l, mid-1, target);
        }else{
            return searchIndex(nums, mid+1, r, target);
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{5,7,7,8,8,10};

        System.out.println(Arrays.toString(searchRange(nums, 8)));

    }
}
