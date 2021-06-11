package intermediate.class03;

import java.util.HashMap;

public class Problem07_TopKTimes2 {
    //堆上放的东西是node类型的实例
    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static class TopKRecord{
        private Node[] heap;
        private int index;//对的大小
        private HashMap<String, Node> strNodeMap;
        private HashMap<Node, Integer> nodeIndexMap;

        public TopKRecord(int K){
            heap = new Node[K];
            index = 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }

        public void add(String str){
            //当前str对应的节点对象
            Node curNode = null;
            // 当前str对应的节点是否在堆上
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)){//str第一次出现
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, -1);
            }else{//并非第一次出现
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if (preIndex == -1){ //当前str对应的节点词频增加之后，不在堆上
                if (index == heap.length){
                    if (heap[0].times < curNode.times){
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, index);
                    }
                }else{
                    nodeIndexMap.put(curNode, index);
                    heap[index] = curNode;
                    heapInsert(index++);
                }
            }else {
                heapify(preIndex, index);
            }
        }

        private void heapInsert(int index){
            while (index != 0){
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times){
                    swap(parent, index);
                    index = parent;
                }else{
                    break;
                }
            }
        }

        private void heapify(int index, int heapSize){
            int l = index * 2 + 1;
            int r = index * 2 + 2;
            int smallest = index;
            while (l < heapSize){
                if (heap[l].times < heap[index].times){
                    smallest = l;
                }
                if (r < heapSize && heap[r].times < heap[smallest].times){
                    smallest = r;
                }
                if (smallest != index){
                    swap(smallest, index);
                }else{
                    break;
                }
                index = smallest;
                l = index * 2 + 1;
                r = index * 2 + 1;
            }
        }

        private void swap(int index1, int index2){
            nodeIndexMap.put(heap[index1], index2);
            nodeIndexMap.put(heap[index2], index1);
            Node tmp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = tmp;
        }


    }
}
