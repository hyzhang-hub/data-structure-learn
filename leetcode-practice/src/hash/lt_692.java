package hash;

import java.util.*;

public class lt_692 {
    /**
     * 692. 前K个高频单词
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     *
     * 示例 1：
     *
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     *     注意，按字母顺序 "i" 在 "love" 之前。
     * 示例 2：
     *
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     *     出现次数依次为 4, 3, 2 和 1 次。
     * 注意：
     * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
     * 输入的单词均由小写字母组成。
     *  
     */
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> list = new lt_692().topKFrequent(words, k);
        for (String str :
                list) {
            System.out.println(str);
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            cnt.put(words[i], cnt.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry: cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size()>k){
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
