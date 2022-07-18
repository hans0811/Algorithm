package amazon;

public class A015_PascalTriangle {

    public static int PascalTriangle(int[] arr){

        for(int i= arr.length; i > 0; i--){

            for(int j=1; j < i; j++){
                arr[j-1] += arr[j];
                arr[j-1] %= 10;
            }
        }

        return arr[0];

    }

    public static void main(String[] args) {

        int[] arr= {4, 5, 6, 7};

        System.out.println(PascalTriangle(arr));
    }
}
