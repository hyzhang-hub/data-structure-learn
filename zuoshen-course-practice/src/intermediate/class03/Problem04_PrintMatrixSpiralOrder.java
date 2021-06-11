package intermediate.class03;

public class Problem04_PrintMatrixSpiralOrder {
    /**
     * 给定一个正方形矩阵， 只用有限几个变量， 实现矩阵中每个位置的数顺时针转动
     * 90度， 比如如下的矩阵
     * 0 1 2 3
     * 4 5 6 7
     * 8 9 10 11
     * 12 13 14 15
     * 矩阵应该被调整为：
     * 12 8 4 0
     * 13 9 5 1
     * 14 10 6 2
     * 15 11 7 3
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR & tC <= dC){
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC){
        if (tR == dR){
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[i][tR] + " ");
            }
        }else if (tC == dC){
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[tC][i] + " ");
            }
        }else{
            int curC = tC;
            int curR = tR;
            while (curC != dC){
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR){
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC){
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR){
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }
}
