package 专项1_DFS.单词搜索类题目;

public class offer_12 {
    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
     *
     * 示例 1：
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     *
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     *
     *
     * 提示：
     *
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * board 和 word 仅由大小写英文字母组成
     */
    private final int[][] DIRECTION = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] isVisited;
    private int rows;
    private int cols;
    private int len;
    private char[] chs;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0){
            return false;
        }
        cols = board[0].length;
        len = word.length();
        chs = word.toCharArray();
        this.board = board;
        isVisited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(process(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean process(int i, int j, int begin){
        if (begin == len - 1){
            return chs[begin] == board[i][j];
        }
        if (chs[begin] == board[i][j]){
            isVisited[i][j] = true;
            for (int[] direction:DIRECTION) {
                int newI = i + direction[0];
                int newJ = j + direction[1];
                if (inArea(newI, newJ) && !isVisited[newI][newJ]){
                    if (process(newI, newJ, begin + 1)){
                        return true;
                    }
                }
            }
            isVisited[i][j] = false;
        }
        return false;
    }

    public boolean inArea(int i, int j){
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        boolean abcced = new offer_12().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCEE");
        System.out.println(abcced);
    }
}
