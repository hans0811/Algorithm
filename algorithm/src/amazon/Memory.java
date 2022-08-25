package amazon;

/**
 * @author hans
 */
public class Memory {

    public static int findMinimum(int[] process, int k){



        int res = Integer.MAX_VALUE;


        for(int i=0; i < process.length-1; i++){

            int count = 0;
            int sum = 0;

            while( count < k){
                sum += process[i+count];
                count++;
            }

            res = Math.min(res, sum);

        }

        return res;

    }


    public static void main(String[] args) {

        int[] arr = {10, 4, 8, 1};

        System.out.println(findMinimum(arr, 2));

    }
}
