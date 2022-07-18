package amazon;

public class L1492ThekthFactorofn {

    public static int kthFactor(int n, int k) {
        for(int i = 1, cnt = 0; i <= n; i++)
            if(n % i == 0 && ++cnt == k) return i;
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(kthFactor(12, 3));
    }
}
