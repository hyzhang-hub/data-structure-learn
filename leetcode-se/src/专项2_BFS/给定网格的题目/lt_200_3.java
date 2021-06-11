package 专项2_BFS.给定网格的题目;

public class lt_200_3 {
    class UnionFind{
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid){
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1'){
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i){
            if (parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y){
            int xHead = find(x);
            int yHead = find(y);
            if (xHead != yHead){
                if (rank[xHead] > rank[yHead]){
                    parent[yHead] = xHead;
                }else if(rank[xHead] < rank[yHead]){
                    parent[xHead] = yHead;
                }else {
                    parent[yHead] = xHead;
                    rank[xHead] += 1;
                }
                --count;
            }
        }

        public int getCount(){
            return count;
        }

        public int numIslands(char[][] grid){
            if (grid == null || grid.length == 0){
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;

            UnionFind uf = new UnionFind(grid);
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1'){
                        grid[i][j] = '0';
                        if (i - 1 >= 0 && grid[i][j] == '1'){
                            uf.union(i * n + j, (i - 1) * n + j);
                        }
                        if (i + 1 < m && grid[i][j] == '1'){
                            uf.union(i * n + j, (i + 1) * n + j);
                        }
                        if (j - 1 >= 0 && grid[i][j] == '1'){
                            uf.union(i * n + j, i * n + j - 1);
                        }
                        if (j + 1 < n && grid[i][j] == '1'){
                            uf.union(i * n + j, i * n + j + 1);
                        }
                    }
                }
            }
            return uf.getCount();
        }
    }
    public static void main(String[] args) {
        int i = new lt_200_2().numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}});
        System.out.println(i);


    }
}
class Solution {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }
}

