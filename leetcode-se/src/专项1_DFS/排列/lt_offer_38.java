package 专项1_DFS.排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lt_offer_38 {
    /**
     *
     */
    public String[] permutation(String S) {
        if (S == null || S.length() == 0){
            return null;
        }
        char[] chars = S.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        process(chars, 0, res);
        return res.toArray(new String[res.size()]);
    }

    public void process(char[] chars, int i, List<String> res){
        if (i == chars.length){
            res.add(String.valueOf(chars));
        }

//        boolean[] isUsed = new boolean[26];
        HashSet<Character> isUsed = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if (!isUsed.contains(chars[j])){
                isUsed.add(chars[j]);
                swap(chars, i, j);
                process(chars, i + 1, res);
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
