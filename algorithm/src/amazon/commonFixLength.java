package amazon;

public class commonFixLength {


    public static int commonPrefix(String input){

        int n = input.length();
        if(n == 0) return 0;

        int res = n;

        char[] arr = input.toCharArray();

        for(int i=1; i<n; i++){
            if(arr[i] == arr[0]){
                res += getPreFixLength(arr, i);
            }
        }

        return res;
    }

    public static int getPreFixLength(char[] arr, int start){
        int res =0, i=0, j=start;

        while(j < arr.length){
            if(arr[i++] == arr[j++]){
                res++;
            }else{
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String str = "abcabcd";

        System.out.println(commonPrefix(str));
    }
}
