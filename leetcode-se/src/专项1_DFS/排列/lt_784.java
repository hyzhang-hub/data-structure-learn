package 专项1_DFS.排列;

import java.util.ArrayList;
import java.util.List;

public class lt_784 {
    /**
     * 784. 字母大小写全排列
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     * 示例：
     * 输入：S = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * 输入：S = "3z4"
     * 输出：["3z4", "3Z4"]
     *
     * 输入：S = "12345"
     * 输出：["12345"]
     * 提示：
     * S 的长度不超过12。
     * S 仅由数字和字母组成。
     */
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0){
            return null;
        }
        List<String> res = new ArrayList<>();
        process(s.toCharArray(), 0, res);
        return res;
    }

    public void process(char[] chs, int i, List<String> res){
        if (i == chs.length){
            res.add(String.valueOf(chs));
            return;
        }

        process(chs, i + 1, res);
        if (Character.isLetter(chs[i])){
            chs[i] ^= 1 << 5;
            process(chs, i + 1, res);
        }

    }

    public static void main(String[] args) {
        List<String> list = new lt_784().letterCasePermutation("a1b2");
        for (String str:list
             ) {
            System.out.println(str);
        }
    }


}
