package amazonLeetcode;

public class A010_00547NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {

        int res = 0;
        for(int i=0; i < isConnected.length; i++){
            if(isConnected[i][i] == 0) continue;
            dfs(isConnected, i);
            res++;
        }

        return res;
    }

    public static void dfs(int[][] isConnect, int idx){
        if(isConnect[idx][idx] == 0){
            return;
        }

        isConnect[idx][idx] = 0;

        for(int i=0; i < isConnect.length; i++){
            if(isConnect[idx][i] == 0 ) continue;
            dfs(isConnect, i);
        }
    }

    public static void main(String[] args) {
        int[][] connect = {{1,1,0}, {1,1,0}, {0,0,1}};

    }
}
