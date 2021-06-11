package 专项1_DFS.单词搜索类题目;

public class lt_79 {
    /**
     * 79. 单词搜索
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。

     * 示例 1：
     * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
     * 输出：true
     *
     * 示例 2：
     * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
     * 输出：true
     * 示例 3：
     * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCB'
     * 输出：false
     *
     * 提示：
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
     */
    public static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][] isVisited;
    private char[] charArray;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        if (this.rows == 0){
            return false;
        }
        this.cols = board[0].length;
        this.isVisited = new boolean[rows][cols];
        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (process(i, j, 0)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean process(int i, int j, int begin){
        if (begin == len - 1){
            return board[i][j] == charArray[begin];
        }

        if (board[i][j] == charArray[begin]){
            isVisited[i][j] = true;
            for (int[] direction : DIRECTIONS){
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
    private boolean inArea(int i, int j){
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        boolean abcced = new lt_79().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED");
        System.out.println(abcced);


    }
}
