package 专项1_DFS.单词搜索类题目;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt_212 {
    /**
     * 212. 单词搜索 II
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母在一个单词中不允许被重复使用。
     *
     * 示例 1：
     *
     * 输入：board = [["o","a","a","n"],
     *              ["e","t","a","e"],
     *              ["i","h","k","r"],
     *              ["i","f","l","v"]], words = ["oath","pea","eat","rain"]
     * 输出：["eat","oath"]
     * 示例 2：
     * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
     * 输出：[]
     *
     * 提示：
     *
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 12
     * board[i][j] 是一个小写英文字母
     * 1 <= words.length <= 3 * 104
     * 1 <= words[i].length <= 10
     * words[i] 由小写英文字母组成
     * words 中的所有字符串互不相同
     */
    char[][] board;
    ArrayList<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        //根据words建立前缀树
        for (String word:words) {
            TrieNode node = root;
            for (Character letter:word.toCharArray()) {
                if (node.children.containsKey(letter)){
                    node = node.children.get(letter);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        this.board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children.containsKey(board[row][col])){
                    backtrcking(row, col, root);
                }
            }
        }
        return res;
    }

    private void backtrcking(int row, int col, TrieNode root){
        Character letter = board[row][col];
        TrieNode curNode = root.children.get(letter);

        if (curNode.word != null){
            this.res.add(curNode.word);
            curNode.word = null;
        }

        this.board[row][col] = '#';
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] direction:directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length){
                continue;
            }
            if (curNode.children.containsKey(board[newRow][newCol])){
                backtrcking(newRow, newCol, curNode);
            }
        }

        board[row][col] = letter;

        if (curNode.children.isEmpty()){
            root.children.remove(letter);
        }
    }

}
class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode(){

    }


}
