package advanced.class02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code_04_Group_Anagrams {
    /**
     * 如果str1和str2包含的字符种类一样， 并且每种字符的个数也
     * 一样， 那么str1和str2算作变形词。
     * 给定一个字符类型的数组， 请把变形词分组。 比如
     * 输入：
     * ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出：
     * [
     * ["ate", "eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ] 注
     * 意： 所有的字符都是小写。
     */
    public List<List<String>> groupAnagrams1(String[] strs){
        return null;
    }

    public List<List<String>> groupAnagrams2(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] record = new int[26];
            for (char ch:str.toCharArray()) {
                record[ch - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < record.length; i++) {
                builder.append(String.valueOf(record[i])).append("_");
            }
            String key = builder.toString();
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        ArrayList<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Code_04_Group_Anagrams().groupAnagrams2(strs);
        for (List<String> list:
        lists){
            for (String str:list
                 ) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
