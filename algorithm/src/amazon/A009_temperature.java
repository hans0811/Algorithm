package amazon;

public class A009_temperature {

    public static int maxTemperature(int[] temp){

        int[] prefix = new int[temp.length];

        for(int i = 0; i< temp.length; i++){

            int sum = 0;
            for(int j=i ; j < temp.length; j++){
                sum += temp[j];
            }

            int pre =0;
            for(int k=0 ; k <= i; k++){
                pre += temp[k];
            }

            prefix[i] = Math.max(pre, sum);
        }

        int res = Integer.MIN_VALUE;
        for(int n : prefix){
            res = Math.max(n, res);
        }


        return res;

    }

    public static void main(String[] args) {
        int[] tempChange = {6, -2, 5}; // 9
        int[] tempChange1 = {-1, 2, 3}; // 9
        System.out.println(maxTemperature(tempChange1));
    }
}
