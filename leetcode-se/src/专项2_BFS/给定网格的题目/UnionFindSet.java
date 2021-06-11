package 专项2_BFS.给定网格的题目;

import java.util.HashMap;
import java.util.List;

public class UnionFindSet {
    public static class Node{

        int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public HashMap<Node, Node> fatherMap;
    public HashMap<Node, Integer> sizeMap;

    public UnionFindSet(){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
    }

    public void makeSet(List<Node> nodes){
        fatherMap.clear();
        sizeMap.clear();
        for (Node node : nodes) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public Node findHead(Node node){
        Node father = fatherMap.get(node);
        if (father != node){
            father = findHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public boolean isSameSet(Node a, Node b){
        return findHead(a) == findHead(b);
    }

    public void union(Node a, Node b){
        if (a == null || b == null){
            return;
        }

        Node aHead = findHead(a);
        Node bHead = findHead(b);
        if (aHead != bHead){
            int aSize = sizeMap.get(aHead);
            int bSize = sizeMap.get(bHead);
            if (aSize >= bSize){
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSize + bSize);
            }else{
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSize + bSize);
            }
        }
    }
}
