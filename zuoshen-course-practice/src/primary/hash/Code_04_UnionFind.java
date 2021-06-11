package primary.hash;

import java.util.HashMap;
import java.util.List;

public class Code_04_UnionFind {
    public static class Node {
        int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(List<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for (Node node:nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            if (node != father){
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
                if (aSize <= bSize){
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSize + bSize);
                }else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSize + bSize);
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
