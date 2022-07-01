package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;

public class L01710MaximumUnitsonATruck {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        for(int i=0; i < boxTypes.length; i++){
            for(int j=0; j < boxTypes.length; j++){
                if( boxTypes[i][1] > boxTypes[j][1]){
                    int[] temp = boxTypes[i];
                    boxTypes[i] = boxTypes[j];
                    boxTypes[j] = temp;
                }
            }
        }

        int capacity = 0;
        int sum = 0;

        for(int i=0; i < boxTypes.length; i++){
            for(int j=1; j < boxTypes[i][0]+1; j++){
                capacity ++;
                sum += boxTypes[i][1];
                if(capacity == truckSize){
                    return sum;
                }
            }
        }
        return sum;

    }

    public static int maximumUnits1(int[][] boxTypes, int truckSize){
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int sum = 0;
        for(int i=0; i < boxTypes.length; i++){
            while(truckSize > 0 && boxTypes[i][0] > 0){
                sum += boxTypes[i][1];
                truckSize --;
                boxTypes[i][0]--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] box = {{1,3},{2,2},{3,1}};

        System.out.println(maximumUnits(box, 4));

    }
}
