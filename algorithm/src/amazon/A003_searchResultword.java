package amazon;

public class A003_searchResultword {

    public static void main(String[] args) {

        String s1 = "armaze";
        String s2 = "amazon";


        int sl = 0;

        int rl =0;

        while(sl < s1.length()-1){
            if(s1.charAt(sl) == s2.charAt(rl)){
                sl++;
                rl++;
            }else{
                if(sl < s1.length()){
                    while(s1.charAt(sl) != s2.charAt(rl)){
                        sl++;
                    }
                }
            }
        }

        System.out.println(s2.length()-rl);
    }
}
