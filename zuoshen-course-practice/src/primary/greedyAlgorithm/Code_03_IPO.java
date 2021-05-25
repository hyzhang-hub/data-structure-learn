package primary.greedyAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_03_IPO {

    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }

    /**
     * 输入：
     * 正数数组costs
     * 正数数组profits
     * 正数k
     * 正数m
     * 含义：
     * costs[i]表示i号项目的花费
     * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
     * k表示你只能串行的最多做k个项目
     * m表示你初始的资金
     * 说明：
     * 你每做完一个项目， 马上获得的收益， 可以支持你去做下一个项目。
     * 输出：
     * 你最后获得的最大钱数。
     * @param k
     * @param w
     * @param profits
     * @param Capital
     * @return
     */

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] Capital){
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.c - o2.c;
            }
        });
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.p - o1.p;
            }
        });
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }

        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w){
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()){
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;


    }

}
