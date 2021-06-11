package 专项2_BFS.给定网格的题目;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class lt_130_2 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                bfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O'){
                bfs(board, i, n - 1);
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O'){
                bfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O'){
                bfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void bfs(char[][] board, int i, int j){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i, j));
        board[i][j] = '#';
        while (!queue.isEmpty()){
            Pos cur = queue.poll();
            if (cur.i - 1 >= 0 && board[cur.i - 1][cur.j] == 'O'){
                queue.add(new Pos(cur.i - 1, cur.j));
                board[cur.i - 1][cur.j] = '#';
            }
            if (cur.i + 1 < board.length && board[cur.i + 1][cur.j] == 'O'){
                queue.add(new Pos(cur.i + 1, cur.j));
                board[cur.i + 1][cur.j] = '#';
            }
            if (cur.j - 1 >= 0 && board[cur.i][cur.j - 1] == 'O'){
                queue.add(new Pos(cur.i, cur.j - 1));
                board[cur.i][cur.j - 1] = '#';
            }
            if (cur.j + 1 < board[0].length && board[cur.i][cur.j + 1] == 'O'){
                queue.add(new Pos(cur.i, cur.j + 1));
                board[cur.i][cur.j + 1] = '#';
            }
        }
    }
}

class Pos{
    int i;
    int j;
    Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}
