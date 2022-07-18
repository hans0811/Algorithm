package amazon;

public class findMinHealth {

    public static int findMinHealth(int[] power, int armor){

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int n : power){

            sum += n;
            max = Math.max(max, n);
        }

        return sum - Math.min(max , armor) + 1;
    }

    public static void main(String[] args) {

        // sum（power）-min（max（power），armor）+ 1
        int[] power = {1,2,6,7};
        int armor= 5;

        System.out.println(findMinHealth(power, armor));
    }
}
