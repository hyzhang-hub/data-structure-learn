package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SplittableRandom;

public class lt_49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] record = new int[26];
            for (char ch : str.toCharArray()) {
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
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
