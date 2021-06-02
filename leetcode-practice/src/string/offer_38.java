package string;

import java.util.ArrayList;

public class offer_38 {
    /**
     * 剑指 Offer 38. 字符串的排列
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * 示例:
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     * 限制：
     * 1 <= s 的长度 <= 8
     */
    public String[] permutation(String s) {
        if (s == null){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();


        process(s.toCharArray(), 0, list);
        String[] res = list.toArray(new String[list.size()]);
        return res;
    }

    public void process(char[] chs, int i, ArrayList<String> res){
        if (i == chs.length){
            res.add(String.valueOf(chs));
        }

        boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']){
                visit[chs[j] - 'a'] = true;
                swap(chs, i, j);
                process(chs, i + 1, res);
                swap(chs, i, j);
            }
        }
    }

    public void swap(char[] chs, int i, int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String[] abcs = new offer_38().permutation("abc");
        for (int i = 0; i < abcs.length; i++) {
            System.out.println(abcs[i]);
        }
    }
}
