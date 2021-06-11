package 专项1_DFS.排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lt_mianshi_0807 {
    /**
     * 面试题 08.07. 无重复字符串的排列组合
     * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
     *
     * 示例1:
     *
     *  输入：S = "qwe"
     *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
     * 示例2:
     *
     *  输入：S = "ab"
     *  输出：["ab", "ba"]
     * 提示:
     *
     * 字符都是英文字母。
     * 字符串长度在[1, 9]之间。
     */
    public String[] permutation(String S) {
        if (S == null || S.length() == 0){
            return null;
        }
        char[] chars = S.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        process(chars, 0, res);
        res.sort(null);
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

    public static void main(String[] args) {
        String[] abcs = new lt_mianshi_0807().permutation("123");
        for (int i = 0; i < abcs.length; i++) {
            System.out.println(abcs[i]);
        }
    }

}
