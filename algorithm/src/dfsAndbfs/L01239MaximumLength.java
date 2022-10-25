package com.hans.dfsAndbfs;

import java.util.List;

public class L01239MaximumLength {
    public int res = 0;
    public int maxLength(List<String> arr) {

        if(arr == null || arr.size() == 0){
            return 0;
        }

        dfs(arr, "", 0);

        return res;
    }

    public void dfs(List<String> arr, String path, int index){
        boolean isUnique = checkUnique(path);

        if(isUnique){
            res = Math.max(res, path.length());
        }
        if(index == arr.size() || !isUnique){
            return;
        }

        for(int i=index; i < arr.size(); i++){
            dfs(arr, path+arr.get(i), i + 1);
        }

    }

    public boolean checkUnique(String s){
        boolean[] letters = new boolean[26];
        for(int i=0; i < s.length(); i++){
            if(letters[s.charAt(i) - 'a'] == true){
                return false;
            }
            letters[s.charAt(i) - 'a'] = true;
        }

        return true;
    }
}
