package amazon;

import java.util.HashMap;
import java.util.Map;

public class A002_findMaxStock {

    public static int findMaxStock(int[] stocks, int k){
        if (stocks.length == 0 || k == 0) return 0;     int res = 0, start = 0, count = 0, cur = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // stock => pos
        for(int i = 0; i < stocks.length; i++) {
            if (map.containsKey(stocks[i])) {
                int finalStart = map.get(stocks[i]);
                while(start <= finalStart) {
                    cur -= stocks[start];
                    map.remove(stocks[start]);
                    count--;
                    start++;
                }
            }

            if (count < k) {
                cur += stocks[i];
                count++;
                map.put(stocks[i], i);

                if (count == k) {
                    res = Math.max(res, cur);
                }
            } else {
                cur += stocks[i] - stocks[start];
                map.put(stocks[i], i);
                map.remove(stocks[start]);
                start++;
                res = Math.max(res, cur);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] stocks = {1,2,7,7,4,3,6};

        System.out.println(findMaxStock(stocks, 3));


    }

    }
    // 给一个长度为n的数组表示n个月的股价，给定k值，给连续k月并且k个值各不一样的区间求和，找到最大和。例子：｛1，2，3，4｝，
    // k=2，那总共有(1,2) (2,3)(3,4)三个长度为k的连续区间并且每个区间没有重复数值，最大和是7。
    // int getMaxStock(int[] stocks, int k) {
    // sliding window,
    // if meet duplicated number, move start to last pos in map, remove from map, cur
    // if window < k, add new one to cur, map, window++, if window == k, update res
    // if window == k, add new one to cur, map,  start++, remove old from map, cur, update res
