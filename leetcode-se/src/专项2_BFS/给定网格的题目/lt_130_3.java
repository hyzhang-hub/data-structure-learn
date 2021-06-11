package 专项2_BFS.给定网格的题目;

public class lt_130_3 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        //用一个虚拟节点，边界上的0的父节点都是这个虚拟节点
        UnionFind uf = new UnionFind(m * n + 1);
        int dummyNode = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    //遇到'O'进行并查集操作合并
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1){
                        uf.union(node(i, j, n), dummyNode);
                    }else{
                        if (i > 0 && board[i - 1][j] == 'O'){
                            uf.union(node(i, j, n), node(i - 1, j, n));
                        }
                        if (i < m - 1 && board[i + 1][j] == 'O'){
                            uf.union(node(i, j, n), node(i + 1, j, n));
                        }
                        if (j > 0 && board[i][j - 1] == 'O'){
                            uf.union(node(i, j, n), node(i, j - 1, n));
                        }
                        if (j < n - 1 && board[i][j + 1] == 'O'){
                            uf.union(node(i, j, n), node(i, j + 1, n));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (uf.isConnected(node(i,j,n), dummyNode)){
                    board[i][j] = 'O';
                } else{
                    board[i][j] = 'X';
                }
            }
        }


    }
    int node(int i, int j, int cols){
        return i * cols + j;
    }

}
class UnionFind {
    int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }
    // 合并连通区域是通过find来操作的, 即看这两个节点是不是在一个连通区域内.
    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    int find(int node) {
        while (parents[node] != node) {
            // 当前节点的父节点 指向父节点的父节点.
            // 保证一个连通区域最终的parents只有一个.
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}