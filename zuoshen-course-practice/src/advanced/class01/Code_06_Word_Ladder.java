package advanced.class01;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Code_06_Word_Ladder {
    /**
     * 六
     * 给定两个单词beginWord和endWord， 还有一本词典是list类型。找到所有从beginWord变到endWord的最短转换路径， 变动的规则是：
     *                  1， 一次只能变一个位置的字符
     *                  2， 每一个转换后的word一定要在list中
     *                  3， 初始时list中没有beginWord这个词
     * 比如
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * 返回：
     * [
     * ["hit","hot","dot","dog","cog"],
     * ["hit","hot","lot","log","cog"]
     * ]
     * 注意：
     * 1， 返回值的类型为List<List<String>>
     * 2， 如果不存在转化路径请返回空链表（不是null）
     * 3， 所有的词一定都是相同长度的
     * 4， 所有词都是小写的a~z
     * 5， 在list中没有重复的词
     * 6， beginWord和endWord都不是空字符串或者null
     */
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        List<List<String>> ladders = findLadders(begin, end, wordList);
        for (int i = 0; i < ladders.size(); i++) {
            List<String> list = ladders.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        wordList.add(beginWord);
        HashMap<String, ArrayList<String>> nexts = getNexts(wordList);
        HashMap<String, Integer> distances = getDistances(beginWord, nexts);
        LinkedList<String> pathList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
        return res;
    }

    //获取每个单词的邻居
    public static HashMap<String, ArrayList<String>> getNexts(List<String> words){
        Set<String> dict = new HashSet<>(words);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), new ArrayList<>());
        }

        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), getNext(words.get(i), dict));
        }
        return nexts;
    }

    public static ArrayList<String> getNext(String word, Set<String> dict){
        ArrayList<String> res = new ArrayList<String>();
        char[] chars = word.toCharArray();
        for (char cur = 'a'; cur <= 'z'; cur++){
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != cur){
                    char tmp = chars[i];
                    chars[i] = cur;
                    if (dict.contains(String.valueOf(chars))){
                        res.add(String.valueOf(chars));
                    }
                    chars[i] = tmp;
                }
            }
        }
        return res;
    }

    public static HashMap<String, Integer> getDistances(String begin, HashMap<String, ArrayList<String>> nexts){
        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(begin, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        HashSet<String> isVisited = new HashSet<>();
        isVisited.add(begin);
        while (!queue.isEmpty()){
            String cur = queue.poll();
            for (String str: nexts.get(cur)) {
                if (!isVisited.contains(str)){
                    distances.put(str, distances.get(cur) + 1);
                    isVisited.add(str);
                    queue.add(str);
                }
            }
        }
        return distances;
    }

    public static void getShortestPaths(String cur,
                                        String end,
                                        HashMap<String, ArrayList<String>> nexts,
                                        HashMap<String, Integer> distances,
                                        LinkedList<String> solution,
                                        List<List<String>> res){
        solution.add(cur);
        if (end.equals(cur)){
            res.add(new LinkedList<String>(solution));
        }else{
            for (String next : nexts.get(cur)) {
                if (distances.get(next) == distances.get(cur) + 1){
                    getShortestPaths(next, end, nexts,  distances, solution, res);
                }
            }
        }
        solution.pollLast();
    }

}
