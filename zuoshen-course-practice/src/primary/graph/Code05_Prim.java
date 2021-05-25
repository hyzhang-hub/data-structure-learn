package primary.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Code05_Prim {
    /**
     * prim算法
     * 适用范围： 要求无向图
     */
    public static Set<Edge> primMST(Graph graph){
        //解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>(); // 一次挑选的边在result里
        for (Node node : graph.nodes.values()) {//随机挑选一个节点
            if (!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();//弹出解锁的边中，最小的边
                    Node toNode = edge.to;//可能的一个新的节点
                    if (!set.contains(toNode)){//不含有的时候，就是新的节点
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge :
                                toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }

                }
            }
        }
        return result;
    }
}
