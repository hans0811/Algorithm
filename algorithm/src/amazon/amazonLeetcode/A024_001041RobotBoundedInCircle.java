package amazonLeetcode;

import java.util.ArrayList;

public class A024_001041RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {

        int idx = 0; //0-north, 1 east, 2 south, 3 west

        int[] cur = new int[] {0,0};

        int[][] dirs = new int[][] {{-1, 0}, {0,1}, {1,0}, {0,-1}};

        for(int i =0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'G'){
                cur[0] += dirs[idx][0];
                cur[1] += dirs[idx][1];
            }
        }


        return true;
    }

    public static void main(String[] args) {

    }

}
