package algorithm.array;

import java.util.Arrays;

public class l000135Candy {

    public static int candy(int[] ratings) {
        int res = 0, rateLen= ratings.length;
        int[] distribution = new int[ratings.length];
        // each line at least receive 1 candy
        Arrays.fill(distribution,1);

        // from left to right if right bigger than left then get 1
        // ratings: 1 , 0, 2
        // res    : 1 , 1, 2
        for(int i=0; i < rateLen-1; i ++){
            if(ratings[i + 1] > ratings[i]){
                distribution[i+1] = distribution[i] + 1;
            }
        }

        // from left to right if right bigger than left then get 1
        // distribution: 1 , 0, 2
        // res    : 1 , 1, 2
        for(int i=rateLen-1; i > 0; i--){
            if(ratings[i-1] > ratings[i]){
                distribution[i-1] = Math.max(distribution[i-1], distribution[i]+1);
            }
        }

        for(int n : distribution){
            res += n;
        }

        return res;

    }

    public static int candyOneLoop(int[] ratings) {
        if(ratings.length == 0) return 0;
        int res = 1, pre = 1, cnt =0;

        for(int i=1; i<ratings.length; i++){
            if(ratings[i] >= ratings[i-1]){

                if (cnt > 0){
                    res += cnt * (cnt + 1) /2;
                    if( cnt >= pre ) res += cnt - pre + 1;
                    cnt = 0;
                    pre = 1;
                }
                pre = (ratings[i] == ratings[i-1]) ? 1 : pre +1;
                res += pre;
            }else{
                cnt++;
            }
        }

        if(cnt > 0){
            res += cnt * (cnt+1)/2;
            if( cnt >= pre ) res += cnt - pre + 1;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] rating01 = new int[] {1, 0, 2};

        System.out.println(candy(rating01));
    }


}
