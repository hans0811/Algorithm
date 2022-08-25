package amazon;

public class searchResultword {
//https://assessments.amazon.jobs/?auth=5QNd5wSK-5oD6amCuq3NQOBQYJrSp5HuM5hivUFnXMw&locale=en-US#/assessment/Hire_4173df2b-828f-41d0-b561-b2def846715e
    //https://www.hackerrank.com/test/1b71ip6b6cq/login?b=eyJ1c2VybmFtZSI6ImFtYXpvbl9ob29rKzYxMGQ0ODE4LTBhODUtNDBkOC1iZGMxLWE2OGY0ZmI3ZjQyMkBob29rLmNvbSIsInBhc3N3b3JkIjoiZTMzOTczNjciLCJoaWRlIjp0cnVlLCJoaWRlU3dpdGNoQWNjb3VudCI6ZmFsc2UsImhpZGVTaGFyZUhhY2tlclByb2ZpbGUiOmZhbHNlLCJhY2NvbW1vZGF0aW9ucyI6bnVsbH0=
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
