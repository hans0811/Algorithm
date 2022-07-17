package com.hans.queue;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hans
 */
public class l0279 {

    class customPair{

        public int num;
        public int step;

        public customPair() {
        }

        public customPair(int num, int step) {
            this.num = num;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<customPair> q = new LinkedList<>();
        customPair pair = new customPair(n, 0);
        q.add(pair);

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!q.isEmpty()){

            int num = q.peek().num;
            int step = q.peek().step;
            q.poll();

            if( num == 0) return step;

            for( int i = 1; ; i++){
                int a = num - i*i;

                if(a < 0) break;

                if(a == 0) return step + 1;

                if( !visited[num-i*i]){
                    q.add( new customPair(num - i * i
                            , step + 1) );
                }


            }
        }

        return 0;
    }
}
