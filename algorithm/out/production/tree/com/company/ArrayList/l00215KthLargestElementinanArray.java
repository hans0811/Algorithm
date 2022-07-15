package algorithm.array;

import java.util.Arrays;

public class l00215KthLargestElementinanArray {

    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length -k];

    }

    public static int findKthLargestQuickSort(int[] nums, int k) {
        // 1 2 3 4 5 6
        // 1 2 2 3 3 4 5 6 6
        int l = 0, r= nums.length-1;

        return quickSort(nums, 0, nums.length-1, k);
    }


    public static int c = 0;
    public static int quickSort(int[] nums, int l, int r, int k){
        System.out.println("Start------ " + c + " <> l: " + l + ", r: " +r);
        final int pivot = nums[r];
        int next = l;
        for(int i=l; i < r; ++i){
            if(nums[i] >= pivot){
                swap(nums, next++, i);
            }
            System.out.println(Arrays.toString(nums));
        }
        swap(nums, next, r);

        System.out.println(Arrays.toString(nums));

        final int count = next - l + 1;

        if(count == k){
            return nums[next];
        }
        c++;
        System.out.println("Move pivot to left");
        if(count > k){

            return quickSort(nums, l, next-1, k);
        }

        System.out.println("Move pivot to right");
        return quickSort(nums, next+1, r, k - count);
    }


    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int findKthLargestQuickSort1(int[] nums, int k) {
        // 1 2 3 4 5 6
        // 1 2 2 3 3 4 5 6 6
        int l = 0, r= nums.length-1;

        return quickSort(nums, 0, nums.length-1, k);
    }

    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left], l = left + 1, r = right;

        while(l <= r){
            if(nums[l] < pivot && nums[r] > pivot){
                swap(nums, nums[l++], nums[r--]);
            }
            if(nums[l] >= pivot) ++l;
            if(nums[r] <= pivot) --r;
        }
        swap(nums,nums[left], nums[r]);

        return r;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};

        System.out.println(findKthLargestQuickSort(arr, 2));
    }
}
