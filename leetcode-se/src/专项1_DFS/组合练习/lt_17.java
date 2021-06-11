package 专项1_DFS.组合练习;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt_17 {
    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *
     * 提示：
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     */
    HashMap<String, String> map;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() <= 0 ||  digits.length() > 4){
            return res;
        }
        generateStr();
        process(digits,0, res, new StringBuffer());
        return res;
    }

    public void process(String digits, int index, List<String> res, StringBuffer sb){
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters  = map.get(String.valueOf(digit));
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            process(digits, index + 1, res, sb);
            sb.deleteCharAt(index);
        }

    }
    public void generateStr(){
        map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    public static void main(String[] args) {
        List<String> list = new lt_17().letterCombinations("23");
        for (String str :
                list) {
            System.out.println(str);
        }
    }
}
