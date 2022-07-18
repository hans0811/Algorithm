package amazon;

import java.util.ArrayList;
import java.util.List;

public class A022_maxConsecutiveOnes {

    public static List<Integer> maxConsecutiveOnes(int[] arr , int m){

        int left =0;
        List<Integer> list = new ArrayList<>();

        for(int right=0; right < arr.length; right++){
            if(arr[right] == 0){
                m--;
                list.add(right);
            }

            if(m < 0 && arr[left++] == 0){
                m++;
                list.remove(0);

            }
        }

        return list;


    }

    public static void main(String[] args) {

        int[] arr1 = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};

        System.out.println(maxConsecutiveOnes(arr1, 2)); // {5,7}

        System.out.println(maxConsecutiveOnes(arr1, 1)); // {7}

        int[] arr2 = {0,0,0,1};

        System.out.println(maxConsecutiveOnes(arr2, 4));
    }
}
