package primary.graph;

import java.util.*;

public class Code04_Kruskal {
    /**
     * kruskal算法
     * 适用范围： 要求无向图
     */
    public static class UnionFind{
        //key:某个节点
        //value：该节点父节点
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> rankMap;

        public UnionFind(){
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
        }

        private Node findFather(Node node){
            Node father = fatherMap.get(node);
            if (father != node){
                father = findFather(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public void makeSets(Collection<Node> nodes){
            fatherMap.clear();
            rankMap.clear();
            for (Node node :nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node a, Node b){
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b){
            if (a == null || b == null){
                return;
            }

            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if (aFather != bFather){
                int aFrank = rankMap.get(aFather);
                int bFrank = rankMap.get(bFather);
                if (aFrank <= bFrank){
                    fatherMap.put(aFather, bFather);
                    rankMap.put(bFather, aFrank + bFrank);
                }else{
                    fatherMap.put(bFather, aFather);
                    rankMap.put(aFather, aFrank + bFrank);
                }
            }
        }
    }

    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)){
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
